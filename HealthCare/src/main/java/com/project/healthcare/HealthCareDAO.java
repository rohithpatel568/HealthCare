package com.project.healthcare;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
			System.err.println(e.getMessage());
		}
	}

	private void loadProperties() throws IOException {
		Properties properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
			if (input == null)
				System.err.println("Unable to find db.properties file");
			else {
				properties.load(input);
				driverClassName = properties.getProperty("jdbc.driverName");
				url = properties.getProperty("jdbc.url");
				username = properties.getProperty("jdbc.username");
				password = properties.getProperty("jdbc.password");
			}
		} catch (IOException n) {
			n.printStackTrace();
			System.err.println(n.getMessage());
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return con;
	}

	public boolean validate(String username, String password, String role) throws Exception {
		Connection con = getConnection();
		String sql = "SELECT * FROM users WHERE username=? AND password=? AND role=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, role);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	public void addDoctor(Doctor doctor) {
		String sql = "INSERT INTO doctors (dId, dName, exp, spec, dob, loc) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, doctor.getdId());
			ps.setString(2, doctor.getdName());
			ps.setInt(3, doctor.getExp());
			ps.setString(4, doctor.getSpec());
			ps.setDate(5, doctor.getDob());
			ps.setString(6, doctor.getLoc());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDoctor(Doctor doctor) {
		String sql = "UPDATE doctors SET dName=?, exp=?, spec=?, dob=?, loc=? WHERE dId=?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, doctor.getdName());
			ps.setInt(2, doctor.getExp());
			ps.setString(3, doctor.getSpec());
			ps.setDate(4, doctor.getDob());
			ps.setString(5, doctor.getLoc());
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
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Doctor doctor = new Doctor(rs.getInt("dId"), rs.getString("dName"), rs.getInt("exp"),
						rs.getString("spec"), rs.getDate("dob"), rs.getString("loc"));
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}

	public List<Doctor> retrieveBasedOnSpec(List<String> specializations) throws Exception {
		List<Doctor> doctors = new ArrayList<>();
		if (specializations == null | specializations.isEmpty()) {
			return doctors;
		}

		StringBuilder sql = new StringBuilder(
				"SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (PARTITION BY spec ORDER BY exp DESC) AS rn FROM doctors WHERE spec IN (");

		for (int i = 0; i < specializations.size(); i++) {
			sql.append("?");
			if (i < specializations.size() - 1) {
				sql.append(",");
			}
		}
		sql.append(") ) t WHERE rn <= 3");

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql.toString())) {

			for (int i = 0; i < specializations.size(); i++) {
				ps.setString(i + 1, specializations.get(i));
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doc = new Doctor();
				doc.setdId(rs.getInt("dId"));
				doc.setdName(rs.getString("dName"));
				doc.setExp(rs.getInt("exp"));
				doc.setSpec(rs.getString("spec"));
				doc.setDob(rs.getDate("dob"));
				doc.setLoc(rs.getString("loc"));
				doctors.add(doc);
			}
		}
		return doctors;
	}

	public List<Doctor> retrieveBasedOnLoc(List<String> locations) throws Exception {
		List<Doctor> doctors = new ArrayList<>();
		if (locations == null | locations.isEmpty()) {
			return doctors;
		}

		StringBuilder sql = new StringBuilder(
				"SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (PARTITION BY loc ORDER BY exp DESC) AS rn FROM doctors WHERE spec IN (");

		for (int i = 0; i < locations.size(); i++) {
			sql.append("?");
			if (i < locations.size() - 1) {
				sql.append(",");
			}
		}
		sql.append(") ) t WHERE rn <= 2");
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql.toString())) {
			for (int i = 0; i < locations.size(); i++) {
				ps.setString(i + 1, locations.get(i));
			}

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doc = new Doctor();
				doc.setdId(rs.getInt("dId"));
				doc.setdName(rs.getString("dName"));
				doc.setExp(rs.getInt("exp"));
				doc.setSpec(rs.getString("spec"));
				doc.setDob(rs.getDate("dob"));
				doc.setLoc(rs.getString("loc"));
				doctors.add(doc);
			}
		}
		return doctors;
	}

}