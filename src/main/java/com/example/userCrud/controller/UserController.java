package com.example.userCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userCrud.entity.User;
import com.example.userCrud.service.UserService;

@RestController
class UserController {
  @Autowired
  private UserService userService;
  
  @PostMapping("/users")
  public User saveUser(@RequestBody User user) {
	  return userService.saveUser(user);
  }
  
  @GetMapping("users")
  public List<User> fetchUsers(){
	  return userService.fetchUsers();
  }
  
  @PutMapping("/users/{id}")
  public User updateUser(@RequestBody User user , @PathVariable("id") Long Id) {
	  return userService.updateUser(user, Id);
  }
  
  @DeleteMapping("/users/{id}")
  public String deleteUser(@PathVariable("id") Long Id) {
	  userService.deleteUser(Id);
	  return "User deleted successfully"; 
  }
  
  
  
}
