package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
   @Id
   private long id;
   private String name;
   private String location;
   private String email;
   private String dob;
   private boolean can_review;
   public User(long id, String name, String location, String email, String dob,boolean can_review) {
      super();
      this.id = id;
      this.name = name;
      this.location = location;
      this.email = email;
      this.dob = dob;
      this.can_review = can_review;
   }
   
   public User() {
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
   public String getLocation() {
      return location;
   }
   public void setLocation(String location) {
      this.location = location;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getDob() {
      return dob;
   }
   public void setDob(String dob) {
      this.dob = dob;
   }
   public boolean getCan_review() {
	   return can_review;
   }
   public void setCan_review(boolean can_review) {
	   this.can_review = can_review;
   }
   @Override
   public String toString() {
      return "User [id=" + id + ", name=" + name + ", location=" + location + ", email=" + email + ", dob=" + dob
            + "]";
   }
   

}
