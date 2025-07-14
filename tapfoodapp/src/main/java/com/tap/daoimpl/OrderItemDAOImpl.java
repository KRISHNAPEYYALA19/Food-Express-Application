package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.OrderItemDAO;
import com.tap.models.OrderItem;
import com.tap.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private final String INSERT = "INSERT INTO orderitem (orderid, menuid, totalamount) VALUES (?, ?, ?,?)";
    private final String SELECT_BY_ID = "SELECT * FROM orderitem WHERE orderitemid = ?";
    private final String UPDATE = "UPDATE orderitem SET orderid = ?, menuid = ?, totalamount = ? WHERE orderitemid = ?";
    private final String DELETE = "DELETE FROM orderitem WHERE orderitemid = ?";
    private final String GET_ALL = "SELECT * FROM orderitem";

    @Override
    public void addOrderItem(OrderItem orderItem) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, orderItem.getOrderId());
            ps.setInt(2, orderItem.getMenuId());
            ps.setDouble(3, orderItem.getTotalAmount());
            System.out.println(ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItemById(int orderItemId) {
        OrderItem orderItem = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, orderItemId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderItem = new OrderItem(
                    rs.getInt("orderitemid"),
                    rs.getInt("orderid"),
                    rs.getInt("menuid"),
                    rs.getDouble("totalamount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, orderItem.getOrderId());
            ps.setInt(2, orderItem.getMenuId());
            ps.setDouble(3, orderItem.getTotalAmount());
            ps.setInt(4, orderItem.getOrderItemId());
            System.out.println(ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE)) {
            ps.setInt(1, orderItemId);
            System.out.println(ps.executeUpdate() + " OrderItem deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                OrderItem item = new OrderItem(
                    rs.getInt("orderitemid"),
                    rs.getInt("orderid"),
                    rs.getInt("menuid"),
                    rs.getDouble("totalamount")
                );
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}