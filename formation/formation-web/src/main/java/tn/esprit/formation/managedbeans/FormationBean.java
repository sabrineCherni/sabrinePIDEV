package tn.esprit.formation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.formation.entity.Collaborateur;
import tn.esprit.formation.entity.Formation;
import tn.esprit.formation.service.impl.FormationServiceImpl;



@ManagedBean(name = "formationBean")
@SessionScoped
public class FormationBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nomFormation; 
	private String typeFormation; 
	private String adresseFormation;
	private int nbPlaceFormation;
	private String dateFormation;
	private String heureFormation;
	private int nbParticipant;
	
	@EJB
	FormationServiceImpl formationService;
	
	public void addFormation() {
		formationService.addFormation(new Formation(nomFormation, typeFormation, adresseFormation, nbPlaceFormation, dateFormation, 
				heureFormation, nbParticipant));
		}
	
	public void removeFormation(int formationId) { 
		formationService.removeFormation(formationId);
		}
	
	

	
	

	
	public FormationBean() {
		super();
	}
	
	
	private List<Formation> formations;
	public List<Formation> getFormations() {
	formations = formationService.getAllFormations();
	return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
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

	public FormationServiceImpl getFormationService() {
		return formationService;
	}

	public void setFormationService(FormationServiceImpl formationService) {
		this.formationService = formationService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 


	private Integer formationIdToBeUpdated;
	public void displayFormation(Formation formation)
	{
	this.setNomFormation(formation.getNomFormation());
	this.setTypeFormation(formation.getTypeFormation());
	this.setNbPlaceFormation(formation.getNbPlaceFormation());
    this.setFormationIdToBeUpdated(formation.getIdFormation());
    this.setDateFormation(formation.getDateFormation());
	this.setHeureFormation(formation.getHeureFormation());
	this.setNbParticipant(formation.getNbParticipant());
	
	}
	
	public void updateFormation()
	{ formationService.updateFormation(new Formation(formationIdToBeUpdated, nomFormation, typeFormation,
	adresseFormation, nbPlaceFormation, dateFormation,heureFormation, nbParticipant, null, null)); }
	
	public Integer getFormationrIdToBeUpdated() {
		return formationIdToBeUpdated;
	}
	public void setFormationIdToBeUpdated(Integer formationIdToBeUpdated) {
		this.formationIdToBeUpdated = formationIdToBeUpdated;
	} 
	
	
	
	
	
	
	
	

}
