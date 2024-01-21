package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import entites.Filiere;
import entites.Role;

public class StudentDto implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	
		private Long id;
		private String login;
		private String password;
	    private String firstName;
	    private String lastName;
	    private String telephone;
	    private Filiere filiere;
	    private Collection<Role>roles=new ArrayList<Role>();
		public Collection<Role> getRoles() {
			return roles;
		}
		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public StudentDto(Long id, String login, String password, String firstName, String lastName,
				String telephone, Filiere filiere) {
			super();
			this.id = id;
			this.login = login;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.telephone = telephone;
			this.filiere = filiere;
		}
		public StudentDto(String login, String password, String firstName, String lastName, String telephone,
				Filiere filiere) {
			super();
			this.login = login;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.telephone = telephone;
			this.filiere = filiere;
		}
		public StudentDto(String login, String password, String firstName, String lastName, String telephone) {
			super();
			this.login = login;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.telephone = telephone;
		}
		public StudentDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "StudentDto [id=" + id + ", login=" + login + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", telephone=" + telephone + ", filiere=" + filiere + ", roles="
					+ roles + "]";
		}
	    // Other relevant fields and getters/setters

	
}
