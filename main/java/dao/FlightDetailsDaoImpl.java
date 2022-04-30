package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import model.Flight;
import model.Flight_PK;

public class FlightDetailsDaoImpl implements FlightDetailsDao{

	public void saveFlight(Flight flight) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(flight);
		transaction.commit();
		session.close();
		
	}

	@Override
	public List<Flight> showAllFlights() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Query q = session.createQuery("from Flight");
         List list = q.list();
        
         return list;
	}

	@Override
	public Flight getFlightDetailsById(int flightNo, Date depatureDate, String travelClass) {
		Session session =
				  HibernateUtil.getSessionFactory().openSession(); // start a transaction
		
		 Transaction transaction = session.beginTransaction();
		Flight flight = null;
		 System.out.println("### getFlightDetailsById() " + flightNo + depatureDate.toString() + travelClass);
					
			      flight = session.get(Flight.class, new Flight_PK(flightNo, depatureDate,travelClass));
			      
				    System.out.println("###  " + flight.toString());
				   

				     transaction.commit();
				        session.close(); 
				     return flight;
				
	}
	
	@Override
	public void updateFlight(Flight flight) 
	{
			   Session session = HibernateUtil.getSessionFactory().openSession();
		        Transaction transaction = session.beginTransaction();
		      
		        session.update(flight);
		        transaction.commit();
		        session.close();
            
      
		}

	@Override
	public void deleteFlight(Flight flight) {
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();
	      
	        session.delete(flight);
	        transaction.commit();
	        session.close();
     
	}

	@Override
	public void updateFlightBookedSeats(Flight flight, int subfactor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update Flight set bookedSeats=:bSeat where flightNo=:fNo and travelClass =:tClass and depatureDate =: depDate"; 
		Query query = session.createQuery(hql);
		
		int newSeats = flight.getBookedSeats() + subfactor;
		System.out.println(newSeats);
		query.setParameter("bSeat", newSeats);
		query.setParameter("fNo", flight.getFlightNo());
		query.setParameter("tClass", flight.getTravelClass());
		query.setParameter("depDate", flight.getDepatureDate());
		int result = query.executeUpdate();
		
	
		System.out.println("Updated " + result );
		transaction.commit();
		session.close();
		
	}

}
