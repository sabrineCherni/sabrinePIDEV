package tn.esprit.competence.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.competence.entity.Quiz;

@Remote
public interface QuizServiceRemote {
	
	
	public int ajouterQuiz(Quiz quiz);
	public void deleteQuizById(int quizId);
	public List<Quiz> getAllQuizs();
	public void updateQuiz(Quiz quiz);


}
