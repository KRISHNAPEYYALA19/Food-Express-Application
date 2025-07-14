<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Sign Up</title>
  <script>
  window.onload = function() {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('error') === 'exists') {
      alert("User already exists. Please log in.");
    }
  };
</script>
  
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Segoe UI', sans-serif;
    }

    body {
      height: 100vh;
      background-color: #f5f5f5;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .signup-container {
      background-color: #fff;
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
      width: 400px;
    }

    .signup-container h2 {
      text-align: center;
      color: #ff3d00;
      margin-bottom: 25px;
    }

    .signup-container input[type="text"],
    .signup-container input[type="email"],
    .signup-container input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 14px;
    }

    .signup-container input[type="submit"] {
      width: 100%;
      padding: 12px;
      background-color: #ff3d00;
      border: none;
      color: white;
      font-weight: bold;
      font-size: 16px;
      border-radius: 6px;
      cursor: pointer;
      margin-top: 20px;
      transition: background-color 0.3s ease;
    }

    .signup-container input[type="submit"]:hover {
      background-color: #e53900;
    }

    .signup-container p {
      font-size: 14px;
      text-align: center;
      margin-top: 15px;
    }

    .signup-container a {
      color: #ff3d00;
      text-decoration: none;
      font-weight: 500;
    }
  </style>
</head>
<body>
  <div class="signup-container">
    <h2>Sign Up</h2>

    <form action="signup" method="post" autocomplete="off">
      <input type="text" name="username" placeholder="Username" autocomplete="off" required />
      <input type="email" name="email" placeholder="Email" required />
      <input type="password" name="password" placeholder="Password"  autocomplete="new-password" required />
      <input type="text" name="phoneNumber" placeholder="Phone Number" required />
      <input type="text" name="address" placeholder="Address" required />
      <input type="submit" value="Sign Up" />
    </form>

    <p>Already have an account? <a href="login.jsp">Login</a></p>
  </div>
</body>
</html>
