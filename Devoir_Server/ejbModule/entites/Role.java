package entites;


import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity

public class Role implements Serializable {


	private static final long serialVersionUID = -6411231565817922531L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
   
}
