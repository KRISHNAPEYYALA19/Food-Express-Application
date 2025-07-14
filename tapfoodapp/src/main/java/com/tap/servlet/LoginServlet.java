package com.tap.servlet;

import com.tap.daoimpl.UserDAOImpl;
import com.tap.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String email = req.getParameter("email");
	        String password = req.getParameter("password");

	        UserDAOImpl dao = new UserDAOImpl();
	        User user = dao.getUserByEmailAndPassword(email, password);

	        if (user != null) {
	            HttpSession session = req.getSession();
	            
	            // ✅ Store user object and individual fields
	            session.setAttribute("loggedInUser", user); // useful if needed later

	            // ✅ These are needed for profile.jsp
	            session.setAttribute("username", user.getUsername());
	            session.setAttribute("email", user.getEmail());
	            session.setAttribute("phone", user.getPhoneNumber());
	            session.setAttribute("address", user.getAddress());

	            resp.sendRedirect("restaurant"); // or menu.jsp
	        } else {
	            resp.sendRedirect("login.jsp?error=invalid");
	        }
	    }
	}