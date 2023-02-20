package com.example.userCrud.service;

import java.util.List;

import com.example.userCrud.entity.User;

public interface UserService {
    
	User saveUser(User user);
	List<User> fetchUsers();
	User updateUser(User user,Long Id);
	Void deleteUser(Long Id);
}
