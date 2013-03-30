package com.uvalimised.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uvalimised.data.Candidate;

/**
 * CandidateServlet
 * @author Robert
 *
 */
@WebServlet("/candidateReg")
public class CandidateServlet extends HttpServlet{
	
	public CandidateServlet() {
        super();
    }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		Candidate candidate = new Candidate();
		candidate.setHasVoted(false);
		
		/*
		 * Siia tuleb terve joru koodi!
		 */
        
		resp.setContentType("text/plain");
        resp.getWriter().println("Hello, world");
    }
	
}
