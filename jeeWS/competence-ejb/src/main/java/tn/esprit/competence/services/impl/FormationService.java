package tn.esprit.competence.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.competence.entity.Employe;
import tn.esprit.competence.entity.Formation;
import tn.esprit.competence.services.interfaces.FormationServiceRemote;


@Stateless
@LocalBean
public class FormationService implements FormationServiceRemote {
	
    
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public int ajouterFormation(Formation formation) {
		em.persist(formation);
		return formation.getId();
	}
	

	

	


	
	


//	@Override
//	public void deleteEmployeById(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
	
	@Override
	public void deleteFormationById(int formationId) {
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		/*for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);*/
		
	 em.remove(em.find(Formation.class, formationId));
		}
		
	




/*	@Override
	public void mettreAjourEmailByCompetenceId(String email, int competenceId) {
		Competence competence = em.find(Competence.class, competenceId);
		competence.setEmail(email);
	} */



	



	@Override
	public List<Formation> getAllFormations() {
		List<Formation> emp = em.createQuery("Select e from Formation e", Formation.class).getResultList();
		return emp;
	}
	
	
	@Override 
	public void updateFormation(Formation formation) { 
		Formation emp = em.find(Formation.class, formation.getId());
		emp.setFormationc(formation.getFormationc()); 

}

	@Override
	public Formation getFormationById(int formationId) {
		Formation formation = em.find(Formation.class, formationId);
		return formation;
	}
	
	@Override 
	public Formation updateFormation0(Formation formation) { 
		Formation emp = em.find(Formation.class, formation.getId());
		emp.setFormationc(formation.getFormationc()); 
		return formation;}
	

}
