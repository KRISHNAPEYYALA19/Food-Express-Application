package com.tap.servlet;

import com.tap.daoimpl.UserDAOImpl;
import com.tap.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phoneNumber");
        String address = req.getParameter("address");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        user.setAddress(address);
        user.setRole("Customer");
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));

        UserDAOImpl dao = new UserDAOImpl();
     // Check if user already exists
        if (dao.userExists(email)) {
            // Redirect back to signup page with error
            resp.sendRedirect("signup.jsp?error=exists");
            return;
        }

        dao.addUser(user);

        resp.sendRedirect("login.jsp");
    }
}
