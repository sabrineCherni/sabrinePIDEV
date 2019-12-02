package tn.esprit.timesheet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
//@Table(name="tache")
public class Tache implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tache_ID",unique=true,columnDefinition="VARCHAR(255)")
	private String id;
	
	private String title;
		
	@Enumerated(EnumType.STRING)
	private Status status;
	@Temporal(TemporalType.TIMESTAMP)
	 @Column(name="valueFrom")
	private Date from;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valueTo")
	private Date to;
	
	@ManyToOne
	private Employe employe;

	public Tache() {
		super();
	}

	public Tache(String title, Status status, Date from, Date to, Employe employe) {
		super();
		this.title = title;
		this.status = status;
		this.from = from;
		this.to = to;
		this.employe = employe;
	}

	public Tache(String id, String title, Status status, Date from, Date to, Employe employe) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.from = from;
		this.to = to;
		this.employe = employe;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
