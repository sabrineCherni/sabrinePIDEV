package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Role;
import tn.esprit.timesheet.services.impl.EmployeService;

@ManagedBean 
@SessionScoped 
public class LoginBean implements Serializable { 
	private static final long serialVersionUID = 1L; 
	private String login; 
	private String password; 
	private Employe employe; 
	private Boolean loggedIn;
	 private static Employe employeSta;
	@EJB 
	EmployeService employeService; 
	public String doLogin() { 
		String navigateTo = "null"; 
		employe = employeService.getEmployeByEmailAndPassword(login, password); 
		if (employe != null && employe.getRole() == Role.ADMINISTRATEUR) 
		{ navigateTo = "/pages/employes/timesheet?faces-redirect=true"; 
		loggedIn = true; 
		LoginBean.setEmployeSta(employe);
		} 
		else { FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		} 
		return navigateTo; } 
	public String doLogout() { 
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); 
return "/login?faces-redirect=true"; 
}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public static Employe getEmployeSta() {
		return employeSta;
	}
	public static void setEmployeSta(Employe employeSta) {
		LoginBean.employeSta = employeSta;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public EmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	
	
}