<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Login</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="login-container">
        <h1>Doctor Login</h1>
        <form action="profile.jsp" method="post">
            <div class="form-group">
                <label for="doctorUsername">Username</label>
                <input type="text" id="doctorUsername" name="username" placeholder="Enter Username" required>
            </div>

            <div class="form-group">
                <label for="doctorPassword">Password</label>
                <input type="password" id="doctorPassword" name="password" placeholder="Enter Password" required>
            </div>

            <button type="submit" class="btn">Login</button>
        </form>
    </div>
</body>
</html>
