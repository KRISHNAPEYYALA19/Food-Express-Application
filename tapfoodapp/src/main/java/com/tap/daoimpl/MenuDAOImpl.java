package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.MenuDAO;
import com.tap.models.Menu;
import com.tap.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {
    private String INSERT = "INSERT INTO menu (restaurantId, itemname, description, price, isAvailable, imagePath) VALUES (?, ?, ?, ?, ?, ?)";
    private String GET_BY_ID = "SELECT * FROM menu WHERE menuId = ?";
    private String UPDATE = "UPDATE menu SET restaurantId = ?, itemname = ?, description = ?, price = ?, isAvailable = ?, imagePath = ? WHERE menuId = ?";
    private String DELETE = "DELETE FROM menu WHERE menuId = ?";
    private String GET_ALL = "SELECT * FROM menu";
    private String QUERY = "SELECT * FROM menu WHERE restaurantId = ?";

    public void addMenu(Menu menu) {
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getItemName());
            stmt.setString(3, menu.getDescription());
            stmt.setDouble(4, menu.getPrice());
            stmt.setBoolean(5, menu.isAvailable());
            stmt.setString(6, menu.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Menu getMenuById(int menuId) {
        Menu menu = null;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(GET_BY_ID)) {
            stmt.setInt(1, menuId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                menu = new Menu(
                    rs.getInt("menuId"),
                    rs.getInt("restaurantId"),
                    rs.getString("itemname"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getBoolean("isAvailable"),
                    rs.getString("imagePath")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    public void updateMenu(Menu menu) {
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getItemName());
            stmt.setString(3, menu.getDescription());
            stmt.setDouble(4, menu.getPrice());
            stmt.setBoolean(5, menu.isAvailable());
            stmt.setString(6, menu.getImagePath());
            stmt.setInt(7, menu.getMenuId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMenu(int menuId) {
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, menuId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Menu> getAllMenusByRestaurants(int restaurantId) {
        List<Menu> menuList = new ArrayList<>();


        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {

            preparedStatement.setInt(1, restaurantId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Menu menu = new Menu();

                    menu.setMenuId(resultSet.getInt("menuId"));
                    menu.setRestaurantId(resultSet.getInt("restaurantId"));
                    menu.setItemName(resultSet.getString("itemName"));
                    menu.setDescription(resultSet.getString("description"));
                    menu.setPrice(resultSet.getDouble("price"));
                    menu.setAvailable(resultSet.getBoolean("isAvailable"));
                    menu.setImagePath(resultSet.getString("imagePath"));

                    menuList.add(menu);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
    }

}
