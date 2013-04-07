package com.uvalimised.servlet;

import java.io.IOException; 
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		String party_id = request.getParameter("party_id");
		String location_id = request.getParameter("location_id");
		String firstname = request.getParameter("firstname");	
		String lastname = request.getParameter("lastname");	
		String jsonresponse;
		DataF datafetcher = null;
		/**ArrayList<Candidate> candidateList = null;
		Gson gson = new GsonBuilder().create();

		try {
			datafetcher = new DataF(getServletContext());
			if (party_id!=null && location_id!=null) {
				candidateList = datafetcher.getCandidatesByPartyAndRegion(party_id,location_id);
			} else if (party_id!=null) {
				candidateList = datafetcher.getCandidatesByParty(party_id);
			} else if (location_id!=null) {
				candidateList = datafetcher.getCandidatesByRegion(location_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//CandidateList list = new CandidateList(candidateList);
		//jsonresponse = gson.toJson(list);
		//response.getWriter().write(jsonresponse);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		//response.getWriter().write(jsonresponse);
		PrintWriter out = response.getWriter();
	}

	   //Proovid
	   //String region = request.getParameter("Region");
	   //String party = request.getParameter("Party");
	   //response.getWriter().write("{ id : 1 }");


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
