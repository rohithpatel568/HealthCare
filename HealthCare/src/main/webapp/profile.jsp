<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Doctor Profile</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(to right, #dfe9f3, #ffffff);
      margin: 0;
      padding: 0;
    }
    .profile-container {
      max-width: 700px;
      margin: 50px auto;
      background: #fff;
      border-radius: 16px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.1);
      padding: 30px;
    }
    h2 {
      text-align: center;
      color: #2c3e50;
      margin-bottom: 25px;
    }
    label {
      font-weight: bold;
      color: #34495e;
      display: block;
      margin-top: 15px;
    }
    input, textarea {
      width: 100%;
      padding: 10px;
      border-radius: 8px;
      border: 1px solid #bdc3c7;
      margin-top: 5px;
      font-size: 14px;
    }
    textarea {
      resize: none;
    }
    .btn {
      display: block;
      width: 100%;
      padding: 12px;
      margin-top: 25px;
      background: #3498db;
      color: white;
      font-size: 16px;
      font-weight: bold;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background 0.3s;
    }
    .btn:hover {
      background: #2980b9;
    }
    .case-history {
      background: #f8f9fa;
      border-left: 5px solid #3498db;
      padding: 10px;
      margin-top: 15px;
      font-style: italic;
    }
  </style>
</head>
<body>
  <div class="profile-container">
    <h2>👨‍⚕️ Doctor Profile</h2>

    <!-- This form will later connect to DoctorController -->
    <form action="updateDoctor" method="post">
      <label>Doctor ID:</label>
      <input type="text" name="dId" value="101" readonly>

      <label>Name:</label>
      <input type="text" name="dName" value="Dr. Roshini">

      <label>Specialisation:</label>
      <input type="text" name="spec" value="Cardiology">

      <label>Experience (years):</label>
      <input type="number" name="exp" value="10">

      <label>Date of Birth:</label>
      <input type="date" name="dob" value="1980-05-12">

      <label>Location:</label>
      <input type="text" name="loc" value="Hyderabad">

      <label>Case History:</label>
      <textarea name="caseHistory" rows="5">Treated 500+ patients, handled 20+ critical surgeries including open-heart operations.</textarea>

      <div class="case-history">
        <b>Recent Cases:</b><br>
        • Heart Bypass Surgery – Successful (2024)<br>
        • Angioplasty – Recovery in 3 days (2023)<br>
        • Pediatric Cardiology Consultation – 200+ cases<br>
      </div>

      <button class="btn" type="submit">Update Profile</button>
    </form>
  </div>
</body>
</html>