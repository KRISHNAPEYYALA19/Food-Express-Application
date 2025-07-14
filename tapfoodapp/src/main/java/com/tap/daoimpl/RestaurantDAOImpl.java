package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.models.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    private final String INSERT = "INSERT INTO restaurant(name, cuisineType, deliveryTime, address, adminUserId, rating, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String GET_BY_ID = "SELECT * FROM restaurant WHERE restaurantId = ?";
    private final String UPDATE = "UPDATE restaurant SET name = ?, cuisineType = ?, deliveryTime = ?, address = ?, adminUserId = ?, rating = ?, isActive = ?, imagePath = ? WHERE restaurantId = ?";
    private final String DELETE = "DELETE FROM restaurant WHERE restaurantId = ?";
    private final String GET_ALL_RESTAURANTS = "SELECT * FROM `restaurant`";

    @Override
    public void addRestaurant(Restaurant restaurant) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {

            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getCuisineType());
            stmt.setInt(3, restaurant.getDeliveryTime());
            stmt.setString(4, restaurant.getAddress());
            stmt.setInt(5, restaurant.getAdminUserId());
            stmt.setDouble(6, restaurant.getRating());
            stmt.setBoolean(7, restaurant.getIsActive());
            stmt.setString(8, restaurant.getImagePath());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                restaurant = new Restaurant(
                        rs.getInt("restaurantId"),
                        rs.getString("name"),
                        rs.getString("cuisineType"),
                        rs.getInt("deliveryTime"),
                        rs.getString("address"),
                        rs.getInt("adminUserId"),
                        rs.getDouble("rating"),
                        rs.getBoolean("isActive"),
                        rs.getString("imagePath")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {

            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getCuisineType());
            stmt.setInt(3, restaurant.getDeliveryTime());
            stmt.setString(4, restaurant.getAddress());
            stmt.setInt(5, restaurant.getAdminUserId());
            stmt.setDouble(6, restaurant.getRating());
            stmt.setBoolean(7, restaurant.getIsActive());
            stmt.setString(8, restaurant.getImagePath());
            stmt.setInt(9, restaurant.getRestaurantId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_RESTAURANTS);
             ResultSet resultSet = prepareStatement.executeQuery()) {

            while (resultSet.next()) {
                int restaurantId = resultSet.getInt("restaurantId");
                String name = resultSet.getString("name");
                String cuisineType = resultSet.getString("cuisineType");
                int deliveryTime = resultSet.getInt("deliveryTime");
                String address = resultSet.getString("address");
                int adminUserId = resultSet.getInt("adminUserId");
                double rating = resultSet.getDouble("rating");
                boolean isActive = resultSet.getBoolean("isActive");
                String imagePath = resultSet.getString("imagePath");

                Restaurant restaurant = new Restaurant(
                    restaurantId, name, cuisineType, deliveryTime,
                    address, adminUserId, rating, isActive, imagePath
                );
                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantList;
    }

}
