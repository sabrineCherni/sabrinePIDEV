package tn.esprit.timesheet.services.interfaces;



import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entity.Employe;



@Remote
public interface EmployeServiceRemote {
	
	public int ajouterEmploye(Employe employe);
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	public float getSalaireByEmployeIdJPQL(int employeId);
	public Employe getEmployeByEmailAndPassword(String login, String password); 
	public List<Employe> getAllEmployes();
	public void updateEmploye(Employe employe);
	Employe updateEmploye2(Employe employe);
	Employe getEmployeById(int employeId);
	void deleteEmployeById(int employeId);
}
