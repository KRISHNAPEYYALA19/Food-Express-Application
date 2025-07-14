<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order Confirmation</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
    }

    .header {
      background-color: #ff5722;
      color: white;
      padding: 20px;
      text-align: center;
      font-size: 28px;
      font-weight: bold;
    }

    .confirmation-container {
      max-width: 600px;
      background-color: #fff;
      margin: 50px auto;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 6px 16px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    .confirmation-container h2 {
      color: #4caf50;
      margin-bottom: 10px;
    }

    .confirmation-container p {
      font-size: 16px;
      color: #555;
      margin: 8px 0;
    }

    .btn-home {
      display: inline-block;
      margin-top: 20px;
      background-color: #ff5722;
      color: white;
      text-decoration: none;
      padding: 10px 20px;
      border-radius: 8px;
      font-weight: bold;
      transition: background-color 0.3s ease;
    }

    .btn-home:hover {
      background-color: #e64a19;
    }
    .btn-order {
      display: inline-block;
      margin-top: 20px;
      background-color: #ff5722;
      color: white;
      text-decoration: none;
      padding: 10px 20px;
      border-radius: 8px;
      font-weight: bold;
      transition: background-color 0.3s ease;
    }

    .btn-order:hover {
      background-color: #e64a19;
    }
  </style>
</head>
<body>

  <div class="header">Order Confirmed</div>

  <div class="confirmation-container">
    <h2>🎉 Thank you for your order!</h2>
    <p>Your order has been placed successfully.</p>
    <p>We’re preparing it and it will be delivered soon.</p>
    <a href="restaurant" class="btn-home">Back to Home</a>
    <a href="orderHistory" class = "btn-order">Order History</a>
    
  </div>

</body>
</html>
