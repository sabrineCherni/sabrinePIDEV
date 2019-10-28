package tn.esprit.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Collaborateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    private String prenom;
	
	private String nom;
	
	private String password;
	
	private String poste;
	
	private String mail;
	
	private int tel;
	
	
	
	@ManyToMany
	private List<Formation> formations;



	public Collaborateur(int id, String prenom, String nom, String poste, String mail, int tel,
			List<Formation> formations) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
		this.formations = formations;
	}
	


	public Collaborateur(int id, String prenom, String nom, String poste, String mail, int tel, String password,
			List<Formation> formations) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
		this.password = password;
		this.formations = formations;
	}



	public Collaborateur(int id, String prenom, String nom, String poste, String mail, int tel, String password) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
		this.password = password;
	}



	public Collaborateur(int id, String prenom, String nom, String password, String poste, String mail, int tel) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
	}



	public Collaborateur() {
		super();
	}

	

	

	public Collaborateur(String prenom, String nom, String poste, String mail, int tel) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public Collaborateur(String prenom, String nom, String poste, String mail, int tel, String password) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
		this.password = password;
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

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
