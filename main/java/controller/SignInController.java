package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import model.User;
import validator.EmailValidator;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String errMessageSignIn ;

	User user = new User();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("SignUp")!=null){
            String emailId = request.getParameter("emailId");
            String password = request.getParameter("password");
	
			  
			  if(validateUser(emailId, password)) {
				  user.setEmailId(emailId); 
				  user.setPassword(password);
			  userDaoImpl.saveUser(user);
			  RequestDispatcher rd = request.getRequestDispatcher("homePage.jsp");
	            rd.forward(request, response);
	            
			  }else {
				  request.setAttribute("errMessageSignIn", errMessageSignIn);
					RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
					rd.include(request, response);
			  }
			
          
		}
	}
	
	private boolean validateUser(String emailId, String password) {
		if (EmailValidator.isValid(emailId)) {
			
			User userDB = userDaoImpl.getUser(emailId);
			
			if(userDB!=null) {
			
				
				errMessageSignIn ="Customer already exists with given email id .Try Change password !!";
				return false;
			}
			else {
				return true;
			}
			
		
		}else {
			errMessageSignIn ="Invalid email id";
			return false;
			
		}
	}

}
