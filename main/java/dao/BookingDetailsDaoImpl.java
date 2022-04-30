package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.BookingDetail;

public class BookingDetailsDaoImpl implements BookingDetailsDao{

	@Override
	public void saveBookingDetails(BookingDetail bookingDetail) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bookingDetail);
		transaction.commit();
		session.close();
		
	}

}
