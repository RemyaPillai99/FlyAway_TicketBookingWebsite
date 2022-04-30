package dao;

import java.util.List;

import org.hibernate.Transaction;

import model.User;

import org.hibernate.Session;

public class UserDaoImpl implements UserDao {

	@Override
	public void saveUser(User user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@Override
	public List<User> showAllUsers() {

		return null;
	}

	/**
	 * Get User By ID
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(String emailID) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(User.class, emailID);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(String emailID, String password) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = (User) session.load(User.class, emailID);
			user.setPassword(password);
			session.update(user);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
