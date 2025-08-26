<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HealthCare System</title>
    <link rel="stylesheet" href="styles/home.css">
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar">
        <div class="nav-left">
            <h1>HealthCare System</h1>
        </div>
        <div class="nav-right">
            <a href="loginAsAdmin.jsp" class="btn login-btn">Login as Admin</a>
            <!-- <a href="loginAsDoctor.jsp" class="btn login-btn">Login as Doctor</a> -->
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container">
        <!-- Search by Specialization Card -->
        <div class="card">
            <h2>Search by Specialization</h2>
            <p>Get top 3 doctors based on specialization or all specializations.</p>
            <form action="DoctorController?action=specBased" method="post">
                <select name="specs" class="dropdown" required>
                    <option value="" disabled selected>Select Specialization</option>
                    <option value="all">All Specializations</option>
                    <option value="Cardiologist">Cardiologist</option>
                    <option value="Neurologist">Neurologist</option>
                    <option value="Orthopedics">Orthopedics</option>
                    <option value="Dermatologist">Dermatologist</option>
                    <option value="ENT">ENT</option>
                    <option value="Nephrologist">Nephrologist</option>
                    <option value="Pediatrics">Pediatrics</option>
                </select>
                <button type="submit" class="btn">Search</button>
            </form>
            
        </div>

        <!-- Search by Location Card -->
        <div class="card">
            <h2>Search by Location</h2>
            <p>Find top 2 doctors available in your selected location.</p>
            <form action="DoctorController?action=locBased" method="post">
                <select name="location" class="dropdown" required>
                    <option value="" disabled selected>Select Location</option>
                    <option value="all">All Locations</option>
                    <option value="Hyderabad">Hyderabad</option>
                    <option value="Chennai">Chennai</option>
                    <option value="Bangalore">Bangalore</option>
                    <option value="Mumbai">Mumbai</option>
                    <option value="Delhi">Delhi</option>
                </select>
                <button type="submit" class="btn">Search</button>
            </form>
        </div>
    </div>
</body>
</html>
