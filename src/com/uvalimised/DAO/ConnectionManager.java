package com.uvalimised.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection conn;
	 
    public static Connection getConnection(){
        try {
        	System.out.println("Trying to connect to remote database!");
            String url = "jdbc:mysql://sql2.freesqldatabase.com/";
            String dbName ="sql25626"; 
            String uname = "sql25626";
            String pwd = "nN9%eH2!";
 
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(url+dbName,uname,pwd);
                System.out.println("Connected to the database");
                } catch (SQLException ex) {
                	ex.printStackTrace();
                	}
        } catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return conn;
    }
    
    public static void closeConnection(){
    	try {
			conn.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
