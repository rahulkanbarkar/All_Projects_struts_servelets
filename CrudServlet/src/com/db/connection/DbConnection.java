package com.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class DbConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection con=null;
		if(con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/reg","root","889325Ca");
		}
		return con;
		
	}

}
