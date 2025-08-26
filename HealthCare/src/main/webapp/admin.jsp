<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard - HealthCare</title>
    <link rel="stylesheet" href="styles/adminDashboard.css">
</head>
<body>
    <div class="container">
        <h1>Welcome, Admin 👨‍⚕</h1>
        <p>Manage doctor details efficiently.</p>

        <div class="card-container">
            <!-- Create Doctor -->
            <div class="card">
                <h3>Add Doctor</h3>
                <p>Add a new doctor to the system.</p>
                <a href="create.html" class="btn">Add</a>
            </div>

            <!-- Retrieve Doctors -->
            <div class="card">
                <h3>View Doctors</h3>
                <p>See the list of all registered doctors.</p>
                <form action="DoctorController?action=retrieveAll" method="post"><input type="submit" class="btn btn-view" value="View"/></form>
            </div>

            <!-- Update Doctor -->
            <div class="card">
                <h3>Update Doctor</h3>
                <p>Modify existing doctor details.</p>
                <a href="update.html" class="btn btn-update">Update</a>
            </div>

            <!-- Delete Doctor -->
            <div class="card">
                <h3>Delete Doctor</h3>
                <p>Remove a doctor from the system.</p>
                <a href="delete.html" class="btn btn-delete">Delete</a>
            </div>
        </div>

        <div class="logout">
            <a href="home.jsp" class="btn btn-logout">Logout</a>
        </div>
    </div>
</body>
</html>
