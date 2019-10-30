package tn.esprit.competence.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.competence.entity.Quiz;
import tn.esprit.competence.services.interfaces.QuizServiceRemote;


@Stateless
@LocalBean
public class QuizService implements QuizServiceRemote {
	
    
	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public int ajouterQuiz(Quiz quiz) {
		em.persist(quiz);
		return quiz.getId();
	}
	

	

	


	
	


//	@Override
//	public void deleteEmployeById(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
	
	@Override
	public void deleteQuizById(int quizId) {
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		/*for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);*/
		
	 em.remove(em.find(Quiz.class, quizId));
		}
		
	




/*	@Override
	public void mettreAjourEmailByCompetenceId(String email, int competenceId) {
		Competence competence = em.find(Competence.class, competenceId);
		competence.setEmail(email);
	} */



	



	@Override
	public List<Quiz> getAllQuizs() {
		List<Quiz> emp = em.createQuery("Select e from Quiz e", Quiz.class).getResultList();
		return emp;
	}
	
	
	@Override 
	public void updateQuiz(Quiz quiz) { 
		Quiz emp = em.find(Quiz.class, quiz.getId());
		emp.setQuestion(quiz.getQuestion()); 
		emp.setReponse(quiz.getReponse()); 

}


}
