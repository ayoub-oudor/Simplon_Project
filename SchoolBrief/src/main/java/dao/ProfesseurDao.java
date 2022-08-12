package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Admin;
import entity.Cour;
import entity.Professeur;
import hibernateutil.HibernateUtil;

public class ProfesseurDao implements InterfaceDao<Professeur> {

	@Override
	public void saveUser(Professeur prof) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction 
			transaction = session.beginTransaction();
			// save the student object
			session.save(prof);
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
	public void updateUser(Professeur prof) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(prof);
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
			Professeur prof = session.get(Professeur.class, id);
			if (prof != null) {
				session.delete(prof);
				System.out.println("prof is deleted");
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
	public boolean getUser(String username, String password) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getUser(int id) {
			Transaction transaction = null;
			Professeur prof = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// get an course object
				prof = session.get(Professeur.class, id);
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return false;
		
	}

	@Override
	public List<Professeur> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}



}
