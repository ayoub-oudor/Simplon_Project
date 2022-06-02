package brief5;

import java.sql.*;

public class CandidatDao implements DAO<Candidat> {
	private Statement statement;

	@Override
	public Candidat save(Candidat item) {

		try {
			String sql = "insert into candidat(nom,prenom,age,email,adresse,ville,pays) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);

			connect.setAutoCommit(false);

			ps.setString(1, item.getNom());
			ps.setString(2, item.getPrenom());
			ps.setInt(3, item.getAge());
			ps.setString(4, item.getEmail());
			ps.setString(5, item.getAdresse());
			ps.setString(6, item.getVille());
			ps.setString(7, item.getPays());
			ps.execute();
			connect.commit();
			//ps.close();
			//connect.close();
			return item;

		} catch (Exception e) {
			System.err.println("problem in insertion ...");
		}
		return null;
	}

	@Override
	public Candidat read() {

		try {

			statement = connect.createStatement();

			String sql = "select * from candidat";

			System.out.println(sql);

			System.out.println("Selection users ...");

			ResultSet resultSet = statement.executeQuery(sql);

			System.out.println("try");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt("id") + "\t");
				System.out.print(resultSet.getString("nom") + "\t");
				System.out.print(resultSet.getString("prenom") + "\t");
				System.out.print(resultSet.getInt("age") + "\t");
				System.out.print(resultSet.getString("email") + "\t");
				System.out.print(resultSet.getString("adresse") + "\t");
				System.out.print(resultSet.getString("ville") + "\t");
				System.out.print(resultSet.getString("pays") + "\t");

				System.out.println("");
			}

		} catch (Exception e) {
			System.err.println("problem in lister...");
		}

		return null;
	}

//	public static void update(int id ,String name)
//	{
//	String sql="update user set name='"+name+"' where userid="+id+"";

	@Override
	public boolean update(int id, String nom) {

		String sql = "update candidat set nom='" + nom + "' where id=" + id + "";
		int nblignesaffectees = 0;
		try {
			nblignesaffectees = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(nblignesaffectees);

		return false;
	}

	@Override
	public boolean delete(int id) {

		
		  boolean b = false;
		  
		  try { 
		  String sql = "delete from candidat where id='" + id +"'";
		  System.out.println(sql); statement.executeUpdate(sql);
		  System.out.println("User deleted ..."); b = true;
		  
		  } catch (Exception e) { System.err.println("problem in deleting ..."); }
		 
		return false;

	}

}
