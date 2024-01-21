package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {
	

	private static final long serialVersionUID = 4600886577792632566L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String password;
	protected String login;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_role" ,
				joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
	
	private Collection<Role>roles;
	
	
	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User(Long id, String password, String login) {
		super();
		this.id = id;
		this.password = password;
		this.login = login;
	}

	public User(String password, String login) {
		super();
		this.password = password;
		this.login = login;
	}

	

	public User() {
		super();
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", login=" + login + ", roles=" + roles + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}



	public java.util.Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(java.util.Collection<Role> roles) {
		this.roles = roles;
	}

	
   
	
	
}
