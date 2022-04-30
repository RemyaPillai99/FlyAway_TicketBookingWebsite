package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FlightDetailsDaoImpl;
import dao.PassengerDaoImpl;
import dao.UserDaoImpl;
import model.Flight;
import model.Passenger;
import model.PassengerIDProof;
import model.User;

/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/PassengerController")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PassengerIDProof passengerIDProof = new PassengerIDProof();
	PassengerDaoImpl passengerDaoImpl = new PassengerDaoImpl();
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	User user = new User();

	public PassengerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int noOfPassengers = (int) session.getAttribute("noOfPassengers");

		LinkedList<Passenger> passengerList = new LinkedList<Passenger>();

		for (int i = 1; i <= noOfPassengers; i++) {

			Passenger passenger = new Passenger();

			String paramFName = "firstName" + i;
			String firstName = request.getParameter(paramFName);
			firstName = firstName.replaceAll("[^A-Za-z]+$", "");
			passenger.setFirstName(firstName);

			String paramlastName = "lastName" + i;
			String lastName = request.getParameter(paramlastName);
			passenger.setLastName(lastName);
			lastName = lastName.replaceAll("[^A-Za-z]+$", "");

			String paramIDProofCategory = "IDProofCategory" + i;
			passenger.setGender(request.getParameter(paramIDProofCategory));

			String paramemailId = "emailId" + i;
			String email = request.getParameter(paramemailId);
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(email);
			passenger.setEmailId(email);

			String paramdob = "dob" + i;
			passenger.setDob(request.getParameter(paramdob));

			String paramphoneNum = "phoneNum" + i;
			passenger.setPhoneNum(request.getParameter(paramphoneNum));

			String paramCountry = "country" + i;
			passenger.setCountry(request.getParameter(paramCountry));

			String paramAddress = "address" + i;
			passenger.setAddress(request.getParameter(paramAddress));

			String paramIdProof_no = "IdProof_no" + i;
			String IdProof_no = request.getParameter(paramIdProof_no);

			passengerIDProof.setIdProof_no(IdProof_no);
			System.out.println("request.getParameter(\"IdProof_no\") " + paramIdProof_no + " "
					+ request.getParameter(paramIdProof_no));

			String paramIDProofCategory1 = "IDProofCategory" + i;
			passengerIDProof.setIdProofName(request.getParameter(paramIDProofCategory1).toString());

			passenger.setIdProof(passengerIDProof);
			passengerDaoImpl.savePassengerIDProof(passengerIDProof);

			passengerIDProof = passengerDaoImpl.getPassengerIDProofbyId(IdProof_no);

			passenger.setIdProof(passengerIDProof);

			System.out.println("Email " + email);
			user = userDaoImpl.getUser(email);
			if (user != null) {

				System.out.println("user not null");
				passenger.setUser(user);
			}

			passengerDaoImpl.savePassenger(passenger);
			passengerList.add(passenger);

			System.out.println(passenger.getFirstName());

		}

		session.setAttribute("passengerList", passengerList);
		System.out.println("### Pass List");
		for (Passenger p : passengerList) {
			System.out.println(p.getFirstName() + p.getPassenger_Id());
		}

		RequestDispatcher rd = request.getRequestDispatcher("paymentDetails.jsp");
		rd.forward(request, response);

	}

}
