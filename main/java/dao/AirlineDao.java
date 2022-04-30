package dao;

import java.util.List;

import model.Airline;

public interface AirlineDao {
	
	 public void saveAirline(Airline airline);
	    public List<Airline> showAllAirLine();
	    public Airline getAirline(int airlineId);
	    public Airline getAirlineByName(String airlineName);

}
