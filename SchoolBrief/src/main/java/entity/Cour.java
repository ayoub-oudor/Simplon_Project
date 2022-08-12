package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cour")
public class Cour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_cour")
	private int ref;
	@Column(name = "name")
	private String name;
	@Column(name = "date")
	private String date;
	@ManyToOne()
	private Professeur prof;
	@ManyToOne()
	private Student student;
	
	public Cour() {
		super();
	}
	public Cour(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}
	public Cour(int id,String username, String date) {
		super();
		this.ref=id;
		this.name = username;
		this.date = date;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Cour [ref=" + ref + ", name=" + name + ", date=" + date + "]";
	}
	
}
