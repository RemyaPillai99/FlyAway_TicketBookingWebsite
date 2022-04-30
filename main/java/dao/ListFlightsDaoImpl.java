package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Flight;


public class ListFlightsDaoImpl implements ListFlightsDao{

	@SuppressWarnings("deprecation")
	@Override
	public List<Flight> listFlights(final String sourceName, final String destName, final Date depatureDate) {
		Session session =
				  HibernateUtil.getSessionFactory().openSession(); // start a transaction
		
		System.out.println("before Date "+ depatureDate);
		
		Query query = session.createQuery("from Flight where sourceName = :sourceName " +
				  "AND depatureDate = :depatureDate " 
				+ "AND  destName = :destName ");
				  query.setString("sourceName", sourceName); query.setDate("depatureDate",
				  depatureDate); query.setString("destName", destName);
				  
			List<Flight> flightList =query.getResultList();
				  
			

			System.out.println(sourceName +flightList);
		return flightList;
	}

}
