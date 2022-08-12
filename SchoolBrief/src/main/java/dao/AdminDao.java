package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Admin;
import entity.Professeur;
import hibernateutil.HibernateUtil;


public class AdminDao implements InterfaceDao<Admin>{
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void saveUser(Admin admin) {
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();	  
	} 
	
	public void updateUser(Admin admin) {
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.update(admin);
		session.getTransaction().commit();
		session.close();		
	}

	public void getUser(String username, String password) {
        Transaction transaction = null;
        Admin admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            admin = session.get(Admin.class, username);
            admin = session.get(Admin.class, password);
          
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
	}
//	Admin admin;
//	Session session = sessionFactory.openSession();		
//	session.beginTransaction();
//    admin = session.get(Admin.class, username);
//    admin = session.get(Admin.class, password);
//	session.getTransaction().commit();
//	session.close();
//	return false;
	
    @SuppressWarnings("unchecked")
	public List<Admin> getAllUser() {
    	Transaction transaction = null;
        List < Admin > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from admin").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
	}

	public void deleteUser(int id) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a user object
            Admin admin = session.get(Admin.class, id);
            if (admin != null) {
                session.delete(admin);
                System.out.println("Admin is deleted");
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
	public void getUser(int id) {
		
		Transaction transaction = null;
		Admin admin = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an course object
			admin = session.get(Admin.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}
	
}
