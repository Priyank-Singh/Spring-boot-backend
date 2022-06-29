package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.ReviewDao;
//import com.springrest.springrest.dao.ReviewDao;
import com.springrest.springrest.entities.Review;
@Service
public class ReviewServiceImpl implements ReviewService {
   
     @Autowired
     private ReviewDao reviewDao;
//   List<Review> list;
//   List<Review> list1;
   public ReviewServiceImpl()
   {

   }

   public List<Review> getReview() 
   {
      // TODO Auto-generated method stub
        return reviewDao.findAll();

   }

   public Review addReview(Review review) 
   {
      // TODO Auto-generated method stub
//      list.add(review);
      reviewDao.save(review);
      return review;
   }
   
   public Review updateReview(Review review)
   {

      reviewDao.save(review); // here i have used the same function as used in add review because it works in a way that add entity if entity not present and updates it , if it already exists.
      return review;
   }
// 
   public void deleteReview(long parseLong)
   {
     Review entity  = reviewDao.getOne(parseLong);
     reviewDao.delete(entity);

//    list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
   }
   
   public void approve_review(long review_id)
   {
	   List<Review> list = getReview();
	   for(Review rvw : list)
	   {
		   if(rvw.getId() == review_id)
		   {
			  rvw.setApproved(true); 
			  reviewDao.save(rvw);
			  return;
		   }
	   }
   }


}
