package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="professeur")
public class Professeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professeur_id")
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
    @OneToMany(mappedBy = "prof" , cascade = CascadeType.ALL)
    private List < Cour > cour = new ArrayList < Cour > ();
    
	public Professeur() {
		super();
	}
	public Professeur(int id, String nom, String prenom, List<Cour> cour) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cour = cour;
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
	public List<Cour> getCour() {
		return cour;
	}
	public void setCour(List<Cour> cour) {
		this.cour = cour;
	}
	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cour=" + cour + "]";
	}
    
}
