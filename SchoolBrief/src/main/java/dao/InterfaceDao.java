package dao;

import java.util.List;


public interface InterfaceDao<T> {
	public void saveUser(T type);
	public void updateUser(T type);
	public void deleteUser(int id);
	public boolean getUser(String username, String password);
	public boolean getUser(int id);
	public List <T> getAllUser();
}
