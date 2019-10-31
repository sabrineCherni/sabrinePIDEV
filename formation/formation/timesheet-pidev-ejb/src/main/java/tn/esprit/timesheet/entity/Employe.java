package tn.esprit.timesheet.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;

@Entity 
//@Table(name = "T_EMPLOYE") 
public class Employe  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;
	
	//@Column(unique=true)
	private String email;
	
	private String password;	
	
	private boolean isActif;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Role role;
	
	

	@OneToMany(mappedBy="employe")
	private List<Tache> taches;
	
	public Employe() {
	}
	
	public Employe(String nom, String prenom, String email, String password, boolean isActif, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password; 
		this.isActif = isActif;
		this.role = role;
	}
	public Employe(int id, String prenom, String nom, String email, String password, Boolean isActif, Role role) { 
		this.id = id; 
		this.prenom = prenom; 
		this.nom = nom; 
		this.email = email;
	this.password = password;
	this.isActif = isActif;
	this.role = role; }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getisActif() {
		return isActif;
	}

	public void setisActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	
}
