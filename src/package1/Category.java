package package1;

public class Category {
	private String ref_categorie;
	private String nom_categorie;
	
	public Category(String ref_categorie, String nom_categorie) {
		this.ref_categorie = ref_categorie;
		this.nom_categorie = nom_categorie;
	}
	
	public Category(String ref_categorie) {
		this.ref_categorie = ref_categorie;
	}

	public String getRef_categorie() {
		return ref_categorie; 
	}
 
	public void setRef_categorie(String ref_categorie) {
		this.ref_categorie = ref_categorie;
	} 

	public String getNom_categorie() {
		return nom_categorie;
	}

	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}

	@Override
	public String toString() {
		return "Category [ref_categorie=" + ref_categorie + ", nom_categorie=" + nom_categorie + "]";
	}
	
}
