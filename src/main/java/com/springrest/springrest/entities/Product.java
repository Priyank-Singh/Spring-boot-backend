package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
   @Id
   private long id;
   
   private String name;
   private String brand;
   private long price;

 
   public Product(long id, String name, String brand,long price) {
      super();
      this.id = id;
      this.name = name;
      this.brand = brand;
      this.price = price;
 
      
   }
   
   public Product(long price) // created separately for the API where only the price is needed.
   {
	   super();
	   this.price = price;
   }
   
   public Product() {
      super();
      // TODO Auto-generated constructor stub
   }
   
   public long getId() {
      return id;
   }
   
   public void setId(long id) {
      this.id = id;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String getBrand() {
      return brand;
   }
   
   public void setBrand(String brand) {
      this.brand = brand;
   }
   
   public long getPrice(){
	   return price;
   }
   
   public void setPrice(long price) {
	   this.price = price;
   }

   @Override
   public String toString() {
      return "Product [id=" + id + ", name=" + name + ", brand=" + brand + " ]";
   }
   
}
