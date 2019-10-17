package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfo
 */
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = (String) request.getSession().getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>");
		out.println("Welcome  :  "+user);
		out.println("</h1>");
		out.println("<p></p>");
		out.println("<br></br>");
		
		out.println(" <div id='account_logout'>");
		out.println("<a href='./LoginPage.html'id='quitUser' >"+"LogOut"+"</a>");
		out.println("</div>");
		
		 
		
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	/*String user = (String) request.getSession().getAttribute("user");
		response.getWriter().append("Welcome "+user).append(request.getContextPath());*/
    	doGet(request, response);
	}
}
