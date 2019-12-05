package tn.esprit.timesheet.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Projets implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Projet_ID;
	
	private String title_projet;
		
	@Enumerated(EnumType.STRING)
	private Status status_projet;
	@Temporal(TemporalType.TIMESTAMP)
	 @Column(name="projet_From")
	private Date projet_from;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="projet_To")
	private Date projet_to;
	
	@Transient
	@OneToMany(mappedBy="projets")
	private List<Tache> taches;

	public Projets(int id, String title_projet, Status status_projet, Date projet_from, Date projet_to) {
		super();
		this.Projet_ID = id;
		this.title_projet = title_projet;
		this.status_projet = status_projet;
		this.projet_from = projet_from;
		this.projet_to = projet_to;
	}

	public Projets() {
		super();
	}

	public int getId() {
		return Projet_ID;
	}

	public void setId(int id) {
		this.Projet_ID = id;
	}

	public String getTitle_projet() {
		return title_projet;
	}

	public void setTitle_projet(String title_projet) {
		this.title_projet = title_projet;
	}

	public Status getStatus_projet() {
		return status_projet;
	}

	public void setStatus_projet(Status status_projet) {
		this.status_projet = status_projet;
	}

	public Date getProjet_from() {
		return projet_from;
	}

	public void setProjet_from(Date projet_from) {
		this.projet_from = projet_from;
	}

	public Date getProjet_to() {
		return projet_to;
	}

	public void setProjet_to(Date projet_to) {
		this.projet_to = projet_to;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
