package tn.esprit.formation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import tn.esprit.formation.entity.Collaborateur;
import tn.esprit.formation.service.impl.CollaborateurServiceImpl;

@ManagedBean(name = "collaborateurBean")
@SessionScoped
public class CollaborateurBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String prenom;
	private String nom;
	private String password;
	private String poste;
	private String mail;
	private int tel;

	@EJB
	CollaborateurServiceImpl collaborateurService;

	public void addColl() {
		collaborateurService.addColl(new Collaborateur(prenom, nom, poste, mail, tel));
	}

	public void removeColl(int collaborateurId) {
		collaborateurService.removeColl(collaborateurId);
	}

	public void validateAField(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String inputValue = (String) value;
		if (!inputValue.contains("@")) {
			FacesMessage msg = new FacesMessage("Mauvais format : Le mail doit contenir un @");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

	public CollaborateurBean() {
		super();
	}

	private List<Collaborateur> collaborateurs;
	
	public String goFormation(String login, String password) {
		String navigateTo = "null";
		Collaborateur collaborateur = collaborateurService.getCollaborateurByEmailAndPassword(login, password);
		if (collaborateur != null) {
			navigateTo = "/pages/admin/formation?faces-redirect=true";  }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; }
	public List<Collaborateur> getCollaborateurs() {
		collaborateurs = collaborateurService.getAllCollaborateurs();
		return collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CollaborateurBean(String prenom, String nom, String password, String poste, String mail, int tel,
			CollaborateurServiceImpl collaborateurService) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.poste = poste;
		this.mail = mail;
		this.tel = tel;
		this.collaborateurService = collaborateurService;
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

	public CollaborateurServiceImpl getCollaborateurService() {
		return collaborateurService;
	}

	public void setCollaborateurService(CollaborateurServiceImpl collaborateurService) {
		this.collaborateurService = collaborateurService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Integer collaborateurIdToBeUpdated;

	public void displayColl(Collaborateur collaborateur) {
		this.setCollaborateurIdToBeUpdated(collaborateur.getId());
		this.setPrenom(collaborateur.getPrenom());
		this.setNom(collaborateur.getNom());
		this.setPassword(collaborateur.getPassword());
		this.setPoste(collaborateur.getPoste());
		this.setMail(collaborateur.getMail());
		this.setTel(collaborateur.getTel());

	}

	public void updateColl() {
		collaborateurService
				.updateColl(new Collaborateur(collaborateurIdToBeUpdated, prenom, nom, password, poste, mail, tel));
	}

	public Integer getCollaborateurIdToBeUpdated() {
		return collaborateurIdToBeUpdated;
	}

	public void setCollaborateurIdToBeUpdated(Integer collaborateurIdToBeUpdated) {
		this.collaborateurIdToBeUpdated = collaborateurIdToBeUpdated;
	}

}
