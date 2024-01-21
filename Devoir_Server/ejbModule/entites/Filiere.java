package entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Filiere implements Serializable {
	
	
	private static final long serialVersionUID = 826854562564745326L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Filiere(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public Filiere() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Filiere [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
	
	

}
