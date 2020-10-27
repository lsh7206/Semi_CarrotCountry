package com.javachip.carrotcountry.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class JDBCtemplate {

	public static Connection getConnection() {
		
		Connection conn = null;
		Properties prop = new Properties();
		
		String path = JDBCtemplate.class.getResource("/sql/driver/driver.xml").getPath();
		
		
		try {
			prop.loadFromXML(new FileInputStream(path));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url")
					                          ,prop.getProperty("id")
					                          ,prop.getProperty("pwd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
	}
}
