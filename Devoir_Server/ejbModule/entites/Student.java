package entites;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User implements Serializable{
	

	
	
	private static final long serialVersionUID = -3792748931853683211L;
	
	
	private String firstName;
	private String lastName;
	private String telephone;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Filiere filiere;
	
	
	
	
	
	public Student(Long id, String password, String login, String firstName, String lastName, String telephone,
			Filiere filiere) {
		super(id, password, login);
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.filiere = filiere;
	}
	public Student( String password, String login, String firstName, String lastName, String telephone,
			Filiere filiere) {
		super( password, login);
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.filiere = filiere;
	}




	public Student(Long id, String password, String login) {
		super(id, password, login);
		// TODO Auto-generated constructor stub
	}




	public Student(String password, String login) {
		super(password, login);
		// TODO Auto-generated constructor stub
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Student( String password, String login, String firstName, String lastName, String telephone) {
		super( password, login);
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		
	}
	
	
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		super.toString();
		return super.toString()+"Student [firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone + ", filiere="
				+filiere+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
