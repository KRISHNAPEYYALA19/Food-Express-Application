package com.tap.dao;

import java.util.List;
import com.tap.models.Order;

public interface OrderDAO {
    int addOrder(Order order);
    Order getOrderById(int orderId);
    List<Order> getOrdersByUserId(int userId);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
    List<Order> getAllOrders();
}
