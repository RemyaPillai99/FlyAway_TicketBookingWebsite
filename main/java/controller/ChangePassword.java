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

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        userDaoImpl.updateUser(emailId,password);
        request.setAttribute("changePasswordMsg", "Password Changed");
        RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
        rd.include(request, response);
	}

}
