<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.Doctor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Top Doctors by Location</title>
    <link rel="stylesheet" href="styles/adminDashboard.css">
</head>
<body>
    <div class="container">
        <h1>Top 2 Doctors by Location 🌍</h1>
        <p>Here are the most experienced doctors in each location.</p>

        <div class="card-container">
            <%
                Map<String, List<Doctor>> locMap = 
                    (Map<String, List<Doctor>>) request.getAttribute("doctorsByLoc");

                if (locMap != null && !locMap.isEmpty()) {
                    for (Map.Entry<String, List<Doctor>> entry : locMap.entrySet()) {
                        String location = entry.getKey();
                        List<Doctor> topDocs = entry.getValue();
            %>
                <!-- One card for each location -->
                <div class="card" style="flex: 1 1 100%; text-align:left;">
                    <h3><%= location %></h3>
                    <ul>
                        <% for (Doctor d : topDocs) { %>
                            <li>
                                <strong><%= d.getName() %></strong> – 
                                <%= d.getExperience() %> years experience 
                                (Specialization: <%= d.getSpecialization() %>)
                            </li>
                        <% } %>
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
