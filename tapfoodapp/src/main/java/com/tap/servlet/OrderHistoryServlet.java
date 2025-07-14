package com.tap.servlet;

import java.util.List;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderDAOImpl;
import com.tap.models.Order;
import com.tap.models.User;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession(false);
	    User user = (User) session.getAttribute("loggedInUser");

	    if (user != null) {
	        OrderDAOImpl orderDAO = new OrderDAOImpl();
	        List<Order> orders = orderDAO.getOrdersByUserId(user.getUserId());

	        req.setAttribute("orders", orders);
	        req.getRequestDispatcher("order_history.jsp").forward(req, resp);
	    } else {
	        resp.sendRedirect("login.jsp");
	    }
	}

}

