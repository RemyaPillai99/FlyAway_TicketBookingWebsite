package dao;

import java.util.Date;
import java.util.List;

import model.Flight;



public interface FlightDetailsDao {
		
	   public void saveFlight(Flight flight);
	    public List<Flight> showAllFlights();
	    public Flight getFlightDetailsById(int flightNo,Date departureDate,String travelClass);
	    public void updateFlight(Flight flight);
	    public void deleteFlight(Flight flight);
	    public void updateFlightBookedSeats(Flight flight, int subfactor);

}
