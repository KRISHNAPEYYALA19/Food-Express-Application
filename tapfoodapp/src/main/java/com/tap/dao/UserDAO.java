package com.tap.dao;
//1.provide the abstract methods for interface UserDAO
//2.import the class from "model class"
//3.Also import the List from util package 

import java.util.List;

import com.tap.models.User;

public interface UserDAO {
	
	void addUser(User user);
	User getUserById(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();//List takes generics
	
	

}
