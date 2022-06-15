package Models;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private String adresse;
	private String ville;
	private String pays;
	private String password;
	
	public User(int id,String nom, String prenom, int age, String email, String adresse, String ville,String pays,String password) {
		this.id = id; 
		this.nom = nom; 
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.password=password;
}
	
	
	public User() {
	}

	public User(String nom, String prenom, int age, String email, String adresse, String ville,String pays) {
		this.nom = nom; 
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	} 

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email
				+ ", adresse=" + adresse + ", ville=" + ville + ", pays=" + pays + "]"; 
		
	}
	public void afficher() {
		System.out.println(toString());
	} 
	

}