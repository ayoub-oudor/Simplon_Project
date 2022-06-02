package brief5;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
 

public class Connexion { 
	// soit methode static ou dynamique avec methode connect()
	//public static void main(String args[]){
	private static String url = "jdbc:postgresql://localhost:5432/brief5";
	private static String user = "postgres";
	private static String password = "18014733"; 
	private static Connection  connect;
	
	public static Connection getConnect() { 

	try
	    {
	      //étape 1: charger la classe de driver
	      Class.forName("org.postgresql.Driver"); 
	      //étape 2: créer l'objet de Connexion
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

