package test.server;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.data.server.LoginServlet;

public class TestLoginServlet {
	
	 @Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 HttpSession session;

	 @Mock
	 RequestDispatcher rd;
	 
	 //init mocks
	 
	 @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }


	@Test
	@Ignore
	public void testDestroy() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoginServlet() {
		
		LoginServlet loginObj = new LoginServlet();
		assertNotNull(loginObj);
	}

	@Test
	@Ignore
	public void testInitServletConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		  
		//configure mocks to play back the values
		  when(request.getParameter("user")).thenReturn("viju");
		  when(request.getParameter("password")).thenReturn("SeKreT100");
		  when(request.getParameter("rememberMe")).thenReturn("Yes-SuRe");
		  when(request.getSession()).thenReturn(session);
		  when(request.getRequestDispatcher("/user.do")).thenReturn(rd);

		  StringWriter sw = new StringWriter();
		  PrintWriter pw = new PrintWriter(sw);
		  
		  try {
			when(response.getWriter()).thenReturn(pw);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		  
		  LoginServlet loginObj = new LoginServlet();
		  
		  //Invoke the test method
		  
		  try {
			loginObj.doPost(request, response);
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  //Verify the session attribute value
		  verify(session).setAttribute("user", "viju");
		  
		  try {
			verify(rd).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  String result = sw.getBuffer().toString().trim();

		  System.out.println("Result: "+result);
		  
		  assertEquals("Login successfull...", result);
		 }	
	
	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		  
		 
		  StringWriter sw = new StringWriter();
		  PrintWriter pw = new PrintWriter(sw);	
		   
		  
		  LoginServlet loginObj = new LoginServlet();
		  
		  try {
			when(response.getWriter()).thenReturn(pw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  //Invoke the test method
		  
		  loginObj.doGet(request, response);			  
		  
		  
		  String result = sw.getBuffer().toString().trim();

		  System.out.println("Result: "+result);
		  
		  assertEquals("We donot expose get method", result);
		 }	

}
