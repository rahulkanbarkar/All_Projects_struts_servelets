package com.mvc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection con=null;
		if(con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/customers","root","889325Ca");
		}
		return con;
		
	}

}














//import java.sql.Connection;
//import java.sql.DriverManager;
// 
//public class DBConnection {
// public static Connection getConnection()
// {
//     Connection con = null;
//     String url = "jdbc:mysql://localhost:3306/customers"; //MySQL URL followed by the database name
//     String username = "root"; //MySQL username
//     String password = "889325Ca"; //MySQL password
//     System.out.println("In DBConnection.java class ");
//      
//     try
//     {
//         try
//         {
//            Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
//         } 
//         catch (ClassNotFoundException e)
//         {
//            e.printStackTrace();
//         }       
//         con = DriverManager.getConnection("jdbc:mysql://localhost/customers","root","889325Ca"); //attempting to connect to MySQL database
//         System.out.println("Printing connection object "+con);
//     } 
//     catch (Exception e) 
//     {
//        e.printStackTrace();
//     }   
//     return con; 
// }
//}