package tn.esprit.formation.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.formation.entity.Collaborateur;
import tn.esprit.formation.service.impl.CollaborateurServiceImpl;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	
	
	private String login; 
	private String password; 
	private Collaborateur collaborateur; 
	private Boolean loggedIn;
	@EJB
	CollaborateurServiceImpl collaborateurService;
	public String doLogin() {
		String navigateTo = "null";
		collaborateur = collaborateurService.getCollaborateurByEmailAndPassword(login, password);
		if (collaborateur != null) {
			navigateTo = "/pages/admin/welcome?faces-redirect=true"; loggedIn = true; }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; }
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; }
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public CollaborateurServiceImpl getCollaborateurService() {
		return collaborateurService;
	}
	public void setCollaborateurService(CollaborateurServiceImpl collaborateurService) {
		this.collaborateurService = collaborateurService;
	}
	
	
	
	
}