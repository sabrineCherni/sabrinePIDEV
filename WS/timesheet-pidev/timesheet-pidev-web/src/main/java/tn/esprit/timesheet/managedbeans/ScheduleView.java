package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Status;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.impl.TimesheetService;

@ManagedBean(name = "scheduleView") 
@ViewScoped
public class ScheduleView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;
	private List<Tache> taches;
	private String title;
	private Status status;
	private Date from;
	private Date to;
	private String tacheIdToBeUpdated;
	private ScheduleEvent event = new DefaultScheduleEvent();
	@EJB 
	TimesheetService timesheetService;

    @PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel();
		
		for(Tache tac : this.getTaches(LoginBean.getEmployeSta().getId())){
			ScheduleEvent eve = new DefaultScheduleEvent(tac.getTitle(),new Date(tac.getFrom().getTime() - (1000 * 60 * 60)),new Date(tac.getTo().getTime() - (1000 * 60 * 60)) );
			eve.setId(tac.getId());
			eventModel.addEvent(eve);
			
		}
	}
public void addTache(Employe employe) { 
		
		timesheetService.ajouterTache(new Tache(title,Status.TO_DO,from,to,employe));
		   }
	public void removeTache(String tacheId) { 
		timesheetService.deleteTacheById(tacheId);
		}
	public void displayTache(Tache tache) { 
		this.setTitle(tache.getTitle());
		this.setStatus(tache.getStatus());
		this.setFrom(tache.getFrom());
		this.setTo(tache.getTo());
	 }

	public void updateTache() { 
		timesheetService.updateTache(new Tache(event.getId(),event.getTitle(),Status.TO_DO,event.getStartDate(),event.getEndDate(),LoginBean.getEmployeSta()));
		}
	public List<Tache> getTaches(int employeId) {
		taches = timesheetService.getAllTachesByEmploye(employeId);
		return taches;
	}
	public List<Tache> getTaches() {
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
	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);	//set random day of month
		
		return date.getTime();
	}
	
	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
		
		return calendar.getTime();
	}
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}
	

	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}
	
	private Date previousDay8Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 8);
		
		return t.getTime();
	}
	
	private Date previousDay11Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 11);
		
		return t.getTime();
	}
	
	private Date today1Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 1);
		
		return t.getTime();
	}
	
	private Date theDayAfter3Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);		
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 3);
		
		return t.getTime();
	}

	private Date today6Pm() {
		Calendar t = (Calendar) today().clone(); 
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.HOUR, 6);
		
		return t.getTime();
	}
	
	private Date nextDay9Am() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.AM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, 9);
		
		return t.getTime();
	}
	
	private Date nextDay11Am() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.AM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
		t.set(Calendar.HOUR, 11);
		
		return t.getTime();
	}
	
	private Date fourDaysLater3pm() {
		Calendar t = (Calendar) today().clone(); 
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
		t.set(Calendar.HOUR, 3);
		
		return t.getTime();
	}
	
	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
		timesheetService.updateTache(new Tache(event.getId(),event.getTitle(),Status.TO_DO,event.getStartDate(),event.getEndDate(),LoginBean.getEmployeSta()));
	}
	
	public void addEvent(ActionEvent actionEvent) {
		if(event.getId() == null)
		{eventModel.addEvent(event);
		timesheetService.ajouterTache(new Tache(event.getId(),event.getTitle(),Status.TO_DO,new Date(event.getStartDate().getTime() + (1000 * 60 * 60)),new Date(event.getEndDate().getTime() + (1000 * 60 * 60)),LoginBean.getEmployeSta()));}
		else
			{eventModel.updateEvent(event);
			timesheetService.updateTache(new Tache(event.getId(),event.getTitle(),Status.TO_DO,new Date(event.getStartDate().getTime() + (1000 * 60 * 60)),new Date(event.getEndDate().getTime() + (1000 * 60 * 60)),LoginBean.getEmployeSta())); }
		
		
		event = new DefaultScheduleEvent();
	}
	public void AddEvent() {
		if(event.getId() == null)
		{eventModel.addEvent(event);
		timesheetService.ajouterTache(new Tache(event.getId(),event.getTitle(),Status.TO_DO,new Date(event.getStartDate().getTime() + (1000 * 60 * 60)),new Date(event.getEndDate().getTime() + (1000 * 60 * 60)),LoginBean.getEmployeSta()));}
		else
			{eventModel.updateEvent(event);
			timesheetService.updateTache(new Tache(event.getId(),event.getTitle(),Status.TO_DO,new Date(event.getStartDate().getTime() + (1000 * 60 * 60)),new Date(event.getEndDate().getTime() + (1000 * 60 * 60)),LoginBean.getEmployeSta())); }
		
		event = new DefaultScheduleEvent();
	}
	public void removeEvent() {
		
			eventModel.deleteEvent(event);
			timesheetService.deleteTacheById(event.getId());
		
	}
	
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}
	
	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}
	
	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Task moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		addMessage(message);
	}
	
	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Task resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		
		addMessage(message);
	}
	
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}