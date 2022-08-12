package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Cour;
import hibernateutil.HibernateUtil;

public class CourDao implements InterfaceDao<Cour> {



	@Override
	public void saveUser(Cour course) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction 
			transaction = session.beginTransaction();
			// save the student object
			session.save(course);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); 
		}
		
	}

	@Override
	public void updateUser(Cour course) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(course);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a course object
			Cour course = session.get(Cour.class, id);
			if (course != null) {
				session.delete(course);
				System.out.println("course is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void getUser(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUser(int id) {
		Transaction transaction = null;
		Cour course = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an course object
			course = session.get(Cour.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}	
	}

	@Override
	public List<Cour> getAllUser() {
		return null;
	}

}
