package com.uvalimised.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

public class DataF {

	private PreparedStatement predbstatement;
	private ResultSet dbresultset;
	private Connection dbconnection;

	public DataF(ServletContext context) throws SQLException, NamingException {
		dbconnection = ((DataSource)context.getAttribute("datasource")).getConnection();
		predbstatement = null;
		dbresultset = null;
	}
	public ArrayList<Party> getPartys() throws SQLException {
		ArrayList<Party> partyList = new ArrayList<Party>();

		predbstatement = dbconnection.prepareStatement(FQuery.getAllFromParty);
		dbresultset = predbstatement.executeQuery();

		while (dbresultset.next()) {
			Party selectedParty = new Party(dbresultset.getInt("id_party"),
											dbresultset.getString("name")); 
			partyList.add(selectedParty);
        }
		close();
		return partyList;
	}

	private void close() throws SQLException {
		dbresultset.close();
		predbstatement.close();
		dbconnection.close();
	}
	
}