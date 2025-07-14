<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.models.Menu, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Menu Items</title>
  <style>
  body{
   background-color: #f9f9f9; 
   color: #333333;             
   margin: 0;
   padding: 0;
  }
    .menu-container {
  display: grid;
  grid-template-columns: repeat(4, 1fr);  
  gap: 20px;
  padding: 20px;
}


    .menu-card {
      width: 280px;
      background-color: white;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0,0,0,0.1);
      overflow: hidden;
    }

    .menu-image {
      width: 100%;
      height: 140px;
      object-fit: cover;
    }

    .menu-details {
      padding: 10px;
    }

    .menu-name {
      font-weight: bold;
      font-size: 16px;
      margin-bottom: 5px;
    }

    .menu-description {
      font-size: 14px;
      color: #555;
      margin-bottom: 8px;
    }

    .menu-price {
      font-size: 15px;
      color: green;
    }
    .add-to-cart-btn {
  background-color: #ff7043;
  border: none;
  border-radius: 6px;
  padding: 10px 16px;
  font-size: 14px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s ease;
  margin-top: 10px;
  width: 100%;
}

.add-to-cart-btn:hover {
   background-color: #f4511e;
  transform: scale(1.03);
}
    
  </style>
</head>
<body>

<center> <div style="background-color: #ff5722; padding: 20px 0; text-align: center;">
    <h1 style="color: white; margin: 0; font-size: 32px;">Menu</h1>
  </div></center>
<%
  List<Menu> menuList = (List<Menu>) request.getAttribute("allMenus");
  if (menuList != null && !menuList.isEmpty()) {
%>
  <div class="menu-container"><!-- only single container is needed -->
    <% for (Menu m : menuList) {
    %>
    
      <div class="menu-card" >
        <img src="<%= m.getImagePath() %>" class="menu-image" alt="menu">
        <div class="menu-details">
          <div class="menu-name"><%= m.getItemName() %></div>
          <div class="menu-description"><%= m.getDescription() %></div>
          <div class="menu-price">₹<%= m.getPrice() %></div>
          
          <form action ="cart" method ="post">
          <!-- change type = number to hidden -->
          <input type = "hidden" name = "itemId" value ="<%= m.getMenuId() %>">
          <input type = "hidden" name = "restaurantId" value ="<%= m.getRestaurantId() %>">
          <input type = "hidden" name = "quantity" value ="1">
          <input type = "hidden" name = "action" value ="add"><!-- we should not use method because it is a reserved wordcan cause problems -->
          <input type = "submit" value = "AddToCart" class="add-to-cart-btn">
          </form>
          
          
          
          
        </div>
      </div>
    <% } %>
  </div>
<% } else { %>
  <p>No menu items available for this restaurant.</p>
<% } %>

</body>
</html>
