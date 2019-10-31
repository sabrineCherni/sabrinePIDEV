package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Status;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.impl.TimesheetService;
@ManagedBean(name = "managertimeBean") 
@SessionScoped 
public class ManagertimeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tache> taches;
	private List<Tache> filteredTaches;
	private String title;
	private Status status;
	private Date from;
	private Date to;
	private String tacheIdToBeUpdated;
	private Employe employe;
	

	@EJB 
	TimesheetService timesheetService;
	
	public void removeTache(String tacheId) { 
		timesheetService.deleteTacheById(tacheId);
		}
	public void displayTache(Tache tache) { 
		this.setTitle(tache.getTitle());
		this.setStatus(tache.getStatus());
		this.setFrom(tache.getFrom());
		this.setTo(tache.getTo());
		this.setTacheIdToBeUpdated(tache.getId());
		this.setEmploye(tache.getEmploye());
	 }

	public void updateTache() { 
		timesheetService.updateTache(new Tache(tacheIdToBeUpdated,title,status,from,to,employe)); 
		}
	public void updateTacheAll() { 
		}
	public List<Tache> getTaches(int employeId) {
		taches = timesheetService.getAllTachesByEmployeToday(employeId);
		return taches;
	}
	public List<Tache> getTaches() {
		taches = timesheetService.getAllTaches();
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public String getTacheIdToBeUpdated() {
		return tacheIdToBeUpdated;
	}
	public void setTacheIdToBeUpdated(String tacheIdToBeUpdated) {
		this.tacheIdToBeUpdated = tacheIdToBeUpdated;
	}
	
	public List<Tache> getFilteredTaches() {
		return filteredTaches;
	}
	public void setFilteredTaches(List<Tache> filteredTaches) {
		this.filteredTaches = filteredTaches;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	  
	
}
