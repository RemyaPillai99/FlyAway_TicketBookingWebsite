package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Airline;
import model.City;

public class CityDaoImpl implements CityDao{

	@Override
	public void saveCity(City city) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(city);
		transaction.commit();
		session.close();
	}

	@Override
	public List<City> showAllCity() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Query q = session.createQuery("from City");
       List list = q.list();
       return list;
	}

	@Override
	public City getCityByName(String name) {

		Transaction transaction = null;
		City city = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			city = session.get(City.class, name);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return city;
	}
	
	

}
