package com.tap.dao;

import java.util.List;
import com.tap.models.Restaurant;

public interface RestaurantDAO {
    void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(int id);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int id);
    List<Restaurant> getAllRestaurants();
}
