package tn.esprit.timesheet.services.impl;

import java.util.ArrayList;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.interfaces.EmployeServiceRemote;

@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote {

	@PersistenceContext(unitName = "timesheet-ejb")
	EntityManager em;

	@Override
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}
	
	@Override
	public Employe getEmployeByEmailAndPassword(String email, String password) {
		TypedQuery<Employe> query = 
		em.createQuery("select e from Employe e WHERE e.email=:email and e.password=:password ", Employe.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Employe employe = null; 
		try {
			employe = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employe;
	}


	
	
	
	

	
	
	
	@Override
	public String getEmployePrenomById(int employeId) {
		Employe employe = em.find(Employe.class, employeId);
		return employe.getPrenom();
	}
	@Override
	public Employe getEmployeById(int employeId) {
		Employe employe = em.find(Employe.class, employeId);
		return employe;
	}


//	@Override
//	public void deleteEmployeById(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
	
	@Override
	public void deleteEmployeById(int employeId){
		em.remove(em.find(Employe.class,employeId));
	}

	

	


	@Override
	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Employe employe = em.find(Employe.class, employeId);
		employe.setEmail(email);
	}


	@Override
	public long getNombreEmployeJPQL() {
		TypedQuery<Long> query = em.createQuery("select count(e) from Employe e", Long.class);
		return query.getSingleResult();
	}


	@Override
	public List<String> getAllEmployeNamesJPQL() {
		List<Employe> employes = em.createQuery("select e from Employe e", Employe.class).getResultList();
		List<String> employeNames = new ArrayList<>();
		for(Employe employe : employes){
			employeNames.add(employe.getNom());
		}
		
		return employeNames;
	}
	
	@Override
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId){
		Query query = em.createQuery("update Employe e set email=:email where e.id=:employeId");
		query.setParameter("email", email);
		query.setParameter("employeId", employeId);
		int modified = query.executeUpdate();
		if(modified == 1){
			System.out.println("successfully updated");
		}else{
			System.out.println("failed to update");
		}
	}


	


	@Override
	public float getSalaireByEmployeIdJPQL(int employeId) {
	  TypedQuery<Float> query = em.createQuery(
	  "select c.salaire from Contrat c join c.employe e where e.id=:employeId", 
	  Float.class);
	  query.setParameter("employeId", employeId);
	  return query.getSingleResult();
	}

    

    
	
	


	@Override
	public List<Employe> getAllEmployes() {
		List<Employe> emp = em.createQuery("Select e from Employe e", Employe.class).getResultList();
		return emp;
	}

	
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
//	for(Timesheet timesheet : timesheets){
//		System.out.println("DateDebut : "+ 
//					dateFormat.format((timesheet.getTimesheetPK().getDateDebut())));
//		System.out.println("DateFin : "+ 
//				dateFormat.format((timesheet.getTimesheetPK().getDateFin())));
//		System.out.println("Mission ID : " + timesheet.getMission().getId());
//		System.out.println("Employe ID : " + timesheet.getEmploye().getId());
//	}
	
	@Override 
	public void updateEmploye(Employe employe) { 
		Employe emp = em.find(Employe.class, employe.getId());
		emp.setPrenom(employe.getPrenom()); 
		emp.setNom(employe.getNom()); 
		emp.setEmail(employe.getEmail()); 
		emp.setPassword(employe.getPassword());
	emp.setisActif(employe.getisActif()); 
	emp.setRole(employe.getRole()); }
	@Override 
	public Employe updateEmploye2(Employe employe) { 
		Employe emp = em.find(Employe.class, employe.getId());
		emp.setPrenom(employe.getPrenom()); 
		emp.setNom(employe.getNom()); 
		emp.setEmail(employe.getEmail()); 
		emp.setPassword(employe.getPassword());
	emp.setisActif(employe.getisActif()); 
	emp.setRole(employe.getRole());
	return employe;}
}