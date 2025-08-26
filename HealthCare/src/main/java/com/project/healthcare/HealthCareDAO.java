package com.project.healthcare;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class HealthCareDAO {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public HealthCareDAO() throws IOException {
        loadProperties();
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.err.println("Unable to find db.properties file");
            } else {
                properties.load(input);
                driverClassName = properties.getProperty("jdbc.driverName");
                url = properties.getProperty("jdbc.url");
                username = properties.getProperty("jdbc.username");
                password = properties.getProperty("jdbc.password");
            }
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (dId, dName, exp, specialization, dob, location) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, doctor.getdId());
            ps.setString(2, doctor.getdName());
            ps.setInt(3, doctor.getExp());
            ps.setString(4, doctor.getSpecialization());
            ps.setDate(5, doctor.getDob());
            ps.setString(6, doctor.getLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET dName=?, exp=?, specialization=?, dob=?, location=? WHERE dId=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, doctor.getdName());
            ps.setInt(2, doctor.getExp());
            ps.setString(3, doctor.getSpecialization());
            ps.setDate(4, doctor.getDob());
            ps.setString(5, doctor.getLocation());
            ps.setInt(6, doctor.getdId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteDoctor(int dId) {
        String sql = "DELETE FROM doctors WHERE dId=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Doctor> retrieveDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Doctor doctor = new Doctor(
                        rs.getInt("dId"),
                        rs.getString("dName"),
                        rs.getInt("exp"),
                        rs.getString("specialization"),
                        rs.getDate("dob"),
                        rs.getString("location")
                );
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
