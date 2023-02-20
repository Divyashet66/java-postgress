package com.example.userCrud.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userCrud.entity.User;
import com.example.userCrud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> fetchUsers(){
		return (List<User>)userRepository.findAll();
	}
	
	@Override
	public User updateUser(User user,Long Id) {
		User userDB = userRepository.findById(Id).get();
		
		if (Objects.nonNull(user.getName())
	            && !"".equalsIgnoreCase(
	                user.getName())) {
	           userDB.setName(
	                user.getName());
	        }
	 
	        if (Objects.nonNull(
	                user.getEmail())
	            && !"".equalsIgnoreCase(
	                user.getEmail())) {
	           userDB.setEmail(
	                user.getEmail());
	        }
	 
	        if (Objects.nonNull(user.getPassword())
	            && !"".equalsIgnoreCase(
	                user.getPassword())) {
	           userDB.setPassword(
	                user.getPassword());
	        }
	 
	        return userRepository.save(userDB);
	}
	
	 @Override
	    public Void deleteUser(Long Id)
	    {
	        userRepository.deleteById(Id);
	     return null;
	
        }
	 }
