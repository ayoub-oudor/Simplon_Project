package DAO;

import java.util.Set;

import Models.User;

public interface InterfaceDao {
	
	public boolean insert(User user);
	
	public Set<User> select();
	
	public boolean update(int id,User user);
	
	public void delete(int id); 
	

}
