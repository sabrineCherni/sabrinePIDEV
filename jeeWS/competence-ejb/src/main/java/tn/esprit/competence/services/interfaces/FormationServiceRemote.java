package tn.esprit.competence.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.competence.entity.Employe;
import tn.esprit.competence.entity.Formation;


@Remote
public interface FormationServiceRemote {
	
	
	public int ajouterFormation(Formation formation);
	public void deleteFormationById(int formationId);
	public List<Formation> getAllFormations();
	public void updateFormation(Formation formation);
	public Formation getFormationById(int formationId);
	public Formation updateFormation0(Formation formation);
	

}
