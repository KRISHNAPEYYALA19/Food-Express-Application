package com.tap.dao;

import java.util.List;
import com.tap.models.OrderItem;

public interface OrderItemDAO {
    void addOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(int orderItemId);
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(int orderItemId);
    List<OrderItem> getAllOrderItems();
}