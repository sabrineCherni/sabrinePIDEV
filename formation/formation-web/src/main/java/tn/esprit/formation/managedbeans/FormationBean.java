package tn.esprit.formation.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.formation.entity.Collaborateur;
import tn.esprit.formation.entity.Formateur;
import tn.esprit.formation.entity.Formation;
import tn.esprit.formation.service.impl.CollaborateurServiceImpl;
import tn.esprit.formation.service.impl.FormationServiceImpl;

@ManagedBean(name = "formationBean")
@SessionScoped
public class FormationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nomFormation;
	private Formateur formateur;
	private List<Collaborateur> collaborateurs;
	private String typeFormation;
	private String adresseFormation;
	private int nbPlaceFormation;
	private Date dateDebutFormation;
	private Date dateFinFormation;
	private int nbParticipant;

	@EJB
	FormationServiceImpl formationService;
	@EJB
	CollaborateurServiceImpl collaborateurService;

	public void addFormation() {
		formationService.addFormation(new Formation(nomFormation, typeFormation, adresseFormation, nbPlaceFormation,
				dateDebutFormation, dateFinFormation, nbParticipant));
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

	public FormationServiceImpl getFormationService() {
		return formationService;
	}

	public void setFormationService(FormationServiceImpl formationService) {
		this.formationService = formationService;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	private Integer formationIdToBeUpdated;

	public void displayFormation(Formation formation) {
		this.setNomFormation(formation.getNomFormation());
		this.setTypeFormation(formation.getTypeFormation());
		this.setNbPlaceFormation(formation.getNbPlaceFormation());
		this.setFormationIdToBeUpdated(formation.getIdFormation());
		this.setDateDebutFormation(formation.getDateDebutFormation());
		this.setDateFinFormation(formation.getDateFinFormation());
		this.setNbParticipant(formation.getNbParticipant());

	}
	public void participerFormation(Formation formation,String login, String password ) {
		if(formation.getNbParticipant()+1 <formation.getNbPlaceFormation()) {
			
		Collaborateur collaborateur = collaborateurService.getCollaborateurByEmailAndPassword(login, password);
		List<Collaborateur> list = formation.getCollaborateurs();
		list.add(collaborateur);
		formation.setCollaborateurs(list);
		formation.setNbParticipant(formation.getNbParticipant()+1);
	
		formationService.updateFormationAfterParticipation(formation);
		List<Formation> listColl = collaborateur.getFormations();
		listColl.add(formation);
		collaborateur.setFormations(listColl);
		collaborateurService.updateColl(collaborateur);
		}
	}

	public void updateFormation() {
		formationService.updateFormation(new Formation(formationIdToBeUpdated, nomFormation, typeFormation,
				adresseFormation, nbPlaceFormation, dateDebutFormation, dateFinFormation, nbParticipant, null, null));
	}

	public Integer getFormationrIdToBeUpdated() {
		return formationIdToBeUpdated;
	}

	public void setFormationIdToBeUpdated(Integer formationIdToBeUpdated) {
		this.formationIdToBeUpdated = formationIdToBeUpdated;
	}

	public List<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

}
