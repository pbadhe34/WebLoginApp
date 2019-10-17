package com.data.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
 
 
public LoginServlet () {
     super();
}    
 public void init(ServletConfig config) throws ServletException// called once servlet loads
{
 System.out.println("Login Init called...");
 try {
  super.init(config);
   } catch (ServletException e) {
	   System.out.println("LoginServlet Init error "+e.getMessage());
  }
}
 
public void destroy()// called just before servlet unload
{
  System.out.println("LoginServlet Destroyed...");
  super.destroy();
}


public void doGet(HttpServletRequest req, HttpServletResponse res)
{
	System.out.println("Login doGet...");
	PrintWriter out=null;
	try {
		out = res.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	out.write("We donot expose get method");
	
	
}
 
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
System.out.println("Login doPost...");
String name = req.getParameter("user");
String pwd = req.getParameter("password");
String rememberMe = req.getParameter("rememberMe");
System.out.println("User: "+name+" | password: "+pwd);
PrintWriter out= res.getWriter();

if(name.equals("viju") && pwd.equals("SeKreT100"))
 {
	HttpSession session=req.getSession();
	session.setAttribute("user", name);
	Cookie ck1 = new Cookie("user", name);
	Cookie ck2 = new Cookie("pwd", pwd);
	res.addCookie(ck1);
	res.addCookie(ck2);
	if(rememberMe!=null && rememberMe!=""){
	  Cookie ck3 = new Cookie("MySeCtR", rememberMe);
	  res.addCookie(ck3);
	  	  
	}
	out.write("Login successfull...");

	//Dispatching request
	RequestDispatcher rd=req.getRequestDispatcher("/user.do");
	rd.forward(req, res);
	
  } 
  else out.write("Login denied...try again");	
 }
}
