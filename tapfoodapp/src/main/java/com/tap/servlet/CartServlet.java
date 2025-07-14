package com.tap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
import com.tap.models.Menu;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        String restaurantId = req.getParameter("restaurantId");
        if (restaurantId == null) {
            resp.sendRedirect("menu.jsp");
            return;
        }

        int newRestaurantId = Integer.parseInt(restaurantId);
        Integer oldRestaurantId = (Integer) session.getAttribute("sessrestaurantId");

        if (cart == null || oldRestaurantId == null || !oldRestaurantId.equals(newRestaurantId)) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("sessrestaurantId", newRestaurantId);
        }

        
        
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            addItemToCart(req, cart);  
            session.setAttribute("cart", cart);
        } else if ("update".equals(action)) {
            updateCartItem(req, cart);
        } else if ("remove".equals(action)) {
            removeItemFromCart(req, cart);
        }

        resp.sendRedirect("cart.jsp");
    }

    
    
    
    private void addItemToCart(HttpServletRequest req, Cart cart) {
        try {
            String itemIdStr = req.getParameter("itemId");
            String quantityStr = req.getParameter("quantity");

            if (itemIdStr == null || quantityStr == null) return;

            int itemId = Integer.parseInt(itemIdStr);
            int quantity = Integer.parseInt(quantityStr);

            MenuDAOImpl dao = new MenuDAOImpl();
            Menu menuItem = dao.getMenuById(itemId);

            if (menuItem != null) {
                CartItem item = new CartItem(
                    menuItem.getMenuId(),
                    menuItem.getItemName(),
                    quantity,
                    menuItem.getPrice(),
                    menuItem.getImagePath()
                   
                );
                cart.addCartItem(item);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    private void updateCartItem(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.updateItem(itemId, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
     

    private void removeItemFromCart(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            cart.removeCartItem(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
