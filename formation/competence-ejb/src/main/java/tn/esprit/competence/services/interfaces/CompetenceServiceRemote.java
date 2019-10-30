package tn.esprit.competence.services.interfaces;

import java.util.List; 

import javax.ejb.Remote;

import tn.esprit.competence.entity.Competence;

@Remote
public interface CompetenceServiceRemote {
	
	public int ajouterCompetence(Competence competence);
//	public void mettreAjourEmailByCompetenceId(String email, int competenceId);
	public String getCompetencePrenomById(int competenceId);
	public void deleteCompetenceById(int competenceId);
	public List<String> getAllCompetenceNamesJPQL();
	public void mettreAjourEmailByCompetenceIdJPQL(String email, int competenceId);
	public Competence getCompetenceByEmailAndPassword(String login, String password); 
	public List<Competence> getAllCompetences();
	public void updateCompetence(Competence competence);
	public void updateCompetence2(Competence competence);

}
