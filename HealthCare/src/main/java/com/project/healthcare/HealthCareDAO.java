package com.project.healthcare;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		try(InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
			if(input == null) System.err.println("Unable to find db.properties file");
			else {
				properties.load(input);
				driverClassName = properties.getProperty("jdbc.driverName");
				url = properties.getProperty("jdbc.url");
				username = properties.getProperty("jdbc.username");
				password = properties.getProperty("jdbc.password");
			}
		} catch(IOException n) {
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

}
