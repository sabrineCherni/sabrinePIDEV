package tn.esprit.competence.entity;

import java.io.Serializable; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity 
@Table(name = "T_COMMUNICATION")
public class Communication implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nom_employe")
	private String nomemploye;
	
	private String linguistique ;
	
	@Column(name="socio_linguistique")
	private String sociolinguistique ;
	
	@Column(name="socio_culturelle")
	private String socioculturelle ;
	
	//@Column(name="strategique")
	private String strategique;
	

	
	
	



	public Communication() {
	
	}

	





	



	public Communication(String nomemploye, String linguistique, String sociolinguistique, String socioculturelle,
			String strategique) {
		this.nomemploye = nomemploye;
		this.linguistique = linguistique;
		this.sociolinguistique = sociolinguistique;
		this.socioculturelle = socioculturelle;
		this.strategique = strategique;
	}











	public Communication(int id, String nomemploye, String linguistique, String sociolinguistique,
			String socioculturelle, String strategique) {
		this.id = id;
		this.nomemploye = nomemploye;
		this.linguistique = linguistique;
		this.sociolinguistique = sociolinguistique;
		this.socioculturelle = socioculturelle;
		this.strategique = strategique;
	}



	public Communication( String nomemploye, String linguistique) {
		
		this.nomemploye = nomemploye;
		this.linguistique = linguistique;
	}


	
	public Communication( String nomemploye, String linguistique, String sociolinguistique) {
		this.nomemploye = nomemploye;
		this.linguistique = linguistique;
		this.sociolinguistique = sociolinguistique;
	}



	public Communication(String nomemploye, String linguistique, String sociolinguistique,
			String socioculturelle) {
		this.nomemploye = nomemploye;
		this.linguistique = linguistique;
		this.sociolinguistique = sociolinguistique;
		this.socioculturelle = socioculturelle;

	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	

	public String getLinguistique() {
		return linguistique;
	}











	public void setLinguistique(String linguistique) {
		this.linguistique = linguistique;
	}











	public String getSociolinguistique() {
		return sociolinguistique;
	}











	public void setSociolinguistique(String sociolinguistique) {
		this.sociolinguistique = sociolinguistique;
	}











	public String getSocioculturelle() {
		return socioculturelle;
	}











	public void setSocioculturelle(String socioculturelle) {
		this.socioculturelle = socioculturelle;
	}











	public String getStrategique() {
		return strategique;
	}











	public void setStrategique(String strategique) {
		this.strategique = strategique;
	}











	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}



	public String getNomemploye() {
		return nomemploye;
	}

	public void setNomemploye(String nomemploye) {
		this.nomemploye = nomemploye;
	}
	
	
	
	
	
}
