package com.tap.launchs;
import java.util.List;
import java.util.Scanner;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.models.User;

//1.Get the user input in Launch Class
//2.By creating Scanner Class ..use next() for string & nextInt() for integer
//3.Create the object for the class provide the only used columns in the constructor 
//4.Create the object of implemented class to call the method and pass the reference of User class
public class Launch {

	public static void  main(String[] args) {

		/*1.Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Id:");
		int userid = scan.nextInt();
		System.out.println("Enter the username:");
		String username = scan.next();
		System.out.println("Enter the password:");
		String password = scan.next();
		System.out.println("Enter the email:");
		String  email = scan.next();
		System.out.println("Enter the phonenumber:");
		String phonenumber = scan.next();
		System.out.println("Enter the address:");
		String address = scan.next();
		System.out.println("Enter the role:");
		String role = scan.next();
		User user = new User(userid, username,password,email,phonenumber,address,role, null, null);
		UserDAOImpl dao= new UserDAOImpl();
		dao.addUser(user);*/
		
		/*2.Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Id:");
		int userid = scan.nextInt();
		UserDAOImpl dao = new UserDAOImpl();
		User user = dao.getUserById(userid);
		System.out.println(user);*/
		/*3.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the userId");
		int userid = scan.nextInt();
		UserDAOImpl dao = new UserDAOImpl();
		User user = dao.getUserById(userid);
		user.setPassword("kittu");
		user.setAddress("Proddatur");
		dao.updateUser(user);*/
		/*4.
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the userId");
		int userid = scan.nextInt();
		UserDAOImpl dao = new UserDAOImpl();
		dao.deleteUser(userid);*/
		
		UserDAOImpl dao = new UserDAOImpl();
		List<User> users = dao.getAllUsers();
		
		for(User user : users) {
			System.out.println(user);
		}
		
		
		
		
		 
		
 
	}

}
