package tn.esprit.timesheet.services.interfaces;



import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entity.Tache;

@Remote
public interface TimesheetServiceRemote {

	String ajouterTache(Tache tac);
	void affecterTacheAEmploye(String tacId, int employeId);
	List<String> getAllTachesTitleByEmploye(int employeId);
	void deleteTacheById(String tacId);
	void updateTache(Tache tache);
	List<Tache> getAllTachesByEmploye(int employeId);
	List<Tache> getAllTaches();
	List<Tache> getAllTachesByEmployeToday(int employeId);
	long getHoursByEmploye(int employeId, Date today);
	int getdayByEmploye(int employeId, Date today);
	
	Tache getTacheById(String id);
	Tache affecterTacheAProjet(String tacId, int projetId);
	Tache updateTache2(Tache tache);

}
