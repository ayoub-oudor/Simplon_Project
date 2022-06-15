package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Connexion.Connexion;
import Models.User;

public class ImplementsDao implements InterfaceDao{
	Statement statement;
	public    Connection connect =Connexion.getConnect();
	@Override 
	public boolean insert(User user) {
		try {
			String sql = "insert into candidat(id,nom,prenom,age,email,adresse,ville,pays) values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getNom());
			ps.setString(3, user.getPrenom());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getAdresse());
			ps.setString(7, user.getVille());
			ps.setString(8, user.getPays());
			ps.execute();
			connect.commit();
			return true;
//			ps.close();
//			connect.close();
		} catch (Exception e) {
			System.err.println("problem in insertion ...");
		}

		return false;
	}
	

	@Override
	public Set<User> select() {
		
		try {

			statement = connect.createStatement();

			String sql = "select * from candidat";



			ResultSet resultSet = statement.executeQuery(sql);
         
			
	       Set<User> list_users = new HashSet<User>();
	       
			while (resultSet.next()) {
				
				 User user  = new User();
				 
				    user.setId(resultSet.getInt("id"));
					user.setNom(resultSet.getString("nom"));
					user.setPrenom(resultSet.getString("prenom"));
					user.setAge(resultSet.getInt("age"));
					user.setEmail(resultSet.getString("email"));
					user.setAdresse(resultSet.getString("adresse"));
					user.setVille(resultSet.getString("ville"));
					user.setPays(resultSet.getString("pays"));
					
					list_users.add(user);
				 
			}
			
			return list_users;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in lister...");
		}

		System.out.println("error");
		return null;

	}



	
	 public boolean update(int id,User user) {		
		try {
		       PreparedStatement stmt = connect.prepareStatement("UPDATE candidat SET nom=?,  prenom=?, age=?, email=?, adresse=?, ville=? ,pays=?  WHERE id=?");

		     stmt.setString(1, user.getNom());
		     stmt.setString(2, user.getPrenom());
		     stmt.setInt(3, user.getAge());
		     stmt.setString(4, user.getEmail());
		     stmt.setString(5, user.getAdresse());
		     stmt.setString(6,user.getVille());
		     stmt.setString(7,user.getPays());
		     stmt.setInt(8 ,user.getId());
		      int i = stmt.executeUpdate();
		     if(i == 1) {
		     return true;
		     }
		   stmt.close();
		   connect.close();

		   } catch (SQLException ex) {
		       ex.printStackTrace();
		   }
			
	

		   return false;

		}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from candidat where id='" + id + "'";
			statement = connect.createStatement();
			statement.executeUpdate(sql);
			System.out.println("User deleted ...");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("problem in deleting ...");
			
		} finally {
			System.out.println("error");
		}
	}

}
