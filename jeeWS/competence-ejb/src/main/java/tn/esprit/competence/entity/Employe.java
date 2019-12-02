package tn.esprit.competence.entity;

import java.io.Serializable; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;


@Entity 
//@Table(name = "T_EMPLOYE")
public class Employe implements Serializable{
	
	
	public Employe() {
		
	}



	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;
	
	//@Column(unique=true)
	private String email;
	
	
	private String password;
	
	@Column(name = "grade")
	private String grade;
	
	@Transient
	@ManyToMany(mappedBy="employes") 
	private Set<Competence> competences;
	
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Role role;
	
	
	
	

	
	
	


















	/*public Employe(int id, String prenom, String nom, String email, String password, String grade, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.grade = grade;
		this.role = role;
	}*/



	



	



	public Employe(String prenom2, String nom2, String email2, String password2, String grade2, Role role2) {
		// TODO Auto-generated constructor stub
		
	}











	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	














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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Set<Competence> getCompetences() {
		return competences;
	}



	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}	
	

	


}
