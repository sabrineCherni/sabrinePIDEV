package tn.esprit.competence.services.impl;

import java.util.ArrayList;  
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.competence.entity.Communication;
import tn.esprit.competence.entity.Competence;
import tn.esprit.competence.services.interfaces.CompetenceServiceRemote;


@Stateless
@LocalBean
public  class CompetenceService  implements CompetenceServiceRemote{

	
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public int ajouterCompetence(Competence competence) {
		em.persist(competence);
		return competence.getId();
	}
	
	@Override
	public Competence getCompetenceByEmailAndPassword(String email, String password) {
		TypedQuery<Competence> query = 
		em.createQuery("select e from Competence e WHERE e.email=:email and e.password=:password ", Competence.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Competence competence = null; 
		try {
			competence = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return competence;
	}

	

	


	
	@Override
	public String getCompetencePrenomById(int competenceId) {
		Competence competence = em.find(Competence.class, competenceId);
		return competence.getNomemploye();
	}


//	@Override
//	public void deleteEmployeById(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
	
	@Override
	public void deleteCompetenceById(int competenceId) {
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		/*for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);*/
		
	 em.remove(em.find(Competence.class, competenceId));
		}
		
	




/*	@Override
	public void mettreAjourEmailByCompetenceId(String email, int competenceId) {
		Competence competence = em.find(Competence.class, competenceId);
		competence.setEmail(email);
	} */


	@Override
	public List<String> getAllCompetenceNamesJPQL() {
		List<Competence> competences = em.createQuery("select e from Competence e", Competence.class).getResultList();
		List<String> competenceNames = new ArrayList<>();
		for(Competence competence : competences){
			competenceNames.add(competence.getNomemploye());
		}
		
		return competenceNames;
	}
	
	@Override
	public void mettreAjourEmailByCompetenceIdJPQL(String email, int competenceId){
		Query query = em.createQuery("update Competence e set email=:email where e.id=:competenceId");
		query.setParameter("email", email);
		query.setParameter("competenceId", competenceId);
		int modified = query.executeUpdate();
		if(modified == 1){
			System.out.println("successfully updated");
		}else{
			System.out.println("failed to update");
		}
	}


	@Override
	public List<Competence> getAllCompetences() {
		List<Competence> emp = em.createQuery("Select e from Competence e", Competence.class).getResultList();
		return emp;
	}
	@Override 
	public void updateCompetence(Competence competence) { 
		Competence emp = em.find(Competence.class, competence.getId());
		emp.setNomemploye(competence.getNomemploye()); 
		emp.setSavoir(competence.getSavoir()); 
		emp.setSavoirfaireop(competence.getSavoirfaireop()); 
		emp.setSavoirfairerel(competence.getSavoirfairerel()); 
		emp.setAptitude(competence.getAptitude()); 
 
}
	
	
	@Override 
	public void updateCompetence2(Competence competence) { 
		Competence  emp = em.createQuery("Select e from Competence e", Competence.class).getSingleResult();
		emp.setNomemploye(competence.getNomemploye()); 
		emp.setSavoir(competence.getSavoir()); 
//		emp.setSavoirfaireop(competence.getSavoirfaireop()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
//		emp.setAptitude(competence.getAptitude()); 

	}
	
	
	@Override 
	public void updateCompetence3(Competence competence) { 
		Competence  emp = em.createQuery("Select e from Competence e", Competence.class).getSingleResult();
		emp.setNomemploye(competence.getNomemploye()); 
		// emp.setSavoir(competence.getSavoir()); 
		emp.setSavoirfaireop(competence.getSavoirfaireop()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
	//	emp.setAptitude(competence.getAptitude()); 

	}
	
	@Override 
	public void updateCompetence4(Competence competence) { 
		Competence  emp = em.createQuery("Select e from Competence e", Competence.class).getSingleResult();
		emp.setNomemploye(competence.getNomemploye()); 
		// emp.setSavoir(competence.getSavoir()); 
	//	emp.setSavoirfaireop(competence.getSavoirfaireop()); 
		emp.setSavoirfairerel(competence.getSavoirfairerel()); 
	//	emp.setAptitude(competence.getAptitude()); 

	}
	
	
	@Override 
	public void updateCompetence5(Competence competence) { 
		Competence  emp = em.createQuery("Select e from Competence e", Competence.class).getSingleResult();
		emp.setNomemploye(competence.getNomemploye()); 
		// emp.setSavoir(competence.getSavoir()); 
	//	emp.setSavoirfaireop(competence.getSavoirfaireop()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
		emp.setAptitude(competence.getAptitude()); 

	}
	
	
	
	
	

	
}
