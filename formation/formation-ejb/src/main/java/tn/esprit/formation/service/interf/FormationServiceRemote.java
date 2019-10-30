package tn.esprit.formation.service.interf;

import java.util.List;
import tn.esprit.formation.entity.Formation;


public interface FormationServiceRemote {
	
	public int addFormation(Formation formation);
	public void removeFormation(int id);
	public void updateFormation(Formation formation);
	//public Collaborateur getCollaborateurByEmailAndPassword(String mail, String password);
	public List<Formation> getAllFormations();
	void updateFormationAfterParticipation(Formation formation);

}
