package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.timesheet.entity.Status;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.impl.TimesheetService;

@ManagedBean(name = "tacheBean") 
@SessionScoped 
public class TacheBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tache> taches;
	private String title;
	private Status status;
	private Date from;
	private Date to;
	private String tacheIdToBeUpdated;
	private static Date fromcopy;
	private static Date tocopy;
	

	@EJB 
	TimesheetService timesheetService;
	
public void addTache() { 
		
		timesheetService.ajouterTache(new Tache("aaaa",title,Status.TO_DO,from,to,LoginBean.getEmployeSta()));
		   }
	public void removeTache(String tacheId) { 
		timesheetService.deleteTacheById(tacheId);
		}
	public void displayTache(Tache tache) { 
		this.setTitle(tache.getTitle());
		this.setStatus(tache.getStatus());
		this.setFrom(tache.getFrom());
		this.setTo(tache.getTo());
		this.setTacheIdToBeUpdated(tache.getId());
	 }

	public void updateTache() { 
		timesheetService.updateTache(new Tache(tacheIdToBeUpdated,title,Status.TO_DO,from,to,LoginBean.getEmployeSta())); 
		}
	public void updateTacheday() { 
		}
	public List<Tache> getTaches(int employeId) {
		taches = timesheetService.getAllTachesByEmployeToday(employeId);
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
	public TimesheetService getTimesheetService() {
		return timesheetService;
	}
	public void setTimesheetService(TimesheetService timesheetService) {
		this.timesheetService = timesheetService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public static void setFromcopy(Date fromcopy) {
		TacheBean.fromcopy = fromcopy;
	}
	public static Date getTocopy() {
		return tocopy;
	}
	public static void setTocopy(Date tocopy) {
		TacheBean.tocopy = tocopy;
	}
	

}
