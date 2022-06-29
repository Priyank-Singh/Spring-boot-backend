package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Product;
import com.springrest.springrest.entities.Review;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.ProductService;
import com.springrest.springrest.services.ReviewService;
import com.springrest.springrest.services.UserService;
import com.springrest.springrest.services.UserServiceImpl;

import java.util.*;

@RestController
public class MyController 
{
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/home")
	public String home() {

		return "product portal";
	}
    @GetMapping("/name/{name}")// search product by name
	public List<Product> getProductsbyName(@PathVariable String name) 
    {
        return this.productService.getProductsbyName(name);   
	}	
    @GetMapping("/brand/{brand}") // search product by brand
	public List<Product> getProductsbyBrand(@PathVariable String brand) 
    {
        return this.productService.getProductsbyBrand(brand);   
	}	 
    
    @GetMapping("/products/{Ids}") // returns information about prices of multiple products
	public List<Product> getProductPrices(@PathVariable List<Long> Ids) 
    {
        return this.productService.getProductPrices(Ids);   
	}
    

    @GetMapping("/product") // list of all available products
	public List<Product> getProduct() 
    {
       return this.productService.getProduct();   
	}
    
    @GetMapping("/product/{id}") // single product by id
    public ResponseEntity<Product> getById(@PathVariable long id) {
        try {
            Product product = productService.getById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @GetMapping("/user")  // all users
	public List<User> getUser() 
    {
       return this.userService.getUser();   
	}
    
    @GetMapping("/review") // all reviews
	public List<Review> getReview() 
    {
       return this.reviewService.getReview();   
	}  
    
    
    @PostMapping("/product")  // add product
    public Product addProduct(@RequestBody Product product )
    {
       return this.productService.addProduct(product);	
    }
    
    @PostMapping("/user")  // add user with authentication
    public String addUser(@RequestBody User user)
    {

        User u =  this.userService.addUser(user);
        if(u == null)return "INVALID USER AUTHENTICATION ,USER WITH THIS ID ALREADY EXITS";
        else return "User Successfully Registered";
    }
    @PostMapping("/review") //  add review
    public Review addReview(@RequestBody Review review )
    {
       return this.reviewService.addReview(review);	
    }  
    @GetMapping("/stats") // get current  statistics
    public String getStats()
    {
    	List<User> usr = userService.getUser();
    	List<Product> pro = productService.getProduct();
    	List<Review> rvw = reviewService.getReview();
    	
    	int user_count = usr.size();
    	int product_count = pro.size();
    	int review_count = rvw.size();
    	
    	String s = "";
    	s += "Number of users = " + user_count + ", Number of products = " + product_count + ", Number of reviews = " + review_count;
    	return s;
    	
    }
       

    
    
    @PutMapping("/product")
    public Product UpdateProduct(@RequestBody Product product)
    {
    	return this.productService.updateProduct(product);
    }
    @PutMapping("/user")
    public User UpdateUser(@RequestBody User user)
    {
    	return this.userService.updateUser(user);
    }
    @PutMapping("/review")
    public Review UpdateReview(@RequestBody Review review)
    {
    	return this.reviewService.updateReview(review);
    }
    
    @PutMapping("/review_approve/{id}")  // approve a product by eligible user, review_id is passed as PthVariable and user_id approving the review is taken as input from console.
    public String approve_review(@PathVariable long id)
    {
    	List<User> usr = getUser();
 
    	Scanner obj = new Scanner(System.in);
    	System.out.println("please enter user_id"); // this is to be entered in console after making this API call
    	int n = obj.nextInt();
    	long user_id = n; // this user id will mark the review as approved. I AM taking this as user input as of now just to make sure that my API is working fine. 
    	long review_id = id;
    	for(User u : usr)
    	{
    		if(u.getId() == user_id)
    		{
    			
    			if(u.getCan_review() == false) //  if the user in not eligible to approve
    			{
    				
    				return "Sorry, the given user with id = " + user_id + " is not allowed to approve a Review";
    			}
    			else break; // eligible to approve
    		}
    	}
   
      	this.reviewService.approve_review(review_id);
      	return "Review Approved";
    }
    @PutMapping("/review_approve_request/{id}") // make an user eligible for approving any review
    public void approve_request(@PathVariable long id)
    {
      	this.userService.approve_request(id);
    }
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId)
    {
    	try
    	{
    		this.productService.deleteProduct(Long.parseLong(productId));
    		return new ResponseEntity(HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId)
    {
    	try
    	{
    		this.userService.deleteUser(Long.parseLong(userId));
    		return new ResponseEntity(HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable String reviewId)
    {
    	try
    	{
    		this.reviewService.deleteReview(Long.parseLong(reviewId));
    		return new ResponseEntity(HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
