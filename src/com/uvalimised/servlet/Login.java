package com.uvalimised.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uvalimised.DAO.UserDAO;
import com.uvalimised.data.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//this.userDAO = Config.getInstance(getServletContext()).getDAOFactory().getUserDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
        {
            System.out.println("In the Login Servlet");
            User user = new User();
            user.setUsername(request.getParameter("uname"));
            user.setPassword(request.getParameter("password"));
            user = UserDAO.login(user);
            if(user.isValid())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",user);
                response.sendRedirect("LoginSuccess.jsp");
            }else
                response.sendRedirect("LoginFailed.jsp");
        } catch (Throwable exc){
            System.out.println(exc);
        }
	}
	
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}
}
