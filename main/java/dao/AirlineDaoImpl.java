package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Airline;
import model.User;

public class AirlineDaoImpl implements AirlineDao{

	@Override
	public void saveAirline(Airline airline) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(airline);
		transaction.commit();
		session.close();
	}

	/**
	 * Get User By ID
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Airline getAirline(int airlineId) {

		Transaction transaction = null;
		Airline airline = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			airline = session.get(Airline.class, airlineId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return airline;
	}

	@Override
	public List<Airline> showAllAirLine() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Query q = session.createQuery("from Airline");
        List list = q.list();
        return list;
	}

	/**
	 * Get Airline By AirlineName
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Airline getAirlineByName(String airlineName) {

		Session session =
				  HibernateUtil.getSessionFactory().openSession(); // start a transaction
		
		Airline airline = null;
			      Query query = session.createQuery("from Airline where airlineName = :airlineName");
			      query.setString("airlineName", airlineName);
			      airline = (Airline)query.uniqueResult();
				   // System.out.println("### Airline " + airline.getAirlineName());
				     return airline;
				
				
		}
	

}
