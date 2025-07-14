<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="com.tap.models.Restaurant,java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
   <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
  <title>Food Delivery - Restaurants</title>
  <style>
    * {
      box-sizing: border-box;
      font-family: Arial, sans-serif;
    }

    body {
      margin: 0;
      padding: 20px;
      background-color: #f0f0f0;
    }

    h1 {
      text-align: center;
      margin-bottom: 30px;
      color: #333;
    }

.restaurant-container { 
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 20px;
  padding: 20px;
  background-color: #f9f9f9;
}

.restaurant-card {
  width: 250px;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  background-color: #ffffff;
  transition: transform 0.3s ease;
}

.restaurant-card:hover {
  transform: translateY(-5px);
}

.restaurant-image {
  width: 100%;
  height: 160px;
  object-fit: cover;
  border-bottom: 1px solid #eee;
}

.restaurant-content {
  padding: 15px;
}

.restaurant-name {
  font-size: 18px;
  font-weight: bold;
  color: #333;
  margin-bottom: 8px;
}

.rating-eta {
  font-size: 14px;
  gap:3px;
  color: green;
  display: flex;
  justify-content:space-between;
  margin-bottom: 8px;
}

.cuisinetype,
.address {
  font-size: 14px;
  color: black;
  margin-bottom: 4px;
}

    /* Responsive design */
    @media (max-width: 1024px) {
      .restaurant-container {
        grid-template-columns: repeat(2, 1fr);
      }
    }

    @media (max-width: 600px) {
      .restaurant-container {
        grid-template-columns: 1fr;
      }
    }
    
    .project-name {
  font-size: 30px; 
  font-weight: bold;
}
.header-icons {
  display: flex;
  gap: 20px;
  font-size: 24px;
  align-items: center;
  margin-left: 30px;
  cursor: pointer;
}

.header-icons i {
  transition: transform 0.2s ease;
}

.header-icons i:hover {
  transform: scale(1.2);
  color: #ffe082;
}

.site-header {
  position: relative;
  height: 100px;
  top: 0;
  left: 0;
  right: 0;
  background-color: #ff5722;
  color: white;
  padding: 30px 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 1000;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}
.profile-icon {
  position: absolute;
  bottom: 28px;
  right: 10px;
  text-decoration: none;
}

.profile-icon img {
  width: 32px;
  height: 32px;
  border-radius: 50%;
  border: 2px solid #fc8019;
  background-color: white;
  padding: 2px;
  transition: transform 0.3s ease;
}

.profile-icon img:hover {
  transform: scale(1.1);
}


    /* Footer */
.site-footer {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: #333;
  color: white;
  display: flex;
  justify-content: space-around;
  padding: 30px 10px;
  font-size: 14px;
  text-align: left;
  flex-wrap: wrap;
    position: relative;
}

.footer-section {
  flex: 1 1 200px;
  margin: 10px;
}

.footer-section h3 {
  margin-bottom: 10px;
  font-size: 16px;
}

.footer-section a {
  color: #f0a500;
  text-decoration: none;
}

.footer-section a:hover {
  text-decoration: underline;
}

  </style>
</head>
<body>

<!-- we need to get the details from req object(have all restaurants) 
in jsp use scriptlet tag
copy the variable from setAttribute and paste in getAttribute
getAttribute returns Object type convert to Restaurant  type
Restaurant  type == class import the class,List also
use a for each loop to bring the all restaurants

add header & footer to home page-->
<!-- Header -->
  <header class="site-header">
  <div class = "project-name">🍽️Food Express</div>
  <div class="header-icons">
     <input type ="text">
     <i class="ri-search-line"></i>
     <a href="cart.jsp">
     <i class="ri-shopping-cart-2-line" style="font-size: 28px; color: white;"></i></a>
    <i class="ri-logout-box-line"></i>
    <a href="profile.jsp" title="My Profile" class="profile-icon">
  <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" alt="Profile" />
</a>
    
  </div>
  </header>
	<%
	List<Restaurant> list =( List<Restaurant> )request.getAttribute("restaurant");
		if(list != null && !list.isEmpty()){
    %>
	<div class="restaurant-container">
	<!-- Move the <div class="restaurant-container"> above the loop, 
	so that all cards go inside one container. -->
	<%
	for (Restaurant r : list ) {
		
	%>
		
		<div class="restaurant-card">
		<!-- important to go from home page to menu page create anchor tag and provide the menu.jsp file to go -->
		
		<a href = "menu?restaurantId=<%= r.getRestaurantId() %>"
				style ="text-decoration:none;color:inherit;">
			<img class="restaurant-image" src="<%= r.getImagePath() %> ">
			<div class="restaurant-content">
				<div class="restaurant-name"><%= r.getName() %></div>
				<div class="rating-eta">
					<span>⭐<%= r.getRating() %></span><span><%= r.getDeliveryTime() %>mins</span>
				</div>
				<div class="cuisinetype">Type:<%= r.getCuisineType() %></div>
				<div class="address">Address:<%= r.getAddress() %></div>
			</div>
			</a>
		</div>
	<%
	}
	}else {
	%>
	<div class = "no restaurants">
	<p>No restaurants available at the moment.</p>
	</div>
	<%
	}
	%>
	</div>
	
	<!-- FOOTER -->
<footer class="site-footer">
  <div class="footer-section">
    <h3>Contact</h3>
    <p>About us</p>
    <p>Team</p>
    <p>Email: support@foodexpress.com</p>
    <p>Phone: 8897760521</p>
  </div>
  <div class="footer-section">
    <h3>Legal</h3>
    <p><a href="#">Privacy & Policy</a></p>
    <p><a href="#">Terms & Conditions</a></p>
    <p><a href="#">Refund & Cancellation</a></p>
    <p><a href="#">Cookie Policy</a></p>
  </div>
  <div class="footer-section">
    <h3>Connect</h3>
    <p><a href="#">Instagram</a></p>
    <p> <a href="#">Facebook</a></p>
    <p><a href="#">Twitter</a></p>
    <p><a href="#">Youtube</a></p>
  </div>
</footer>
</body>
</html>

    