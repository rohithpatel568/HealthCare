<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="login-container">
        <h1>Admin Login</h1>
        <form action="admin.jsp" method="post">
            <div class="form-group">
                <label for="adminUsername">Username</label>
                <input type="text" id="adminUsername" name="username" placeholder="Enter Username" required>
            </div>

            <div class="form-group">
                <label for="adminPassword">Password</label>
                <input type="password" id="adminPassword" name="password" placeholder="Enter Password" required>
            </div>

            <button type="submit" class="btn">Login</button>
        </form>
    </div>
</body>
</html>
