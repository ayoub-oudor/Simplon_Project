package package1;

public class Product extends Category {
	private String ref_produit;
	private String nom_produit;
	private String type_produit; 
	private int qte;
	private double prix; 
	
	 public Product(String ref_produit, String nom_produit, String type_produit, int qte, double prix, String ref_categorie) {
		super(ref_categorie, ref_categorie);
		this.ref_produit=ref_produit; 
		this.nom_produit = nom_produit;
		this.type_produit = type_produit;
		this.qte = qte;  
		this.prix = prix; 
	}


	public String getRef_produit() {
		return ref_produit;
	}

	public void setRef_produit(String ref_produit) {
		this.ref_produit = ref_produit;
	}

	public String getNom_produit() {
		return nom_produit;
	}

	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}

	public String getType_produit() {
		return type_produit;
	}

	public void setType_produit(String type_produit) {
		this.type_produit = type_produit;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrix() {
		return (float) prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Product [ref_produit=" + ref_produit + ", nom_produit=" + nom_produit + ", type_produit=" + type_produit
				+ ", qte=" + qte + ", prix=" + prix + "]";
	}
	
	
}

