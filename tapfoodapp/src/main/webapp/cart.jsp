<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.tap.models.Cart, com.tap.models.CartItem" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.5.0/fonts/remixicon.css" rel="stylesheet"/>
  <title>Your Cart</title>
  <style>
  body {
    font-family: Arial, sans-serif;
    background-color:#f5f5f5;
    color: #333333;             
    margin: 0;
    padding: 20px;
  }

  h1 {
    text-align: center;
    color: #ff5722;
    margin-bottom: 30px;
  }

  .cart-container {
    max-width: 800px;
    margin: 0 auto;
  }

 .cart-item {
  display: flex;
  margin-bottom:20px;
  gap: 20px;
  align-items: flex-start;
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}


  .cart-item-details {
    flex: 1;
  }

  .cart-item-details h3 {
    margin: 0 0 8px 0;
    font-size: 18px;
    color: #333;
  }

  .cart-item-details p {
    margin: 4px 0;
    color: #666;
  }

  .quantity-controls {
    display: flex;
    align-items: center;
    margin-top: 10px;
  }

  .quantity-controls p {
    margin: 0 10px;
    font-weight: bold;
  }

  .quantity-btn {
    background-color: #4caf50;
    color: white;
    border: none;
    padding: 6px 10px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 4px;
    transition: background-color 0.2s ease;
  }

  .quantity-btn:hover {
    background-color: #43a047;
  }

  .remove-btn {
    background-color: #f44336;
    color: white;
    border: none;
    padding: 8px 12px;
    font-size: 14px;
    cursor: pointer;
    border-radius: 4px;
    margin-left: 20px;
    transition: background-color 0.2s ease;
  }

  .remove-btn:hover {
    background-color: #d32f2f;
  }

  form {
    display: inline;
  }
  .add-more-items {
  text-align: center;
  margin-top: 30px;
}
.add-more-items .btn {
  background-color: #2196f3;
  color: white;
  padding: 10px 16px;
  text-decoration: none;
  border-radius: 6px;
  font-weight: bold;
}
.add-more-items .btn:hover {
  background-color: #1976d2;
}

.total {
  margin: 20px auto;
  padding: 12px 25px;
  background-color: #f8f9fa;
  border: 2px solid black;
  border-radius: 12px;
  font-size: 20px;
  font-weight: bold;
  color: black;
  text-align: right;
  width: 745px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
}

.proceed-btn { 
  display:flex;
  margin : 20px auto;
  padding: 12px 25px;
 background-color: #ff7043; 
  border: 2px;
  border-radius: 12px;
  font-size: 20px;
  font-weight: bold;
  align:center;
  width:800px; /* same width as cart items */
  box-shadow:0 4px 8px rgba(0, 0, 0, 0.05);
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.proceed-btn:hover {
  background-color: #218838;
}


  
</style>

</head>
<body>

	<div style="width: 100vw;background-color: #ff5722; padding: 20px 0; text-align: center; margin: 0 -20px 30px -20px;">
    <h1 style="color: white; margin: 0; font-size: 32px">Your cart</h1>
  </div>
	<div class="cart-container">
		<%
 Cart cart = (Cart) session.getAttribute("cart");
 Integer restaurantId = (Integer) session.getAttribute("restaurantId");
 Integer restId = (Integer) session.getAttribute("sessrestaurantId");
 
 //check two conditions cart should be present && cart should not be empty.
 //sop it is present fetch the details 
 if(cart != null &&  !cart.getItems().isEmpty()){
	 for(CartItem item: cart.getItems().values()){ //first we have cart object ->get items ->values 

%>
	<!-- ✅ START OF EACH CART ITEM -->
<div class="cart-item">

  <!-- ✅ 1. IMAGE SECTION (LEFT) -->
  <div>
    <img src="<%= item.getImagePath() %>" alt="Item Image"
         style="width: 100px; height: 100px; object-fit: cover; border-radius: 8px;">
  </div>

  <!-- ✅ 2. TEXT + BUTTONS (RIGHT) -->
  <div class="cart-item-details">

    <!-- ✅ Item name, price and total -->
    <h3><%= item.getName() %></h3>
    <p>Price: ₹<%= item.getPrice() %></p>
    <p>Total: ₹<%= item.getTotalPrice() %></p>

    <!-- ✅ Quantity update controls -->
    <div class="quantity-controls">
      <!-- ➖ Decrease -->
      <form action="cart" method="post">
        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("sessrestaurantId") %>">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
        <button class="quantity-btn">-</button>
      </form>

      <p><%= item.getQuantity() %></p>

      <!-- ➕ Increase -->
      <form action="cart" method="post">
        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("sessrestaurantId") %>">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
        <button class="quantity-btn">+</button>
      </form>
    </div>
    </div>

    <form action="cart" method="post">
    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
    <input type="hidden" name="action" value="remove">
    <button class="remove-btn"><i class="ri-delete-bin-6-fill"></i> remove</button>
  </form>

</div>
<!-- ✅ END OF EACH CART ITEM -->

		<%
		}
 	  }else {
		%>
		<p style = "text-align: center ;color:red;">Your cart is empty.</p>
		<%
		}
		%>
		
	</div>
	
	<%

    if (cart != null && !cart.getItems().isEmpty()) {
%>
    <div class="total">Grand Total : ₹<%= cart.getTotalPrice() %></div>
<%
    }
%>

<%
    if (restId != null) {
%>
    <div class="add-more-items"> 
        <a href="menu?restaurantId=<%= restId %>" class="btn add-more-items">Add more items</a>
    </div>
<%
    }
%>

<%
    if (cart != null && !cart.getItems().isEmpty()) {
 %>
	<!-- this cart.jsp file to checkout.jsp it is moving for displaying the details. -->
	<form action = "checkout.jsp" method = "post">
	<input type = "submit" value = "Proceed To Payment" class = "proceed-btn">
	</form>
    
<%
    }
%>
</body>
</html>
