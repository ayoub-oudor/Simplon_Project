package hibernateutil;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import entity.Admin;
import entity.Cour;
import entity.Professeur;
import entity.Student;

public class HibernateUtil {

    private static SessionFactory sessionFactory; 
   // private static ServiceRegistry serviceRegistry;
	 public static SessionFactory getSessionFactory() { 
  	if (sessionFactory == null) {
        try {
    	    Configuration configuration = new Configuration();

    	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
    	    Properties settings = new Properties();
    	    settings.put(Environment.DRIVER, "org.postgresql.Driver");
    	    settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/school");
    	    settings.put(Environment.USER, "postgres");
    	    settings.put(Environment.PASS, "18014733");
    	    settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
    	    settings.put(Environment.SHOW_SQL, "true");
    	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
    	    settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//    	    settings.put(Environment.HBM2DDL_AUTO, "update");
    	    configuration.setProperties(settings);
    	    configuration.addAnnotatedClass(Admin.class);
    	    configuration.addAnnotatedClass(Cour.class);
    	    configuration.addAnnotatedClass(Professeur.class);
    	    configuration.addAnnotatedClass(Student.class);

    	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    	      .applySettings(configuration.getProperties()).build();
    	    System.out.println("Hibernate Java Config serviceRegistry created");
    	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	    return sessionFactory;
        } 
  	    
        catch(HibernateException exception) {
            System.out.println("Problem creating session factory!");
        }   
    }
	return sessionFactory;
    }

}
