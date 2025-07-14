package com.tap.launchs;
import java.util.List;
import java.util.Scanner;

import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.models.Restaurant;

public class LaunchRestaurant {

    public static void main(String[] args) {

        // ✅ 1. Insert Restaurant
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter restaurant ID:");
        int id = scan.nextInt();
        System.out.println("Enter restaurant name:");
        String name = scan.next();
        System.out.println("Enter cuisine type:");
        String cuisineType = scan.next();
        System.out.println("Enter delivery time (in minutes):");
        int deliveryTime = scan.nextInt();
        System.out.println("Enter address:");
        String address = scan.next();
        System.out.println("Enter admin user ID:");
        int adminUserId = scan.nextInt();
        System.out.println("Enter rating:");
        double rating = scan.nextDouble();
        System.out.println("Is active (true/false):");
        boolean isActive = scan.nextBoolean();
        System.out.println("Enter image path:");
        String imagePath = scan.next();

        Restaurant restaurant = new Restaurant(id, name, cuisineType, deliveryTime, address, adminUserId, rating, isActive, imagePath);
        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        dao.addRestaurant(restaurant);
        */

        // ✅ 2. Get Restaurant by ID
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter restaurant ID:");
        int id = scan.nextInt();
        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        Restaurant restaurant = dao.getRestaurantById(id);
        System.out.println(restaurant);
        */

        // ✅ 3. Update Restaurant
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter restaurant ID:");
        int id = scan.nextInt();
        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        Restaurant restaurant = dao.getRestaurantById(id);
        restaurant.setCuisineType("SouthIndian");
        restaurant.setRating(4.8);
        dao.updateRestaurant(restaurant);
        */

        // ✅ 4. Delete Restaurant
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter restaurant ID:");
        int id = scan.nextInt();
        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        dao.deleteRestaurant(id);
        */

        // ✅ 5. Get All Restaurants
        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        List<Restaurant> list = dao.getAllRestaurants();

        for (Restaurant restaurant : list) {
            System.out.println(restaurant);
        }
    }
}
