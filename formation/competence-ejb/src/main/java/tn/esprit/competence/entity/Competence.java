package tn.esprit.competence.entity;

import java.io.Serializable; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity 
@Table(name = "T_COMPETENCE")
public class Competence implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nom_employe")
	private String nomemploye;
	
	private String savoir ;
	
	@Column(name="savoi_faire_operationnel")
	private String savoirfaireop ;
	
	@Column(name="savoir_faire_relationnel")
	private String savoirfairerel ;
	
	//@Column(name="Aptitude")
	private String aptitude;
	
	@ManyToMany(mappedBy="competences", cascade = CascadeType.ALL) 
	private Set<Employe> employes;
	
	
	
	



	public Competence() {
	
	}

	

	public Competence( String nomemploye, String savoir, String savoirfaireop, String savoirfairerel,
			String aptitude) {
	

		this.nomemploye = nomemploye;
		this.savoir = savoir;
		this.savoirfaireop = savoirfaireop;
		this.savoirfairerel = savoirfairerel;
		this.aptitude = aptitude;
	}



	public Competence(int id, String nomemploye, String savoir, String savoirfaireop, String savoirfairerel,
			String aptitude) {
		
		this.id = id;
		this.nomemploye = nomemploye;
		this.savoir = savoir;
		this.savoirfaireop = savoirfaireop;
		this.savoirfairerel = savoirfairerel;
		this.aptitude = aptitude;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSavoir() {
		return savoir;
	}

	public void setSavoir(String savoir) {
		this.savoir = savoir;
	}

	public String getSavoirfaireop() {
		return savoirfaireop;
	}

	public void setSavoirfaireop(String savoirfaireop) {
		this.savoirfaireop = savoirfaireop;
	}

	public String getSavoirfairerel() {
		return savoirfairerel;
	}

	public void setSavoirfairerel(String savoirfairerel) {
		this.savoirfairerel = savoirfairerel;
	}

	public String getAptitude() {
		return aptitude;
	}

	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public String getNomemploye() {
		return nomemploye;
	}

	public void setNomemploye(String nomemploye) {
		this.nomemploye = nomemploye;
	}
	
	
	
	
	
}
