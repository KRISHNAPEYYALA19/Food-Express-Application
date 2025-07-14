<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Payment Page</title>
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

    .payment-container {
      background-color: #fff;
      max-width: 500px;
      margin: 40px auto;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    .payment-methods {
    margin: 15px 0;
  }

  .payment-methods label {
    display: block;
    margin: 8px 0;
    font-weight: 500;
    font-size: 16px;
  }

  .payment-methods input[type="radio"] {
    margin-right: 10px;
  }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 8px;
    }

    textarea, select {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 14px;
    }
    .card-details {
      margin-top: 30px;
      border-top: 1px solid #ddd;
      padding-top: 20px;
    }

    .card-details h3 {
      margin-bottom: 10px;
      color: #444;
    }

    .submit-btn {
      background-color: #ff5722;
      color: white;
      border: none;
      padding: 12px 18px;
      font-size: 16px;
      font-weight: bold;
      width: 100%;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease;
      margin-top: 20px;
    }

    .submit-btn:hover {
      background-color: #388e3c;
    }

  </style>
</head>
<body>

  <div class="header">Payment Page</div>

  <div class="payment-container">
    <form action="checkout" method="post">
      <div class="form-group">
        <label for="address">Delivery Address:</label>
        <textarea id="address" name="address" rows="3" required></textarea>
      </div>

     <div class="payment-methods">
  <p><strong>Payment Method:</strong></p>
  <label><input type="radio" name="paymentMethod" value="credit-card" required> Credit Card</label>
  <label><input type="radio" name="paymentMethod" value="debit-card"> Debit Card</label>
  <label><input type="radio" name="paymentMethod" value="online-payment"> Online Payment</label>
  <label><input type="radio" name="paymentMethod" value="cash-on-delivery"> Cash on Delivery</label>
</div>

<div class="card-details">
        <h3>Card Details</h3>
        <label>Card Number:</label>
        <input type="text" name="cardNumber" placeholder="1234 5678 9012 3456">

        <label>Expiry Date:</label>
        <input type="text" name="expiry" placeholder="MM/YY">

        <label>CVV:</label>
        <input type="password" name="cvv" placeholder="123">
      </div>



      <button type="submit" class="submit-btn">Place Order</button>
    </form>
  </div>

</body>
</html>
