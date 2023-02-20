package com.example.userCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.userCrud.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
