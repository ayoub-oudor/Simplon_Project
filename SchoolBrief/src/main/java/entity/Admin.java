package entity;
import javax.persistence.*;



@Entity
@Table(name="admin")
public class Admin  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id") 
	private int id;
	@Column(name = "username")  
	private String username;
	@Column(name = "password")
	private String password;

	public Admin() {
		super(); 
	}

	public Admin(String us, String ps) {
		this.username = us;
		this.password = ps;
	}
	public Admin(int id) {
		this.id=id;
	}
	
	public Admin(int id, String us, String ps) {
		this.id=id;
		this.username = us;
		this.password = ps;	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}