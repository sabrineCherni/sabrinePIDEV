package tn.esprit.competence.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.competence.entity.Formation;
import tn.esprit.competence.services.impl.FormationService;


@ManagedBean(name = "formationBean") 
@SessionScoped 
public class FormationBean implements Serializable {

	
	private static final long serialVersionUID = 1L; 

	private List<Formation> formations;
    private String formationc;
    private Integer formationIdToBeUpdated; 

	@EJB 
	FormationService formationService; 
	public void addFormation() { 
		
	   formationService.ajouterFormation(new  Formation( formationc ) ); 
	   }
	public void removeFormation(int formationId) { 
		formationService.deleteFormationById(formationId); }
	public void displayFormation(Formation empl) { 
    this.setFormationc(empl.getFormationc());  
	this.setFormationIdToBeUpdated(empl.getId()); }

	
	public void updateFormation() { 
		formationService.updateFormation(new Formation(  formationIdToBeUpdated,  formationc));
		} 
	public List<Formation> getFormations() {
		formations = formationService.getAllFormations(); 
		return formations;
	}
	public String getFormationc() {
		return formationc;
	}
	public void setFormationc(String formationc) {
		this.formationc = formationc;
	}
	public Integer getFormationIdToBeUpdated() {
		return formationIdToBeUpdated;
	}
	public void setFormationIdToBeUpdated(Integer formationIdToBeUpdated) {
		this.formationIdToBeUpdated = formationIdToBeUpdated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
