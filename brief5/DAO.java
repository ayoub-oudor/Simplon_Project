package brief5;

import java.sql.Connection;

public interface DAO<T> {   //type of class 
	public    Connection connect =Connexion.getConnect();

	//CREATE
	Candidat save(T item);
	
    //READ
	T read();
	
	//UPDATE

	public boolean update(int id, String nom); 
	
	//DELETE
	public boolean  delete(int id);

	
	
	
}
