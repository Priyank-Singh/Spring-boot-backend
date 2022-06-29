package com.springrest.springrest.services;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.springrest.springrest.entities.Product;

public interface ProductService {
   
   public List<Product> getProduct();
   
   public Product addProduct(Product product);
   
   public Product updateProduct(Product product);
   
   public void deleteProduct(long parseLong);
   
   public Product getById(long parseLong);
   
   public List<Product> getProductPrices(List<Long> ids);
   
   public List<Product> getProductsbyName(String name);
   
   public List<Product> getProductsbyBrand(String brand);
  
}
