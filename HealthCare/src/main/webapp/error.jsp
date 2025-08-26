<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Error Page</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #fce4e4, #ffffff);
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .error-box {
      background: #fff;
      border-radius: 16px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.1);
      padding: 40px;
      text-align: center;
      max-width: 400px;
    }
    h2 {
      color: #e74c3c;
      margin-bottom: 20px;
    }
    p {
      color: #34495e;
      margin-bottom: 25px;
      font-size: 15px;
    }
    .btn {
      background: #e74c3c;
      color: white;
      padding: 12px 20px;
      border-radius: 8px;
      text-decoration: none;
      font-weight: bold;
      transition: background 0.3s;
    }
    .btn:hover {
      background: #c0392b;
    }
  </style>
</head>
<body>
  <div class="error-box">
    <h2>⚠️ Invalid Credentials!</h2>
    <p>It seems your login attempt has failed.<br>
    Please check your username and password.</p>

    <a href="home.html" class="btn">⬅️ Back to Home</a>
  </div>
</body>
</html>