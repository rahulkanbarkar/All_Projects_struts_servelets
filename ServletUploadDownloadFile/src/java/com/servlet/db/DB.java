package com.servlet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    static String URL = "localhost/";
    static String DATABASE_NAME = "file_upload";
    static String USERNAME = "root";
    static String PASSWORD = "889325Ca";// There is no password.

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/file_upload", "root","889325Ca");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
