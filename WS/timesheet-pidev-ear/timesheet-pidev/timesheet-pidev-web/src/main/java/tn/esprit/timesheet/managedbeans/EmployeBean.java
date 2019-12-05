package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Role;
import tn.esprit.timesheet.services.impl.EmployeService;

@ManagedBean(name = "employeBean") 
@SessionScoped 
public class EmployeBean implements Serializable {
private static final long serialVersionUID = 1L; 

private List<Employe> employes;
private String prenom;  
private String nom; 
private String password; 
private String email; 
private Boolean isActif;  
private Role role; 
private Integer employeIdToBeUpdated; 

@EJB 
EmployeService employeService; 
public void addEmploye() { 
	
   employeService.ajouterEmploye(new Employe(nom, prenom, email, password, isActif, role)); 
   }
public void removeEmploye(int employeId) { 
	//employeService.deleteEmployeById(employeId); 
	}
public void displayEmploye(Employe empl) { 
	this.setPrenom(empl.getPrenom()); 
this.setNom(empl.getNom()); 
this.setIsActif(empl.getisActif()); 
this.setEmail(empl.getEmail()); 
this.setRole(empl.getRole()); 
this.setEmail(empl.getEmail());
this.setPassword(empl.getPassword());
this.setemployeIdToBeUpdated(empl.getId()); }

public Integer getemployeIdToBeUpdated() {
	return employeIdToBeUpdated;
}
public void setemployeIdToBeUpdated(Integer employeIdToBeUpdated) {
	this.employeIdToBeUpdated = employeIdToBeUpdated;
}
public void updateEmploye() { 
	employeService.updateEmploye(new Employe(employeIdToBeUpdated, nom, prenom, email, password, isActif, role)); } 
public List<Employe> getEmployes() {
	employes = employeService.getAllEmployes(); 
	return employes;
}

public void setEmployes(List<Employe> employes) {
	this.employes = employes;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Boolean getIsActif() {
	return isActif;
}
public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public EmployeService getEmployeService() {
	return employeService;
}
public void setEmployeService(EmployeService employeService) {
	this.employeService = employeService;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}



}
