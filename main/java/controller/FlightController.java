package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AirlineDaoImpl;
import dao.CityDaoImpl;
import dao.FlightDetailsDaoImpl;
import model.Airline;
import model.City;
import model.Destination;
import model.Flight;
import model.Source;
import model.TravelClass;

/**
 * Servlet implementation class FlightController
 */
@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDetailsDaoImpl fliDetailsDaoImpl = new FlightDetailsDaoImpl();
	AirlineDaoImpl airlineDaoImpl = new AirlineDaoImpl();
	CityDaoImpl cityDaoImpl = new CityDaoImpl();
	Flight flightObj = new Flight();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightController() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	  if(request.getParameter("DeleteFlight")!=null)  {
  	    	
    		  System.out.println("################Delete  Button clicked");
    		  	    	
    		  	    	int flightNo = Integer.parseInt(request.getParameter("no"));
    		  	    	
    		  	    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    		  		    	
    		  	    	   
    		  	    	   String sd = request.getParameter("date"); 
    		  	    	   Date depatureDate = null;
    		  			try {
    		  				depatureDate = sdf.parse(sd);
    		  				//flightObj.setDepatureDate(depatureDate) ;
    		  			} catch (ParseException e) {
    		  				// TODO Auto-generated catch block
    		  				e.printStackTrace();
    		  			}  
    		  	    	     
    		  	    	   
    		  	    	   
    		  	    	   flightObj = fliDetailsDaoImpl.getFlightDetailsById(flightNo, depatureDate, request.getParameter("class"));
    		  	    	   
    		  	    	   fliDetailsDaoImpl.deleteFlight(flightObj);
    		  	    	   RequestDispatcher rd = request.getRequestDispatcher("listFlights.jsp");
    		  				rd.forward(request, response);
    		  	    	
    		  	    	
    		  	    	
    		  	    }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(request.getParameter("addFlight")!=null){
	    	
	    	
	    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    	
	    	   
	    	   String sd = request.getParameter("depatureDate"); 
	    	   Date depatureDate;
			try {
				depatureDate = sdf.parse(sd);
				flightObj.setDepatureDate(depatureDate) ;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    	     
	    	   
	    	   flightObj.setTravelClass(request.getParameter("travelClassCategory"));
	    	   
	    	   System.out.println(request.getParameter("airlineName") + request.getParameter("availableSeats") +request.getParameter("depatureDate") );
	    	   
	    	   Airline airLine = airlineDaoImpl.getAirlineByName(request.getParameter("airlineCategory"));
	    	   
	    	   
	    	
	    	   
	    	   flightObj.setAirlineName(airLine);
	    	   
	    	   City source = cityDaoImpl.getCityByName(request.getParameter("sourceCategory")); 
	    	   flightObj.setSource(source);
	    	   City dest = cityDaoImpl.getCityByName(request.getParameter("destCategory")); 
	    	   flightObj.setDest(dest);
	    	   
	    	  
	    	   flightObj.setTotalSeats(Integer.valueOf(request.getParameter("totalSeats")));
	    	   flightObj.setBookedSeats(Integer. valueOf(request.getParameter("bookedSeats")));
	    	   flightObj.setFlightDuration(Integer.valueOf(request.getParameter("flightDuration")));
	    	   
	    	  
	    	   
	    	  flightObj.setFare(Float.valueOf(request.getParameter("fare")));
	    	   
	    	  fliDetailsDaoImpl.saveFlight(flightObj);
	    	  
	    	  RequestDispatcher rd = request.getRequestDispatcher("listFlights.jsp");
				rd.forward(request, response);
            
        }
	    
	    if(request.getParameter("listFlights")!=null ){
	    	System.out.println("ListFlights Clicked ");
	    	
	    	
	    }
	    
	    if(request.getParameter("EditFlight")!=null) {
	    	
	    	System.out.println("################Edit Button clicked");
	    	
	    	int flightNo = Integer.parseInt(request.getParameter("flightNo"));
	    	
	    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    	
	    	   
	    	   String sd = request.getParameter("depatureDate"); 
	    	   Date depatureDate = null;
			try {
				depatureDate = sdf.parse(sd);
				//flightObj.setDepatureDate(depatureDate) ;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    	     
	    	   
	    	  // flightObj.setTravelClass(request.getParameter("travelClassCategory"));
	    	   
	    	   flightObj = fliDetailsDaoImpl.getFlightDetailsById(flightNo, depatureDate, request.getParameter("travelClass"));
	    	   
	    	   System.out.println(request.getParameter("airlineName") + request.getParameter("availableSeats") +request.getParameter("depatureDate") );
	    	   
	    	   //Airline airLine = airlineDaoImpl.getAirlineByName(request.getParameter("airlineName"));
	    	   int airlineId = Integer.parseInt(request.getParameter("airlineCategory"));
	    	   Airline airLine = airlineDaoImpl.getAirline(airlineId);
	    	   
	    	   
	    	
	    	   
	    	   flightObj.setAirlineName(airLine);
	    	   
	    	   City source = cityDaoImpl.getCityByName(request.getParameter("sourceCategory")); 
	    	   flightObj.setSource(source);
	    	   City dest = cityDaoImpl.getCityByName(request.getParameter("destCategory")); 
	    	   flightObj.setDest(dest);
	    	   
	    	  
	    	   flightObj.setTotalSeats(Integer.valueOf(request.getParameter("totalSeats")));
	    	   flightObj.setBookedSeats(Integer. valueOf(request.getParameter("bookedSeats")));
	    	   flightObj.setFlightDuration(Integer.valueOf(request.getParameter("flightDuration")));
	    	   
	    	  
	    	   
	    	  flightObj.setFare(Float.valueOf(request.getParameter("fare")));
	    	   
	    	  fliDetailsDaoImpl.updateFlight(flightObj);
	    	  
	    	  RequestDispatcher rd = request.getRequestDispatcher("listFlights.jsp");
				rd.forward(request, response);
	    }
	    
	    if(request.getParameter("deleteFlight")!=null){
	    	  System.out.println("################Delete  Button clicked");
				/*
				 * int flightNo = Integer.parseInt(request.getParameter("no"));
				 * 
				 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				 * 
				 * 
				 * String sd = request.getParameter("date"); Date depatureDate = null; try {
				 * depatureDate = sdf.parse(sd); //flightObj.setDepatureDate(depatureDate) ; }
				 * catch (ParseException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 * 
				 * 
				 * 
				 * flightObj = fliDetailsDaoImpl.getFlightDetailsById(flightNo, depatureDate,
				 * request.getParameter("class"));
				 */
		    	
		    	int flightNo = Integer.parseInt(request.getParameter("flightNo"));
		    	
		    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			    	
		    	   
		    	   String sd = request.getParameter("depatureDate"); 
		    	   Date depatureDate = null;
				try {
					depatureDate = sdf.parse(sd);
					//flightObj.setDepatureDate(depatureDate) ;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		    	     
		    	   
		    	  // flightObj.setTravelClass(request.getParameter("travelClassCategory"));
		    	   
		    	   flightObj = fliDetailsDaoImpl.getFlightDetailsById(flightNo, depatureDate, request.getParameter("travelClass"));
	  	    	   fliDetailsDaoImpl.deleteFlight(flightObj);
	  	    	 RequestDispatcher rd = request.getRequestDispatcher("listFlights.jsp");
	  				rd.forward(request, response);
	  	    	
	  	    	
	    	
	    }
	    if(request.getParameter("AddAirline")!=null) {
	    	
	    	System.out.println("################Add Airline	 Button clicked");
	    	AirlineDaoImpl airlineDaoImpl = new AirlineDaoImpl();
	    
	    	String airlineName = request.getParameter("airlineName");
	    	Airline airline = airlineDaoImpl.getAirlineByName(airlineName
	    			);
	    
	    	if(airline!=null) {
	    		HttpSession session = request.getSession();
	    		
	    		String message = "Airline already exists ";
				request.setAttribute("messageAirline", message);
	    		RequestDispatcher rd = request.getRequestDispatcher("addAirline.jsp");
  				rd.forward(request, response);
	    		
	    		
	    	}else {
	    		airline = new Airline();
	    		airline.setAirlineName(airlineName);
	    		airlineDaoImpl.saveAirline(airline);
	    		HttpSession session = request.getSession();
	
	    		String message = "Airline added";
				request.setAttribute("messageAirline", message);
	    		RequestDispatcher rd = request.getRequestDispatcher("addAirline.jsp");
  				rd.forward(request, response);
	    		
	    	}
	    	
	    	
	    	
	    	
	    }
	    
  if(request.getParameter("AddAirport")!=null) {
	    	
	    	System.out.println("################Add AirPort Button clicked");
	    	CityDaoImpl cityDaoImpl = new CityDaoImpl();
	    
	    	String airportName = request.getParameter("airportName");
	    	City city = cityDaoImpl.getCityByName(airportName);
	    
	    	if(city!=null) {
	    		HttpSession session = request.getSession();
	    		
	    		String message = "Airport already exists ";
				request.setAttribute("messageAirport", message);
	    		RequestDispatcher rd = request.getRequestDispatcher("addAirport.jsp");
  				rd.forward(request, response);
	    		
	    		
	    	}else {
	    		city = new City();
	    		city.setName(airportName);
	    		cityDaoImpl.saveCity(city);
	    		HttpSession session = request.getSession();
	
	    		String message = "Airport added";
				request.setAttribute("messageAirport", message);
	    		RequestDispatcher rd = request.getRequestDispatcher("addAirport.jsp");
  				rd.forward(request, response);
	    		
	    	}
	    	
	    	
	    	
	    	
	    }
	
	    
	    
	}

}
