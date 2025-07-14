package com.tap.daoimpl;

import java.sql.*;
import java.util.*;

import com.tap.dao.OrderDAO;
import com.tap.models.Order;
import com.tap.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	int orderId = 0;
    private final String INSERT = "INSERT INTO `order` (userId, restaurantId, orderDate, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SELECT_BY_ID = "SELECT * FROM `order` WHERE orderId = ?";
    private final String UPDATE = "UPDATE `order` SET userId = ?, restaurantId = ?, orderDate = ?, totalAmount = ?, status = ?, paymentMode = ? WHERE orderId = ?";
    private final String DELETE = "DELETE FROM `order` WHERE orderId = ?";
    private final String SELECT_ALL = "SELECT * FROM `order`";

    @Override
    public int addOrder(Order order) {
        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(INSERT)) 
        	PreparedStatement pstmt = conn.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setTimestamp(3, order.getOrderDate());
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMode());

            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            while(keys.next()) {
             orderId = keys.getInt(1);
            	
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {

            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                order = new Order(
                        rs.getInt("orderId"),
                        rs.getInt("userId"),
                        rs.getInt("restaurantId"),
                        rs.getTimestamp("orderDate"),
                        rs.getDouble("totalAmount"),
                        rs.getString("status"),
                        rs.getString("paymentMode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setTimestamp(3, order.getOrderDate());
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMode());
            pstmt.setInt(7, order.getOrderId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("orderId"),
                        rs.getInt("userId"),
                        rs.getInt("restaurantId"),
                        rs.getTimestamp("orderDate"),
                        rs.getDouble("totalAmount"),
                        rs.getString("status"),
                        rs.getString("paymentMode")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    
    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM `order` WHERE userId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getInt("restaurantId"),
                    rs.getTimestamp("orderDate"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentMode")
                );
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    
    
}

