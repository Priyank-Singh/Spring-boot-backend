package com.springrest.springrest.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.springrest.springrest.entities.User;

public interface UserService {
   
   public List<User> getUser();
   
   public User addUser(User user);
   
   public User updateUser(User user);
   
   public void deleteUser(long parseLong);
   
   public void approve_request(long user_id);
   

}
