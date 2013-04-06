package com.uvalimised.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8"); 
	    PrintWriter out = response.getWriter();
	    
	   /** try {
			//connecting to the DB
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean userExists = rs.next();
			*/
	    
	   String region = request.getParameter("Region");
	   String party = request.getParameter("Party");
	   
	   
	    /*andmebaasist tulevad andmed, teen päringu vahel
	     * töötlen andmed nii nagu mul neid vaja on jsonitena
	    */
	   
	   //jQuery.parseJSON( jsonString );
	   response.getWriter().write("{ id : 1 }"); 
	   //var json = JSON.stringify(myObj);
	   //alert(json);
	    
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
