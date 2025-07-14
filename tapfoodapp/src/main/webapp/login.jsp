<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login Page</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Segoe UI',sans-serif;
    }

    body {
      height: 100vh;
      background-color: #f5f5f5;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .page-wrapper {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .logo-container {
      text-align: center;
      margin-bottom: 20px;
    }

    .logo-container img {
      height: 90px;
    }

    .logo-container h1 {
      font-size: 32px;
      font-weight: bold;
      color: #ff3d00;
      margin-top: 10px;
    }

    .login-container {
      background-color: #fff;
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
      width: 350px;
    }

    .login-container h2 {
      text-align: center;
      color: #ff3d00;
      margin-bottom: 25px;
    }

    .login-container input[type="email"],
    .login-container input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 10px 0 20px;
      border: 1px solid #ddd;
      border-radius: 6px;
      font-size: 14px;
    }

    .login-container input[type="submit"] {
      width: 100%;
      padding: 12px;
      background-color: #ff3d00;
      border: none;
      color: white;
      font-weight: bold;
      font-size: 16px;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .login-container input[type="submit"]:hover {
      background-color: #e53900;
    }

    .error-message {
      color: red;
      font-size: 14px;
      text-align: center;
      margin-bottom: 10px;
    }

    .login-container p {
      font-size: 13px;
      text-align: center;
      margin-top: 10px;
    }

    .login-container a {
      color: #ff3d00;
      text-decoration: none;
      font-weight: 500;
    }
  </style>
</head>
<body>
  <div class="page-wrapper">
  
    <!-- 🔶 Logo and Title -->
    <div class="logo-container">
      <h1>FoodExpressApp</h1>
      <img src="images/logo.png" alt="FoodExpressApp Logo" />
    </div>

    <!-- 🔶 Login Form -->
    <div class="login-container">
      <h2>Login</h2>

      <% if (request.getParameter("error") != null) { %>
        <div class="error-message">Invalid email or password.</div>
      <% } %>

      <form action="login" method="post">
        <input type="email" name="email" placeholder="Email" required />
        <input type="password" name="password" placeholder="Password" required />
        <input type="submit" value="Login" />
      </form>

      <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
    </div>

  </div>
</body>
</html>
