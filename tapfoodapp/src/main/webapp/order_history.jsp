<%@ page import="java.util.*, com.tap.models.Order" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
    <style>
      body {
  font-family: 'Segoe UI', sans-serif;
  background-color: #fff4e6; /* light orange background */
  margin: 0;
  padding: 0;
}

h2 {
  background-color: #ff5722;
  color: white;
  padding: 20px;
  text-align: center;
  margin: 0;
  font-size: 28px;
}

.order-container {
  max-width: 800px;
  margin: 30px auto;
  padding: 0 20px;
}

.order-box {
  background-color: white;
  border-radius: 10px;
  padding: 20px 25px;
  margin-bottom: 20px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
}

.order-box h3 {
  margin-top: 0;
  color: #ff5722;
  font-size: 20px;
  margin-bottom: 8px;
}

.order-box p {
  margin: 6px 0;
  color: #444;
  font-size: 15px;
  line-height: 1.5;
}

.no-orders {
  text-align: center;
  color: #888;
  font-size: 18px;
  margin-top: 50px;
}

    </style>
</head>
<body>
   <body>
  <h2>Your Order History</h2>
  <div class="order-container">
    <%
      List<Order> orders = (List<Order>) request.getAttribute("orders");
      if (orders != null && !orders.isEmpty()) {
          for (Order o : orders) {
    %>
      <div class="order-box">
        <h3>Order ID: <%= o.getOrderId() %></h3>
        <p><strong>Date:</strong> <%= o.getOrderDate() %></p>
        <p><strong>Payment Method:</strong> <%= o.getPaymentMode() %></p>
        <p><strong>Status:</strong> <%= o.getStatus() %></p>
        <p><strong>Total Amount:</strong> ₹<%= o.getTotalAmount() %></p>
      </div>
    <%
        }
      } else {
    %>
      <p class="no-orders">No orders found.</p>
    <%
      }
    %>
  </div>
</body>


</body>
</html>
