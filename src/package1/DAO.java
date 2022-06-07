package package1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO implements InterfaceDAO {
	
	Connection connect =Connexion.getConnect(); 
	
	Statement statement;

	@Override
	public boolean insert_produit(Product produit) { 
			try { 
				String sql = "insert into produit (ref_produit,nom_produit,type_produit,qte,prix,ref_categorie) values (?,?,?,?,?,?)"; 
				PreparedStatement ps = connect.prepareStatement(sql); 
				connect.setAutoCommit(false);
				ps.setString(1, produit.getRef_produit());
				ps.setString(2, produit.getNom_produit());
				ps.setString(3, produit.getType_produit()); 
				ps.setInt(4, produit.getQte());
				ps.setFloat(5, produit.getPrix());
				ps.setString(6, produit.getRef_categorie()); 
				ps.executeUpdate();
				connect.commit(); 
				ps.close();
				connect.close();

			} catch (Exception e) {
				System.err.println(e);
			}
			return true;
		
	}

	@Override
	public boolean insert_categorie(Category category) {
			try {
				String sql = "insert into categorie (ref_categorie,nom_categorie) values (?,?)"; 
				PreparedStatement ps = connect.prepareStatement(sql); 
				connect.setAutoCommit(false);
				ps.setString(1, category.getRef_categorie());
				ps.setString(2, category.getNom_categorie());
				ps.executeUpdate();
				connect.commit(); 
				ps.close();
				connect.close();			
			}
			catch(Exception e){
				System.err.println(e);
			}
			return true;
	}

	@Override
	public boolean select_produit() {

			try {

				statement = connect.createStatement();

				String sql = "select * from produit";

				System.out.println(sql);

				System.out.println("Selection products ..."); 

				ResultSet resultSet = statement.executeQuery(sql);

				System.out.println("try");

				while (resultSet.next()) {
					System.out.print(resultSet.getString("ref_produit") + "\t");
					System.out.print(resultSet.getString("nom_produit") + "\t");
					System.out.print(resultSet.getString("type_produit") + "\t");
					System.out.print(resultSet.getInt("qte") + "\t");
					System.out.print(resultSet.getFloat("prix") + "\t");
					System.out.print(resultSet.getString("ref_categorie") + "\t");
					System.out.println("");
				}

			} catch (Exception e) {
				System.err.println("problem in lister...");
				System.out.println(e);
			}
			
			return true;
	}

	@Override
	public boolean select_categorie() {
		try {

			statement = connect.createStatement();

			String sql = "select * from categorie";

			System.out.println(sql);

			System.out.println("Selection categorys ..."); 

			ResultSet resultSet = statement.executeQuery(sql);

			System.out.println("try");

			while (resultSet.next()) {
				System.out.print(resultSet.getString("ref_categorie") + "\t");
				System.out.print(resultSet.getString("nom_categorie") + "\t");
				System.out.println("");
			}

		} catch (Exception e) {
			System.err.println("problem in lister...");
			System.out.println(e);
		}
		return true;
	}
	@Override
	public boolean updateProduit(String ref_produit, String ref_categorie, Product produit) {
		String sql = "update produit set nom_produit='" + produit.getNom_produit() + "' , type_produit='" + produit.getType_produit() + "' , qte='" + produit.getQte() + "' , prix='" + produit.getPrix() + "' , ref_categorie='" + ref_categorie + "'   where ref_produit='" + ref_produit + "' ";
		int nblignesaffectees = 0;
		try { 
			nblignesaffectees = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(nblignesaffectees);

		return true;
	}

	@Override
	public boolean updateCategorie(String ref_categorie, Category category) {
		String sql = "update categorie set nom_categorie='" + category.getNom_categorie() + "'   where ref_categorie='" + ref_categorie + "' ";
		int nblignesaffectees = 0;
		try { 
			nblignesaffectees = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println(nblignesaffectees);

		return true;
	}

	@Override
	public boolean delete_produit(String ref_produit) {
		  try { 
		  String sql = "delete from produit where ref_produit='" + ref_produit +"'";
		  System.out.println(sql); 
		  statement.executeUpdate(sql);
		  System.out.println("product deleted ..."); 
		  } 
		  
		  catch (Exception e) { 
			  System.err.println(e); 		  
			  System.err.println("problem in deleting ..."); 
		  }
		 
		return true;
	}

	@Override
	public boolean delete_categorie(String ref_categorie) {
		  try { 
		  String sql = "delete from categorie where ref_categorie='" + ref_categorie +"'";
		  System.out.println(sql); 
		  statement.executeUpdate(sql);
		  System.out.println("category deleted ..."); 
		  } 
		  
		  catch (Exception e) { 
			  System.err.println("problem in deleting ..."); 
		  }
		 
		return true;
	}
	
	
	@Override
	public boolean select_categorie(Category category) {
		try {

			statement = connect.createStatement();
			String sql =  "select * from categorie  join produit on  produit.ref_categorie = categorie.ref_categorie  WHERE categorie.ref_categorie ='" + category.getRef_categorie() + "'";         
			ResultSet resultSet = statement.executeQuery(sql);

			System.out.println("Selection products in category ..."); 

			

			while (resultSet.next()) {
				System.out.print(resultSet.getString("ref_produit") + "\t");
				System.out.print(resultSet.getString("nom_produit") + "\t");
				System.out.print(resultSet.getString("type_produit") + "\t");
				System.out.print(resultSet.getInt("qte") + "\t");
				System.out.print(resultSet.getFloat("prix") + "\t");
				System.out.println("");
			}

		} catch (Exception e) {
			System.err.println("problem in lister...");
			System.out.println(e);
		}
		
		return true;
	}
}

