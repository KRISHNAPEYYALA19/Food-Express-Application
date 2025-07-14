<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.models.User" %>
<%
    User user = (User) session.getAttribute("loggedInUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>My Profile</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      background-color:#f5f5f5;
      font-family: 'Segoe UI', sans-serif;
    }

    .profile-container {
      max-width: 700px;
      margin: 50px auto;
      background-color: white;
      padding: 40px;
      border-radius: 16px;
      box-shadow: 0 6px 18px rgba(0,0,0,0.1);
    }

    h2 {
      text-align: center;
      color: #ff5722;
      margin-bottom: 30px;
    }

    .profile-row {
      display: flex;
      justify-content: space-between;
      padding: 12px 0;
      border-bottom: 1px solid #eee;
    }

    .profile-label {
      font-weight: bold;
      color: #333;
    }

    .profile-value {
      color: #555;
    }

    .profile-pic {
      text-align: center;
      margin-bottom: 30px;
    }

    .profile-pic img {
      width: 100px;
      height: 100px;
      border-radius: 50%;
      border: 3px solid #ff5722;
      background-color: #fff3e0;
    }
    .logout-form {
  text-align: center;
  margin-top: 40px;
}

.logout-btn {
  padding: 12px 30px;
  background-color: #ff5722;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.logout-btn:hover {
  background-color: #e64a19;
}
    
  </style>
</head>
<body>
<div style="background-color: #ff5722; padding: 20px 0; text-align: center;">
  <h1 style="color: white; margin: 0; font-size: 32px;">My Profile</h1>
</div>

  <div class="profile-container">
    <div class="profile-pic">
      <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" alt="User">
    </div>
    <h2>User Profile</h2>
    <div class="profile-row">
      <div class="profile-label">Username:</div>
      <div class="profile-value"><%= user.getUsername() %></div>
    </div>
    <div class="profile-row">
      <div class="profile-label">Email:</div>
      <div class="profile-value"><%= user.getEmail() %></div>
    </div>
    <div class="profile-row">
      <div class="profile-label">Phone Number:</div>
      <div class="profile-value"><%= user.getPhoneNumber() %></div>
    </div>
    <div class="profile-row">
      <div class="profile-label">Address:</div>
      <div class="profile-value"><%= user.getAddress() %></div>
    </div>
    <div class="profile-row">
      <div class="profile-label">Role:</div>
      <div class="profile-value"><%= user.getRole() %></div>
    </div>
    <div class="profile-row">
      <div class="profile-label">Created Date:</div>
      <div class="profile-value"><%= user.getCreatedDate() %></div>
    </div>
    <div class="profile-row">
      <div class="profile-label">Last Login:</div>
      <div class="profile-value"><%= user.getLastLoginDate() %></div>
    </div>
    <form action="logout.jsp" method="post" class="logout-form">
  <button type="submit" class="logout-btn">Logout</button>
</form>
    
    
    
  </div>
</body>
</html>
