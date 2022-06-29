package com.springrest.springrest.services;
  
//import java.util.ArrayList;
import com.springrest.springrest.dao.ProductDao;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

//import com.springrest.springrest.dao.ProductDao;
import com.springrest.springrest.entities.Product;
@Service
public class ProductServiceImpl implements ProductService {
   
 @Autowired
 private ProductDao productDao;
//   List<Product> list;
//   List<Product> list1;
   public ProductServiceImpl()
   {
//      list = new ArrayList();
//      long code = 500;
//      list.add(new Product(code,"Hand-bag","Zara"));
//      list.add(new Product(1001,"Wallet","Calvin Klein"));
      
   }

   public List<Product> getProduct() 
   {
      // TODO Auto-generated method stub
        return productDao.findAll();
//      return list;
   }

   public Product addProduct(Product product) 
   {
      // TODO Auto-generated method stub
//      list.add(product);
      productDao.save(product);
      return product;
   }
   
   public Product getById(long parseLong) {
       return productDao.findById(parseLong).get();
   }
    
   public Product updateProduct(Product product)
   {
//      for(Product x : list)
//      {
//         if(x.getId() == product.getId())
//         {
//            x.setBrand(product.getBrand());
//            x.setName(product.getName());
//         }
//      }
      productDao.save(product); // here i have used the same function as used in add product because it works in a way that add entity if entity not present and updates it , if it already exists.
      return product;
   }
// 
//   @SuppressWarnings("deprecation")
public void deleteProduct(long parseLong)
   {   
        Product entity  = productDao.getOne(parseLong);
        productDao.delete(entity);
   }
public List<Product> getProductsbyName(String name)
{
	List<Product> list = getProduct();
	List<Long> mylist = new ArrayList<Long>();
	for(Product pro : list)
	{
		if(pro.getName().equals(name))mylist.add(pro.getId());
	}
	return productDao.findAllById(mylist);
}

public List<Product> getProductsbyBrand(String brand)
{
	List<Product> list = getProduct();
	List<Long> mylist = new ArrayList<Long>();
	for(Product pro : list)
	{
		if(pro.getBrand().equals(brand))mylist.add(pro.getId());
	}
	return productDao.findAllById(mylist);
}

public List<Product> getProductPrices(List<Long> ids) {
	// TODO Auto-generated method stub
  
	  List<Product> list = productDao.findAllById(ids);
	  List<Product> mylist = new ArrayList<Product>();
	  for(Product p : list)
	  {
		  Product pro = new Product(p.getPrice()); 
		  mylist.add(pro);
	  }
      return mylist;
      

}




}
