package com.tap.models;
//1.Create the instance variables
//2.Create a Default Constructor
//3.Create parameterized Constructor
//4.provide the Setters() & Getters()
//5.also provide the overridden toString() method to overcome the hashCode problem

//6.default toString() method provides Class@HashCode 
//7.but custom toString() method provides meaningful data

import java.sql.Timestamp;

public class User {

	private int userId;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private String address;
	private String role;
	private Timestamp createdDate;
	private Timestamp lastLoginDate; 
	 public User(){
		
	}
	

	public User(int userId, String username, String password, String email, String phoneNumber, String address,
			String role, Timestamp createdDate, Timestamp lastLoginDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	@Override
	public String toString() {
		return "User [" +userId+ " " +username+" " +email+ " "+ phoneNumber+ " " + address + " "+ role + "]";
	}
	 
	
	
	
	
	
}
