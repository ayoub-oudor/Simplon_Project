package package1;

public interface InterfaceDAO {   //type of class 

	//CREATE product
	boolean insert_produit(Product produit); 
	
	//CREATE product
	boolean insert_categorie(Category category); 
	
    //READ product
	boolean select_produit();
	
    //READ product
	boolean select_categorie();
	
    //READ product in a category
	boolean select_categorie(Category category);
	
	//UPDATE 

	boolean updateProduit(String ref_produit,String ref_category, Product produit); 

	//UPDATE

	boolean updateCategorie(String ref_categorie, Category category); 
	
	//DELETE
	boolean delete_produit(String ref_produit);
	
	//DELETE
	boolean delete_categorie(String ref_categorie);

}