package dao;

import java.util.Date;
import java.util.List;

import model.Flight;

public interface ListFlightsDao {
	public List<Flight> listFlights(String source, String dest, Date depatureDate);
}
