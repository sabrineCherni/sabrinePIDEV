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
import tn.esprit.competence.services.interfaces.CommunicationServiceRemote;


@Stateless
@LocalBean
public  class CommunicationService  implements CommunicationServiceRemote{

	
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public int ajouterCommunication(Communication communication) {
		em.persist(communication);
		return communication.getId();
	}
	/*
	@Override
	public Communication getCommunicationByEmailAndPassword(String email, String password) {
		TypedQuery<Communication> query = 
		em.createQuery("select e from Communication e WHERE e.email=:email and e.password=:password ", Communication.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Communication communication = null; 
		try {
			communication = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return communication;
	}
*/
	

	

/*
	
	@Override
	public String getCommunicationPrenomById(int communicationId) {
		Communication communication = em.find(Communication.class, communicationId);
		return communication.getNomemploye();
	}
*/

//	@Override
//	public void deleteEmployeById(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
	
	@Override
	public void deleteCommunicationById(int communicationId) {
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		/*for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);*/
		
	 em.remove(em.find(Communication.class, communicationId));
		}
		
	




/*	@Override
	public void mettreAjourEmailByCompetenceId(String email, int competenceId) {
		Competence competence = em.find(Competence.class, competenceId);
		competence.setEmail(email);
	} */


	/*@Override
	public List<String> getAllCommunicationNamesJPQL() {
		List<Communication> communications = em.createQuery("select e from Communication e", Communication.class).getResultList();
		List<String> communicationNames = new ArrayList<>();
		for(Communication communication : communications){
			communicationNames.add(communication.getNomemploye());
		}
		
		return communicationNames;
	}*/
	
	/*@Override
	public void mettreAjourEmailByCommunicationIdJPQL(String email, int communicationId){
		Query query = em.createQuery("update Communication e set email=:email where e.id=:communicationId");
		query.setParameter("email", email);
		query.setParameter("communicationId", communicationId);
		int modified = query.executeUpdate();
		if(modified == 1){
			System.out.println("successfully updated");
		}else{
			System.out.println("failed to update");
		}
	}*/


	@Override
	public List<Communication> getAllCommunications() {
		List<Communication> emp = em.createQuery("Select e from Communication e", Communication.class).getResultList();
		return emp;
	}
	@Override 
	public void updateCommunication(Communication communication) { 
		Communication emp = em.find(Communication.class, communication.getId());
		emp.setNomemploye(communication.getNomemploye()); 
		emp.setLinguistique(communication.getLinguistique()); 
		emp.setSociolinguistique(communication.getSociolinguistique()); 
		emp.setSocioculturelle(communication.getSocioculturelle()); 
		emp.setStrategique(communication.getStrategique()); 
 
}
	
	
	@Override 
	public void updateCommunication2(Communication communication) { 
		Communication  emp = em.createQuery("Select e from Communication e", Communication.class).getSingleResult();
		emp.setNomemploye(communication.getNomemploye()); 
		emp.setLinguistique(communication.getLinguistique()); 
		emp.setSociolinguistique(communication.getSociolinguistique()); 
		emp.setSocioculturelle(communication.getSocioculturelle()); 
		emp.setStrategique(communication.getStrategique()); 

		
 
}

	@Override 
	public void updateCommunication6(Communication communication) { 
		Communication  emp = em.createQuery("Select e from Communication e", Communication.class).getSingleResult();
		emp.setNomemploye(communication.getNomemploye()); 
	    emp.setLinguistique(communication.getLinguistique()); 
	//	emp.setSavoirfaireop(competence.getSavoirfaireop()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
	//	emp.setAptitude(communication.getAptitude()); 

	}
	
	@Override 
	public void updateCommunication7(Communication communication) { 
		Communication  emp = em.createQuery("Select e from Communication e", Communication.class).getSingleResult();
		emp.setNomemploye(communication.getNomemploye()); 
	//   emp.setLinguistique(communication.getLinguistique()); 
		emp.setSociolinguistique(communication.getSociolinguistique()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
	//	emp.setAptitude(communication.getAptitude()); 

	}
	
	@Override 
	public void updateCommunication8(Communication communication) { 
		Communication  emp = em.createQuery("Select e from Communication e", Communication.class).getSingleResult();
		emp.setNomemploye(communication.getNomemploye()); 
	//   emp.setLinguistique(communication.getLinguistique()); 
		emp.setSocioculturelle(communication.getSocioculturelle()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
	//	emp.setAptitude(communication.getAptitude()); 

	}
	@Override 
	public void updateCommunication9(Communication communication) { 
		Communication  emp = em.createQuery("Select e from Communication e", Communication.class).getSingleResult();
		emp.setNomemploye(communication.getNomemploye()); 
	//   emp.setLinguistique(communication.getLinguistique()); 
		emp.setStrategique(communication.getStrategique()); 
	//	emp.setSavoirfairerel(competence.getSavoirfairerel()); 
	//	emp.setAptitude(communication.getAptitude()); 

	}
	
}
