package com.uvalimised.servlet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uvalimised.data.Candidate;

import java.io.IOException;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uvalimised.DAO.ConnectionManager;

/**
 * Servlet implementation class MainServlet
 *  * CandidateSearchServlet
 *  * @author Helina
 */
@WebServlet("/CandidateSearch")
public class CandidateSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionManager.getConnection();
		
		String party = request.getParameter("party_id");
		String area = request.getParameter("area_id");
		String firstname = request.getParameter("firstname");	
		String lastname = request.getParameter("lastname");	
		
		String statement;
		
	    try {
	      if((firstname.equals("") || firstname == null) && (lastname.equals("") || lastname == null) && 
	    		  (party.equals("") || party == null) && (area.equals("")|| area == null)) {
	    	  System.out.println("Getting all candidates");
	    	  statement = "SELECT candidate.firstname, candidate.lastname, party_id, area_id " +
	    	  		"FROM candidate";
	      }
	      else
	    	  statement = createQuery(firstname,lastname,party, area);
    	  PreparedStatement stmt = conn.prepareStatement(statement);
	      ResultSet rs = stmt.executeQuery();
	      String jsonData = createJSON(rs, party,area);
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");
          response.getWriter().write(jsonData);

	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    finally {
	        if (conn != null){
	        	try {
					conn.close();
				} 
	        	catch (SQLException ignore) {}
	        }
	    } 
	 
	  }

	private static String createQuery(String firstname, String lastname, String party, String area) {
		String beginning = "SELECT candidate.firstname, candidate.lastname";
		String middle = "";
		String end = "WHERE ";
		if(!(firstname.equals("")) && firstname != null)
			end += "CONCAT(firstname, ' ', lastname) LIKE '%"+ firstname + "%' AND ";	
		if(!(lastname.equals("")) && lastname != null)
			end += "lastname=\""+lastname+"\" AND ";
		if(!(party.equals("")) && party != null) {
			beginning += ", area.area_name";
			end += "party_id=\""+party+"\" AND ";
		}
		if(!(area.equals("")) && area != null) {
			beginning += ", party.party_name";
			end += "area_id=\""+area+"\" AND ";
		}
		if(party.equals("") && area.equals("") && party != null && area != null){
			beginning += ", area.area_name";
			beginning += ", party.party_name";
		}
		middle += "JOIN party ON candidate.party_id = party.party_id ";
		middle += "JOIN area ON candidate.area_id = area.area_id ";
		//remove last " AND "
		end = end.substring(0, end.length() - 5);
		beginning +=" FROM candidate ";
		String query = beginning + middle + end;
		System.out.println(query);
		return query;
	}

	private static String createJSON(ResultSet rs, String party, String area){
	      List<Candidate> candidates = new ArrayList<Candidate>();
	      try {
			while(rs.next()){
			      Candidate candidate = new Candidate();
			      candidate.setFirstName(rs.getString("firstname"));
			      candidate.setFirstName(rs.getString("lastname"));
			      if(party.equals("") || party == null){
			    	  candidate.setParty(rs.getString("party_name"));
			      }
			      if(area.equals("") || area == null){
			    	  candidate.setLocation(rs.getString("area_name"));
			      }
			      candidates.add(candidate);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      Gson gson = new GsonBuilder().create();
          String candidatesJson = gson.toJson(candidates);
          return candidatesJson;
	}
    
	

	   //Proovid
	   //String region = request.getParameter("Region");
	   //String party = request.getParameter("Party");
	   //response.getWriter().write("{ id : 1 }");

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}

