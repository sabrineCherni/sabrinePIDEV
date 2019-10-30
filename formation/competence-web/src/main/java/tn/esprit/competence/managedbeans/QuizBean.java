package tn.esprit.competence.managedbeans;

import java.io.Serializable; 
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

import tn.esprit.competence.entity.Quiz;
import tn.esprit.competence.entity.Role;
import tn.esprit.competence.services.impl.QuizService;


@ManagedBean(name = "quizBean") 
@SessionScoped 
public class QuizBean implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	private List<Quiz> quizs;
    private String question;
	private String reponse ; 
    private Integer quizIdToBeUpdated; 

	@EJB 
	QuizService quizService; 
	public void addQuiz() { 
		
	   quizService.ajouterQuiz(new  Quiz( question , reponse  ) ); 
	   }
	public void removeQuiz(int quizId) { 
		quizService.deleteQuizById(quizId); }
	public void displayQuiz(Quiz empl) { 
    this.setQuestion(empl.getQuestion());  
	this.setReponse(empl.getReponse()); 
	this.setQuizIdToBeUpdated(empl.getId()); }

	
	public void updateQuiz() { 
		quizService.updateQuiz(new Quiz(  quizIdToBeUpdated,  question, reponse));
		} 
	public List<Quiz> getQuizs() {
		quizs = quizService.getAllQuizs(); 
		return quizs;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public Integer getQuizIdToBeUpdated() {
		return quizIdToBeUpdated;
	}
	public void setQuizIdToBeUpdated(Integer quizIdToBeUpdated) {
		this.quizIdToBeUpdated = quizIdToBeUpdated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	



}
