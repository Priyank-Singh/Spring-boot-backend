package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
 @Id
   private long id;
   private String reviewer_name;
   private String review;
   private long product_id;
   private boolean approved;

   public Review(long id, String reviewer_name, String review,long product_id,boolean approved) {
      super();
      this.id = id;
      this.reviewer_name = reviewer_name;
      this.review = review;
      this.product_id = product_id;
      this.approved = approved;
   }
   
   
   public Review() {
      super();
      // TODO Auto-generated constructor stub
   }
   public long getId() {
      return id;
   }
   public void setId(long id) {
      this.id = id;
   }
   public String getReviewer_name() {
      return reviewer_name;
   }
   public void setReviewer_name(String reviewer_name) {
      this.reviewer_name = reviewer_name;
   }
   public String getReview() {
      return review;
   }
   public void setReview(String review) {
      this.review = review;
   }
   public long getProduct_id() {
	   return  product_id;
   }
   public void setProduct_id(long product_id)
   {
	   this.product_id = product_id;
   }
   public boolean getApproved() {
	   return approved;
   }
   public void setApproved(boolean approved) {
	   this.approved = approved;
   }
   
   


   @Override
   public String toString() {
      return "Review [id=" + id + ", reviewer_name=" + reviewer_name + ", review=" + review + " ]";
   }
   
}
