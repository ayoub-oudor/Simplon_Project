package package1;

public class Main {
		
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		//////////////////////////////////////////// Product Main ///////////////////////////////////////////////////////////////
		
		//Product product = new Product("C4","head & shoulders", "showers", 4000, 16.99,"C"); 
		
		//insertion
		
		// System.out.println(dao.insert_produit(product));

		//selection 
		//dao.select_produit();
		
		//update 
	    //Product productC4 = new Product("C4","clear", "showers", 5000, 20.99,"C"); 
  
		//dao.updateProduit("C4","C",productC4);
		//dao.select_produit();
		 
		//DELETE
		//dao.delete_produit("C4");
		//dao.select_produit(); 
		
        //////////////////////////////////////////// Category Main ///////////////////////////////////////////////////////////////
		
		//Category category = new Category("D","SPORTS");
		
		//insertion
		
		//System.out.println(dao.insert_categorie(category));
		
		//selection 
		//dao.select_categorie();	
		
		//update 
		//Category category4 = new Category("D","Sports & loisires"); 	
	    //dao.updateCategorie ("D",category4);
	    //dao.select_categorie();	
	    
	    //DELETE
	    //dao.delete_categorie("D");
	    //dao.select_categorie();
		
		//////////////////////////////////////////// selections Products in Category ////////////////////////////////////////////////////////
		//Category categoryA = new Category("A");
		//System.out.println(dao.select_categorie(categoryA));
	}
	
}
