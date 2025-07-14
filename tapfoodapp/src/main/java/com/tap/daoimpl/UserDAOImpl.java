package com.tap.daoimpl;
//1.implement the class to interface

//2.import the interface
//3.provide the body to abstract methods
//4.pass the Connection con type & PreparedStatement pstmt  into the try(con;pstmt){}
//5.also give the placeholders to the columns directly
//6.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.models.User;
import com.tap.util.DBConnection;

public class UserDAOImpl implements UserDAO{

//	Query should be inside the class only.
	
    
    private String INSERT = "INSERT INTO `User` (`username`,`password`,`email`,"
    		      + "`phonenumber`,`address`,`role`,`created_date`,"
    		      + "`last_login_date`) values (?,?,?,?,?,?,?,?)";
    		
    private String USERID = "SELECT * from `user` WHERE  `userid` = ?";
    String UPDATE_USER = "UPDATE `user`  SET  `username`= ? ,`password` = ? ,`email` = ? , `phonenumber` = ?, "
    		           + " `address` = ? ,`role` = ?, `created_date` = ? , `last_login_date` = ? WHERE `userid` = ?";
    private String DELETE = "DELETE from `user` where  `userid` = ?";
    private String GET_ALL_USERS ="select * from `user`";
  @Override
	public void addUser(User user) {
//try() with resources in exception will start the resources and it will close the resources..
//	  we can use finally block/to close resources.
	
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement prepareStatement= connection.prepareStatement(INSERT);)
		{
			
			//value,placeholder
		prepareStatement.setString(1,user.getUsername());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.setString(3, user.getEmail());
		prepareStatement.setString(4, user.getPhoneNumber());
		prepareStatement.setString(5, user.getAddress()); 
		prepareStatement.setString(6, user.getRole());
		prepareStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));//Used to create the date
		prepareStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
		
		
		int i = prepareStatement.executeUpdate();
		System.out.println(i);
		 System.out.println("Row Inserted");
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserById(int userId) {
		User user = null; //initialize it to null (no value at start)
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(USERID);) 
		{
			
			prepareStatement.setInt(1, userId);
			
			
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) { //if there is any data it will give true
				int userid = resultSet.getInt("userid");//column name
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String phonenumber = resultSet.getString("phonenumber");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				String role = resultSet.getString("role");
				Timestamp createdDate= resultSet.getTimestamp("created_date");
				Timestamp lastLoginDate= resultSet.getTimestamp("last_login_date");
//				we have all the data create a object of class and call the perfect constructor.
				
			 user = new User(userid,username,password,email,phonenumber,address,role,createdDate,lastLoginDate);	
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement prepareStatement= connection.prepareStatement(UPDATE_USER);     )
		{
		
		prepareStatement.setString(1,user.getUsername());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.setString(3, user.getEmail());
		prepareStatement.setString(4, user.getPhoneNumber());
		prepareStatement.setString(5, user.getAddress());
		prepareStatement.setString(6, user.getRole());
		prepareStatement.setTimestamp(7, user.getCreatedDate());//Used to update the date 
		prepareStatement.setTimestamp(8, user.getLastLoginDate());
		prepareStatement.setInt(9, user.getUserId());//Important other-wise it will get duplictae errors
		
		int i = prepareStatement.executeUpdate();
		System.out.println(i);
	
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
	@Override
	public void deleteUser(int userId) {

		try(Connection connection = DBConnection.getConnection();
		PreparedStatement prepareStatement= connection.prepareStatement(DELETE); )
	{
			prepareStatement.setInt(1,userId);
			int i = prepareStatement.executeUpdate();
			System.out.println(i + " user deleted");
			
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
 }
	
	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement prepareStatement= connection.prepareStatement(GET_ALL_USERS); 
			ResultSet resultSet = prepareStatement.executeQuery())
			{

		        while (resultSet.next()) {
		            int userId = resultSet.getInt("userid");
		            String username = resultSet.getString("username");
		            String password = resultSet.getString("password");
		            String email = resultSet.getString("email");
		            String phoneNumber = resultSet.getString("phonenumber");
		            String address = resultSet.getString("address");
		            String role = resultSet.getString("role");
		            Timestamp createdDate = resultSet.getTimestamp("created_date");
		            Timestamp lastLoginDate = resultSet.getTimestamp("last_login_date");

		            User user = new User(userId, username, password, email, phoneNumber, address, role, createdDate, lastLoginDate);
		            userList.add(user);
		        }
			
			}catch(SQLException e) {
				e.printStackTrace();
			}

		return userList;
	}
	
//	by email and password
	
	
	public User getUserByEmailAndPassword(String email, String password) {
	    String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, email);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return new User(
	                rs.getInt("userid"),
	                rs.getString("username"),
	                rs.getString("password"),
	                rs.getString("email"),
	                rs.getString("phonenumber"),
	                rs.getString("address"),
	                rs.getString("role"),
	                rs.getTimestamp("created_date"),
	                rs.getTimestamp("last_login_date")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	
	public boolean userExists(String email) {
	    boolean exists = false;
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE email = ?")) {
	        ps.setString(1, email);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            exists = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return exists;
	}

	
	
	
	
	
	
	
	
	
	
}
