package com.tap.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.OrderDAO;
import com.tap.daoimpl.OrderDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;
import com.tap.models.Cart;
import com.tap.models.CartItem;
import com.tap.models.Order;
import com.tap.models.OrderItem;
import com.tap.models.User;


@WebServlet("/checkout")
public class CheckoutServlet  extends HttpServlet{
	
	
	private OrderDAO orderDAO;//it is a instance variable it can be accessed from other methods.
	 private OrderItemDAOImpl orderItemDAOImpl;
//	call init() before calling service().
	
	
	@Override
	public void init() {
	 orderDAO = new OrderDAOImpl();//object of Order table is created 
		                           //because to insert data inside the Order database.
	 orderItemDAOImpl = new OrderItemDAOImpl();
		
	}	
	
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart)  session.getAttribute("cart");
		User user  = (User) session.getAttribute("loggedInUser");
		
		if(cart != null &&  !cart.getItems().isEmpty()) {
			
			String paymentMethod = req.getParameter("paymentMethod");
			String address = req.getParameter("address");
			
			
			Order order = new Order();
			order.setUserId(user.getUserId());
			order.setRestaurantId((int)session.getAttribute("sessrestaurantId"));
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setPaymentMode(paymentMethod);
			order.setStatus("pending");
			
			
			double totalAmount = 0;
			for(CartItem item : cart.getItems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
				
			}
			order.setTotalAmount(totalAmount);
			int orderId = orderDAO.addOrder(order);
//			we have inserted order into database but not the order items for that do this
			
			
			
			for(CartItem item : cart.getItems().values()) {
				int itemId = item.getItemId();
				double price = item.getPrice();
				int quantity = item.getQuantity();
				double totalPrice = item.getTotalPrice();
				
				OrderItem orderItem = new OrderItem(orderId , itemId, quantity, totalPrice);
				orderItemDAOImpl.addOrderItem(orderItem);
				
			}
			System.out.println("Order ID: " + orderId);
//			System.out.println("Adding order item: " + item.getItemId() + " x " + item.getQuantity());

//			Bangalore, BTM-Layout 1st stage Guru Sai PG
			
			
			
			
			
//			after adding order to table remove the items from cart
			session.removeAttribute("cart");//Clear the cart
			session.setAttribute("order", order);
			
			resp.sendRedirect("order_confirmation.jsp");
		}else {
			resp.sendRedirect("cart.jsp");
		}
	
	
	}

}
