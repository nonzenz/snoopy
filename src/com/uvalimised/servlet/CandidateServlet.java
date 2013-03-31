package com.uvalimised.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uvalimised.DAO.ConnectionManager;
import com.uvalimised.data.Candidate;
import com.uvalimised.data.User;

/**
 * CandidateServlet
 * @author Robert
 *
 */
@WebServlet("/candidateReg")
public class CandidateServlet extends HttpServlet{
	private static final long serialVersionUID = 6765583424445139002L;

	public CandidateServlet() {
        super();
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		//Proovime ühendada
		ConnectionManager.getConnection();
		
		// loome rangelt aktiivse kasutaja
		User user = new User("Robert", "Val", "robertv", "robert", false);
		
		// Seame kandidaadi andmed
		// Hetkel Faile ei valideeri ja uploadi, tuleb hiljem!
		try{
			String party;
			String loc;
			
			if (req.getParameter("party") != "0") {
				String partySelectValue = req.getParameter("party");
				if (partySelectValue == "1"){
					party = "Reformierakond";
				}
				else if (partySelectValue == "2"){
					party = "Keskerakond";
				} else {
					party = "Üksikkandidaat";
				}
			} else {
				throw new Exception("Erakond valimata!");
			}
			
			if (req.getParameter("location") != "0") {
				String locationSelectValue = req.getParameter("location");
				if (locationSelectValue == "1"){
					loc = "Tallinn";
				}
				else if (locationSelectValue == "2"){
					loc = "Tartu";
				} 
				else if (locationSelectValue == "3"){
					loc = "Pärnu";
				}
				else if (locationSelectValue == "4"){
					loc = "Haapsalu";
				} else {
					loc = "Paide";
				}
			} else {
				throw new Exception("Piirkond valimata!");
			}
			
			Candidate candidate = new Candidate(user.getFirstName(), user.getLastName(), party, loc, req.getParameter("email"));
		} catch (Exception ex){
			System.out.println(ex);
		}
		
		ConnectionManager.closeConnection(); //Sulgeme
    }

}
