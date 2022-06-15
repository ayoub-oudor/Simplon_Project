package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class Connexion {
	private static String url = "jdbc:postgresql://localhost:5432/brief5";
	private static String user = "postgres";
	private static String password = "18014733"; 
	private static Connection  connect;
	 
	public static Connection getConnect() { 

	try 
	    {
	      Class.forName("org.postgresql.Driver"); 
	      connect = DriverManager.getConnection(url,user,password);
	      System.out.println("connected to postgresql service ");
	     	return connect;  
	    }  
	    catch(Exception e){  
	      System.out.println(e); 
	    }
	return null;
	
  }
}
