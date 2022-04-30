package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.BookingDetailsDaoImpl;
import dao.FlightDetailsDaoImpl;
import dao.PassengerDaoImpl;
import model.BookingDetail;
import model.Flight;
import model.Passenger;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PassengerDaoImpl passengerDaoImpl = new PassengerDaoImpl();
	BookingDetailsDaoImpl booDetailsDaoImpl = new BookingDetailsDaoImpl();
	BookingDetail bookingDetail =null;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int randNo = rand.nextInt(2000);

		HttpSession session = request.getSession();

		System.out.println("## No of Passenger " + session.getAttribute("noOfPassengers"));

		int noPass = (int) session.getAttribute("noOfPassengers");

		Flight flighObj = (Flight) session.getAttribute("flightObj");
		System.out.println("Flight " + (Flight) (session.getAttribute("flightObj")));

		flighObj.setBookedSeats(flighObj.getBookedSeats() + noPass);

		FlightDetailsDaoImpl flightDetailsDaoImpl = new FlightDetailsDaoImpl();

		System.out.println("booked seats " + flighObj.getBookedSeats());
		flightDetailsDaoImpl.updateFlightBookedSeats(flighObj, noPass);

		
		@SuppressWarnings("unchecked")
		LinkedList<Passenger> passList = (LinkedList<Passenger>) session.getAttribute("passengerList");

		if (passList != null) {

			String emailId = passList.getFirst().getEmailId();
			for (Passenger p : passList) {
				bookingDetail = new BookingDetail();
				System.out.println("## Passenger id " + p.getPassenger_Id());
				bookingDetail.setPassenger(p);
				bookingDetail.setRefNo(randNo + emailId);
				bookingDetail.setFlightId(flighObj);
				booDetailsDaoImpl.saveBookingDetails(bookingDetail);
			}
		}

		

		Float totalfare = (noPass * flighObj.getFare());
		System.out.println("###  Total Fare " + totalfare);

		session.setAttribute("bookinId", bookingDetail.getBooking_Id());
		session.setAttribute("totalFare", totalfare);
		
		session.setAttribute("flighObj", flighObj);
		System.out.println(flighObj.getDepatureDate() + flighObj.getTravelClass() + flighObj.getSource());

		RequestDispatcher rd = request.getRequestDispatcher("bookingconfirmation.jsp");
		rd.forward(request, response);

	}

}
