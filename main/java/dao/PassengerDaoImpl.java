package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Passenger;
import model.PassengerIDProof;
import model.User;

public class PassengerDaoImpl implements PassengerDao {

	@Override
	public void savePassenger(Passenger passenger) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(passenger); 
		System.out.println("### Passenger id after save "+id);
		transaction.commit();
		session.close();
		
	}
	
	@Override
	public void savePassengerIDProof(PassengerIDProof passengerIDProof) {
		System.out.println(passengerIDProof.getIdProof_no() + passengerIDProof.getIdProofName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(passengerIDProof);
		transaction.commit();
		session.close();
		
	}

	@Override
	public List<Passenger> showAllPassengers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger getPassenger(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	public PassengerIDProof getPassengerIDProofbyId(String idProof_no) {
		
		Transaction transaction = null;
		PassengerIDProof passengerIDProof = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			passengerIDProof = session.get(PassengerIDProof.class, idProof_no);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return passengerIDProof;
	
		
		
	}
	
	public Passenger getPassengerbyId(Long passenger_Id) {
		
		Transaction transaction = null;
		Passenger passenger = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			passenger= session.get(Passenger.class, passenger_Id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return passenger;
	
		
		
	}

}
