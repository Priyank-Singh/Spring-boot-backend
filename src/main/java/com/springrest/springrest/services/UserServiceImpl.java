package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.dao.UserDao;
//import com.springrest.springrest.dao.UserDao;
import com.springrest.springrest.entities.User;
@Service
public class UserServiceImpl implements UserService {
   
  @Autowired
  private UserDao userDao;
  public int foo = 0;

   public UserServiceImpl()
   {
          
   }

   public List<User> getUser() 
   {
      // TODO Auto-generated method stub
      return userDao.findAll();

   }

   public User addUser(User user) 
   {
      // TODO Auto-generated method stub

	  foo = 0;
	  List<User> list = new ArrayList<User>();
	  list = getUser();
	  for(User u : list)
	  {
		  if(u.getId() == user.getId())
		  {
			  foo = 1;
			  break;
		  }
	  }
	  if(foo == 1)
		  {
		    foo = 0;
		    return null;
		  }
      userDao.save(user);
      return user;
   }
   
   public User updateUser(User user)
   {

      userDao.save(user); // here i have used the same function as used in add user because it works in a way that add entity if entity not present and updates it , if it already exists.
      return user;
   }

   public void deleteUser(long parseLong)
   {
      User entity  = userDao.getOne(parseLong);
      userDao.delete(entity);
   }
   
   public void approve_request(long user_id)
   {
	   List<User> list = getUser();
	   for(User u : list)
	   {
		   if(u.getId() == user_id)
		   {
			   u.setCan_review(true);
			   userDao.save(u);
			   return;
		   }
	   }
   }


}
