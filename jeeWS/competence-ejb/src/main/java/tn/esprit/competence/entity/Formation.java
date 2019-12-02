package tn.esprit.competence.entity;

import java.io.Serializable; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity 
@Table(name = "T_FORMATION")
public class Formation implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nom_employe")
	private String formationc;
	

	
		

	public Formation() {
	
	}

	

	public Formation( String formationc) {
	

		this.formationc = formationc;

	}



	public Formation(int id, String formationc) {
		
		this.id = id;
		this.formationc = formationc;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getFormationc() {
		return formationc;
	}

	public void setFormationc(String formationc) {
		this.formationc = formationc;
	}
	
	
	
	
	
}
