package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListFlightsDao;
import dao.ListFlightsDaoImpl;
import model.Flight;

/**
 * Servlet implementation class SearchFlightsController
 */
@WebServlet("/SearchFlightsController")
public class SearchFlightsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ListFlightsDaoImpl ldao = new ListFlightsDaoImpl();
	String errMessage ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlightsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String source = request.getParameter("sourceCategory");
		String dest = request.getParameter("destCategory");
		String deptDate = request.getParameter("deptDate");
		String travelClass = request.getParameter("travelClass");
		
		int noOfPassengers = Integer.parseInt(request.getParameter("noOfPassengers"));
	
		System.out.println("From place : "+source+"Dest:"+dest+"Dept date: "+deptDate + "No of Passenger :" + noOfPassengers +
				"Travel class" + travelClass);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    	
  	   
  	   String sd = request.getParameter("deptDate"); 
  	   Date depatureDate = null;
		try {
			depatureDate = sdf.parse(sd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try{
		
		List<Flight> flightlist = ldao.listFlights(source, dest, depatureDate);
		if(!flightlist.isEmpty()) {
		for(Flight flight : flightlist) {
			
			if(!(flight.getavailableSeats() > noOfPassengers)) {
				flightlist.remove(flight);
			}
		}
		
		int length = flightlist.size();
		System.out.println("Length is "+length);
		session.setAttribute("flightlist", flightlist);
		session.setAttribute("noOfPassengers",noOfPassengers);
		
		 RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
			rd.forward(request, response);
		
		}else {
			System.out.println("Flight List is empty");
			String message = "There are  no flights flying on the selected date";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("searchFlights.jsp");
			rd.include(request, response);
		}
	
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	}

}
