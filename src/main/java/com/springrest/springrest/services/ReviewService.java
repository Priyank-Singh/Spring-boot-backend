package com.springrest.springrest.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.entities.Review;

public interface ReviewService {
   
   public List<Review> getReview();
   
   public Review addReview(Review review);
   
   public Review updateReview(Review review);
   
   public void deleteReview(long parseLong);
   
   public void approve_review(long id);
  

}
