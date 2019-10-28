package tn.esprit.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Formateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFormateur;
	
    private String prenomFormateur;
	
	private String nomFormateur;
	
	private String posteFormateur;
	
	private String mailFormateur;
	
	private int telFormateur;
	
	@OneToMany(mappedBy="formateur")
	private List<Formation> formations;
	
	public Formateur() {
		super();
	}

	public Formateur(int idFormateur, String prenomFormateur, String nomFormateur, String posteFormateur,
			String mailFormateur, int telFormateur) {
		super();
		this.idFormateur = idFormateur;
		this.prenomFormateur = prenomFormateur;
		this.nomFormateur = nomFormateur;
		this.posteFormateur = posteFormateur;
		this.mailFormateur = mailFormateur;
		this.telFormateur = telFormateur;
	}
	
	

	public Formateur(int idFormateur, String prenomFormateur, String nomFormateur, String posteFormateur,
			String mailFormateur, int telFormateur, List<Formation> formations) {
		super();
		this.idFormateur = idFormateur;
		this.prenomFormateur = prenomFormateur;
		this.nomFormateur = nomFormateur;
		this.posteFormateur = posteFormateur;
		this.mailFormateur = mailFormateur;
		this.telFormateur = telFormateur;
		this.formations = formations;
	}
	
	

	public Formateur(String prenomFormateur, String nomFormateur, String posteFormateur, String mailFormateur,
			int telFormateur) {
		super();
		this.prenomFormateur = prenomFormateur;
		this.nomFormateur = nomFormateur;
		this.posteFormateur = posteFormateur;
		this.mailFormateur = mailFormateur;
		this.telFormateur = telFormateur;
	}

	public String getNomFormateur() {
		return nomFormateur;
	}



	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}




	public int getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(int idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getPrenomFormateur() {
		return prenomFormateur;
	}

	public void setPrenomFormateur(String prenomFormateur) {
		this.prenomFormateur = prenomFormateur;
	}

	

	public String getPosteFormateur() {
		return posteFormateur;
	}

	public void setPosteFormateur(String posteFormateur) {
		this.posteFormateur = posteFormateur;
	}

	public String getMailFormateur() {
		return mailFormateur;
	}

	public void setMailFormateur(String mailFormateur) {
		this.mailFormateur = mailFormateur;
	}

	public int getTelFormateur() {
		return telFormateur;
	}

	public void setTelFormateur(int telFormateur) {
		this.telFormateur = telFormateur;
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

	
	
	
	
	
	
	
	
	
	

}
