package com.tap.dao;

import java.util.List;
import com.tap.models.Menu;

public interface MenuDAO {
    void addMenu(Menu menu);
    Menu getMenuById(int menuId);
    void updateMenu(Menu menu);
    void deleteMenu(int menuId);
    List<Menu> getAllMenusByRestaurants(int restaurantId);
    
}