package tn.esprit.formation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



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
    
    @Temporal(TemporalType.DATE)
	private Date dateDebutFormation;
	@Temporal(TemporalType.DATE)
	private Date dateFinFormation;
    private int nbParticipant;
    
    @ManyToMany(mappedBy="formations" , fetch = FetchType.EAGER )
	private List<Collaborateur> collaborateurs;
    
    @ManyToOne
    @JoinColumn(name = "idFormateur", referencedColumnName = "idFormateur", insertable=false, updatable=false)
	private Formateur formateur;
    
    

	public Formation() {
		super();
	}



	public Formation(int idFormation, String nomFormationr, String typeFormation, String adresseFormation,
			int nbPlaceFormation, Date dateFormation, Date dateFinformation, int nbParticipant,
			List<Collaborateur> collaborateurs, Formateur formateur) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormationr;
		this.typeFormation = typeFormation;
		this.adresseFormation = adresseFormation;
		this.nbPlaceFormation = nbPlaceFormation;
		this.dateDebutFormation = dateFormation;
		this.dateFinFormation = dateFinformation;
		this.nbParticipant = nbParticipant;
		this.collaborateurs = collaborateurs;
		this.formateur = formateur;
	}
	



	public Formation(String nomFormation, String typeFormation, String adresseFormation, int nbPlaceFormation,
			Date dateFormation, Date dateFinformation, int nbParticipant) {
		super();
		this.nomFormation = nomFormation;
		this.typeFormation = typeFormation;
		this.adresseFormation = adresseFormation;
		this.nbPlaceFormation = nbPlaceFormation;
		this.dateDebutFormation = dateFormation;
		this.dateFinFormation = dateFinformation;
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





	public Date getDateDebutFormation() {
		return dateDebutFormation;
	}



	public void setDateDebutFormation(Date dateDebutFormation) {
		this.dateDebutFormation = dateDebutFormation;
	}



	public Date getDateFinFormation() {
		return dateFinFormation;
	}



	public void setDateFinFormation(Date dateFinFormation) {
		this.dateFinFormation = dateFinFormation;
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
