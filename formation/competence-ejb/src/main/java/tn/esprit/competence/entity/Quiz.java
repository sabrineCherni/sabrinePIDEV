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
@Table(name = "T_QUIZ")
public class Quiz implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	private String question;
	
	private String reponse ;
	
	

	public Quiz(String question, String reponse) {
		this.question = question;
		this.reponse = reponse;
	}

	public Quiz() {
		
	}

	public Quiz(int id, String question, String reponse) {
		this.id = id;
		this.question = question;
		this.reponse = reponse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
