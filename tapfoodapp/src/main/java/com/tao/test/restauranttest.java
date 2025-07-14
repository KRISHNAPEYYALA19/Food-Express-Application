package com.tao.test;

import java.util.List;

import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.models.Restaurant;

public class restauranttest  extends RestaurantDAOImpl{
	public static void main(String[] args) {
		RestaurantDAOImpl dao = new RestaurantDAOImpl();
		 List<Restaurant> list = dao.getAllRestaurants();
		System.out.println("testing");
		for(Restaurant restaurantlist : list) {
			System.out.println(restaurantlist);
		}
		
		
	}

}
