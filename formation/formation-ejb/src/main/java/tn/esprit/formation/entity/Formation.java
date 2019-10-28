package tn.esprit.formation.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Formation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFormation;
	
    private String nomFormation;
    
    private String typeFormation;
    
    private String adresseFormation;
    
    private int nbPlaceFormation;
    
    private String dateFormation;
    
    private String heureFormation;
    
    private int nbParticipant;
    
    @ManyToMany(mappedBy="formations")
	private List<Collaborateur> collaborateurs;
    
    @ManyToOne
    @JoinColumn(name = "idFormateur", referencedColumnName = "idFormateur", insertable=false, updatable=false)
	private Formateur formateur;
    
    

	public Formation() {
		super();
	}



	public Formation(int idFormation, String nomFormationr, String typeFormation, String adresseFormation,
			int nbPlaceFormation, String dateFormation, String heureFormation, int nbParticipant,
			List<Collaborateur> collaborateurs, Formateur formateur) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormationr;
		this.typeFormation = typeFormation;
		this.adresseFormation = adresseFormation;
		this.nbPlaceFormation = nbPlaceFormation;
		this.dateFormation = dateFormation;
		this.heureFormation = heureFormation;
		this.nbParticipant = nbParticipant;
		this.collaborateurs = collaborateurs;
		this.formateur = formateur;
	}
	



	public Formation(String nomFormation, String typeFormation, String adresseFormation, int nbPlaceFormation,
			String dateFormation, String heureFormation, int nbParticipant) {
		super();
		this.nomFormation = nomFormation;
		this.typeFormation = typeFormation;
		this.adresseFormation = adresseFormation;
		this.nbPlaceFormation = nbPlaceFormation;
		this.dateFormation = dateFormation;
		this.heureFormation = heureFormation;
		this.nbParticipant = nbParticipant;
	}



	public int getIdFormation() {
		return idFormation;
	}



	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}



	public String getNomFormation() {
		return nomFormation;
	}



	public void setNomFormation(String nomFormationr) {
		this.nomFormation = nomFormationr;
	}



	public String getTypeFormation() {
		return typeFormation;
	}



	public void setTypeFormation(String typeFormation) {
		this.typeFormation = typeFormation;
	}



	public String getAdresseFormation() {
		return adresseFormation;
	}



	public void setAdresseFormation(String adresseFormation) {
		this.adresseFormation = adresseFormation;
	}



	public int getNbPlaceFormation() {
		return nbPlaceFormation;
	}



	public void setNbPlaceFormation(int nbPlaceFormation) {
		this.nbPlaceFormation = nbPlaceFormation;
	}



	public String getDateFormation() {
		return dateFormation;
	}



	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}



	public String getHeureFormation() {
		return heureFormation;
	}



	public void setHeureFormation(String heureFormation) {
		this.heureFormation = heureFormation;
	}



	public int getNbParticipant() {
		return nbParticipant;
	}



	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}



	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}



	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}



	public Formateur getFormateur() {
		return formateur;
	}



	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
	
    
	
	
	
	
	
	
	
	
	
	

}
