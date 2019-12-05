	package tn.esprit.timesheet.services.impl;


import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Projets;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.interfaces.TimesheetServiceRemote;

@Stateless
@LocalBean
public class TimesheetService implements TimesheetServiceRemote{
	
	@PersistenceContext(unitName = "timesheet-ejb")
	EntityManager entityManager;


	@Override
	public String ajouterTache(Tache tac) {
		if (!tac.getId().equals(null)) {
			tac = entityManager.merge(tac);
	    }
		entityManager.persist(tac);
		return tac.getId();
	}
	
	@Override
	public void affecterTacheAEmploye(String tacId, int employeId) {
		//Le bout Master de cette relation N:1 est Tache  
		//donc il faut rajouter l'employe a Tache 
		// ==> c'est l'objet Tache(le master) qui va mettre a jour l'association
		//Rappel : la classe qui contient mappedBy represente le bout Slave
		//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		Employe empManagedEntity = entityManager.find(Employe.class, employeId);
		Tache tacManagedEntity = entityManager.find(Tache.class, tacId);

		tacManagedEntity.setEmploye(empManagedEntity);
		//inutile de faire : em.merge(tacManagedEntity);
		//Dans ce cas, le merge n'est pas utile parce que tacManagedEntity est 
		//dans l'état managed, autrement dit, 
		//depManagedEntity existe dans le persistence context.
		//n'importe quel entité dans le persistence context sera automatiquement
		//synchronisé avec la base de donnees
	}
	@Override
	public Tache affecterTacheAProjet(String tacId, int projetId) {
		//Le bout Master de cette relation N:1 est Tache  
		//donc il faut rajouter l'employe a Tache 
		// ==> c'est l'objet Tache(le master) qui va mettre a jour l'association
		//Rappel : la classe qui contient mappedBy represente le bout Slave
		//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		Projets empManagedEntity = entityManager.find(Projets.class, projetId);
		Tache tacManagedEntity = entityManager.find(Tache.class, tacId);

		tacManagedEntity.setProjets(empManagedEntity);
		//inutile de faire : em.merge(tacManagedEntity);
		//Dans ce cas, le merge n'est pas utile parce que tacManagedEntity est 
		//dans l'état managed, autrement dit, 
		//depManagedEntity existe dans le persistence context.
		//n'importe quel entité dans le persistence context sera automatiquement
		//synchronisé avec la base de donnees
		return tacManagedEntity;
	}
	
//	@Override
//	public void affecterTacheAEmploye(int tacId, int employeId) {
//		Employe empManagedEntity = entityManager.find(Employe.class, employeId);
//	Tache tacManagedEntity = entityManager.find(Tache.class, tacId);
//
//		empManagedEntity.getTaches().add(tacManagedEntity);
//		//ceci ne met pas a jour la relation !
//	}
	
	@Override
	public List<String> getAllTachesTitleByEmploye(int employeId) {
		Employe empManagedEntity = entityManager.find(Employe.class,employeId);
		List<String> tacNames = new ArrayList<>();
		for(Tache tac : empManagedEntity.getTaches()){
			tacNames.add(tac.getTitle());
		}
		
		return tacNames;
	}
	
	@Override
	public List<Tache> getAllTachesByEmploye(int employeId) {
		Employe empManagedEntity = entityManager.find(Employe.class,employeId);
		List<Tache> taches = new ArrayList<>();
		for(Tache tac : empManagedEntity.getTaches()){
			taches.add(tac);
		}
		
		return taches;
	}
	@Override
	public Tache getTacheById(String id) {
		Tache taches = entityManager.find(Tache.class, id);
		return taches;
	}
	@Override
	public List<Tache> getAllTachesByEmployeToday(int employeId) {
		Employe empManagedEntity = entityManager.find(Employe.class,employeId);
		List<Tache> taches = new ArrayList<>();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		try {
			Date todayWithZeroTime = formatter.parse(formatter.format(today));
			for(Tache tac : empManagedEntity.getTaches()){
				
				if(todayWithZeroTime.compareTo(formatter.parse(formatter.format(tac.getFrom())))==0)
				{taches.add(tac);}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return taches;
	}
	
	@Override
	public List<Tache> getAllTaches() {
		List<Tache> taches = entityManager.createQuery("Select e from Tache e", Tache.class).getResultList();
		return taches;
	}
	@Override
	public void deleteTacheById(String tacId){
		entityManager.remove(entityManager.find(Tache.class,tacId));
	}

	@Override
	public void updateTache(Tache tache) {
		
		Tache tac = entityManager.find(Tache.class, tache.getId());
		tac.setTitle(tache.getTitle());
		tac.setStatus(tache.getStatus());
		tac.setFrom(tache.getFrom());
		tac.setTo(tache.getTo());
	}
	@Override
	public long getHoursByEmploye(int employeId,Date today) {
		Employe empManagedEntity = entityManager.find(Employe.class,employeId);
		long som=0;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		

		try {
			Date todayWithZeroTime = formatter.parse(formatter.format(today));
			for(Tache tac : empManagedEntity.getTaches()){
				
				if(todayWithZeroTime.compareTo(formatter.parse(formatter.format(tac.getFrom())))==0)
				{ som=som+(tac.getTo().getTime()-tac.getFrom().getTime());}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return som;
	}
	@Override
	public int getdayByEmploye(int employeId,Date today) {
		Employe empManagedEntity = entityManager.find(Employe.class,employeId);
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		

		try {
			Date todayWithZeroTime = formatter.parse(formatter.format(today));
			for(Tache tac : empManagedEntity.getTaches()){
				
				if(todayWithZeroTime.compareTo(formatter.parse(formatter.format(tac.getFrom())))==0)
				{return 1;}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	@Override
	public Tache updateTache2(Tache tache) {
		Tache tac = entityManager.find(Tache.class, tache.getId());
		tac.setTitle(tache.getTitle());
		tac.setStatus(tache.getStatus());
		tac.setFrom(tache.getFrom());
		tac.setTo(tache.getTo());
		return tac;
	}

}
