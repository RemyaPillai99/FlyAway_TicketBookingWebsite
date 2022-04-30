package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import model.User;
import validator.EmailValidator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	User user = new User();
	String errMessage ;
	String userRole="";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		 validateUser(emailId,password);
		 if(userRole.isEmpty())
		 {
			 	request.setAttribute("errorMessage", errMessage);
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				
		 }
		 else if(userRole.equals("Admin")) {
			 HttpSession session = request.getSession();
			 RequestDispatcher rd = request.getRequestDispatcher("listFlights.jsp");
			 session.setAttribute("username", "Admin");
			 session.setAttribute("userEmailId", user.getEmailId());
			rd.forward(request, response);
		 }else //if( userRole.equals("Customer") ){
		 {	HttpSession session = request.getSession();
			 RequestDispatcher rd = request.getRequestDispatcher("homePage.jsp");
				rd.forward(request, response);
				session.setAttribute("username", "Customer");
				session.setAttribute("username", user.getEmailId());
		 }
	}

	private void validateUser(String emailId, String password) {
		if (EmailValidator.isValid(emailId)) {
			
			User userDB = userDaoImpl.getUser(emailId);
			
			if(userDB!=null && 
					emailId.equals(userDB.getEmailId()) &&
					password.equals(userDB.getPassword())) {
			
				if( userDB.getDiscriminatorValue().equals("Admin"))
					userRole = "Admin";
				else
					userRole ="Customer";
					
				
				
			}else {
				errMessage ="Invalid Credentials";
			}
		
			
		}else {
			errMessage ="Invalid email id";
			
		}
		
		
	}

}
