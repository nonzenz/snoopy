package com.uvalimised.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.uvalimised.data.User;

/**
 * 
 * @author Robert
 *
 */
public class UserDAO {
	static Connection con = null;
	static ResultSet rs = null;
	public static User login(User bean){
		Statement stmt = null;
		String username = bean.getUsername();
		String password = bean.getPassword();
		String searchQuery = "SELECT * FROM users WHERE uname='" + username + "' AND password='" + password + "'";
		try {
			//connecting to the DB
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean userExists = rs.next();
		 
			if (!userExists){
				System.out.println("Username/Password entered is Incorrect or User doesnot Exists.");
				bean.setValid(false);
				}
			else if (userExists) {
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				Boolean candidated = rs.getBoolean("iscandidate");
				Boolean voted = rs.getBoolean("hasvoted");
				//String SocialID = rs.getString("socialID");
				
				System.out.println("Welcome " + firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setHasVoted(voted);
				bean.setIsCandidate(candidated);
				bean.setValid(true);
				}
			}
		catch (Exception ex){
			System.out.println("Log In failed: An Exception has occurred! " + ex);
			}
		ConnectionManager.closeConnection();
		return bean;
		}
}
