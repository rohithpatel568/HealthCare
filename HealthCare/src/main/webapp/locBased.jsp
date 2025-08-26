<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.project.healthcare.Doctor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Top Doctors by Specialization</title>
    <link rel="stylesheet" href="styles/adminDashboard.css">
</head>
<body>
    <div class="container">
        <h1>Top 2 Doctors by Location 🩺</h1>
        <p>Here are the most experienced doctors in each Location.</p>

        <div class="card-container">
            <%
                List<Doctor> specMap = 
                    (List<Doctor>) request.getAttribute("doctors");

                if (specMap != null && !specMap.isEmpty()) {
                    for (Doctor doctor : specMap) {
							String doctorString = doctor.toString();
            %>
                <!-- One card for each specialization -->
                <div class="card" style="flex: 1 1 100%; text-align:left;">
                    <h3><% out.println(doctor.getLoc()); %></h3>
                    <h3><% out.println("Doctor Details"); %></h3>
                    <ul>
						<%= doctorString %>
                    </ul>
                </div>
            <%
                    }
                } else {
            %>
                <p>No doctor data available. Please check again later.</p>
            <%
                }
            %>
        </div>

        <div class="logout">
            <a href="home.jsp" class="btn btn-logout">Back to Home</a>
        </div>
    </div>
</body>
</html>