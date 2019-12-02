package tn.esprit.competence.managedbeans;

import java.io.Serializable; 
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.xml.registry.infomodel.User;

import tn.esprit.competence.entity.Competence;
import tn.esprit.competence.entity.Role;
import tn.esprit.competence.services.impl.CompetenceService;


@ManagedBean(name = "competenceBean") 
@SessionScoped 
public class CompetenceBean implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	private  List<Competence> competences;
    private  String nomemploye;
	private  String savoir ;
	private  String savoirfaireop ;
	private  String savoirfairerel ;
	private  String aptitude; 
    private  Integer competenceIdToBeUpdated; 
    
	
	
    
    @EJB
	CompetenceService  competenceService; 
	public void addCompetence() { 
		
	   competenceService.ajouterCompetence(new  Competence( nomemploye,  savoir, savoirfaireop ,savoirfairerel,aptitude) ); 
	   }
	public void removeCompetence(int competenceId) { 
		competenceService.deleteCompetenceById(competenceId); }
	public void displayCompetence(Competence empl) { 
    this.setNomemploye(empl.getNomemploye());  
	this.setSavoir(empl.getSavoir()); 
	this.setSavoirfaireop(empl.getSavoirfaireop()); 
	this.setSavoirfairerel(empl.getSavoirfairerel()); 
	this.setAptitude(empl.getAptitude());
	this.setcompetenceIdToBeUpdated(empl.getId()); }

	
	public void updateCompetence() { 
		competenceService.updateCompetence(new Competence(  competenceIdToBeUpdated,  nomemploye, savoir));
		} 

	public  void updateCompetence2() { 
		competenceService.updateCompetence2(new Competence("", "bien"));
		} 
	public  void updateCompetence3() { 
		competenceService.updateCompetence2(new Competence("", "moyen"));
		} 
	public  void updateCompetence4() { 
		competenceService.updateCompetence2(new Competence("", "faible"));
		} 
	
	
	public  void updateCompetence6() { 
		competenceService.updateCompetence3(new Competence("","", "bien"));
		} 
	public  void updateCompetence7() { 
		competenceService.updateCompetence3(new Competence("","", "moyen"));
		} 
	public  void updateCompetence8() { 
		competenceService.updateCompetence3(new Competence("","", "faible"));
		} 
	
	public  void updateCompetence9() { 
		competenceService.updateCompetence4(new Competence("","","", "bien"));
		} 
	public  void updateCompetence10() { 
		competenceService.updateCompetence4(new Competence("","","", "moyen"));
		} 
	public  void updateCompetence11() { 
		competenceService.updateCompetence4(new Competence("","","", "faible"));
		} 
	public  void updateCompetence12() { 
		competenceService.updateCompetence5(new Competence("","","","", "bien"));
		} 
	public  void updateCompetence13() { 
		competenceService.updateCompetence5(new Competence("","","","", "moyen"));
		} 
	public  void updateCompetence14() { 
		competenceService.updateCompetence5(new Competence("","","","", "faible"));
		} 

	
	
	
	public void updateTest2() {
		
		if(UserBean.result<2) {updateCompetence4();}
		else if (UserBean.result==2) {updateCompetence3();}
		else if(UserBean.result>2) {updateCompetence2();}
	
		
		}
	
	public void updateTest3() {
		
		if(UseroBean.result<2) {updateCompetence8();}
		else if (UseroBean.result==2) {updateCompetence7();}
		else if(UseroBean.result>2) {updateCompetence6();}
	
		
		}
	public void updateTest4() {
		
		if(UserrBean.result<2) {updateCompetence11();}
		else if (UserrBean.result==2) {updateCompetence10();}
		else if(UserrBean.result>2) {updateCompetence9();}
	
		
		}
	public void updateTest5() {
		
		if(UseraBean.result<2) {updateCompetence14();}
		else if (UseraBean.result==2) {updateCompetence13();}
		else if(UseraBean.result>2) {updateCompetence12();}
	
		
		}
	

	
	
	
	
	public List<Competence> getCompetences() {
		competences = competenceService.getAllCompetences(); 
		return competences;
	}
	
	public Integer getcompetenceIdToBeUpdated() {
		return competenceIdToBeUpdated;
	}
	public void setcompetenceIdToBeUpdated(Integer  competenceIdToBeUpdated) {
		this.competenceIdToBeUpdated = competenceIdToBeUpdated;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public String getNomemploye() {
		return nomemploye;
	}
	public void setNomemploye(String nomemploye) {
		this.nomemploye = nomemploye;
	}
	public String getSavoir() {
		return savoir;
	}
	public void setSavoir(String savoir) {
		this.savoir = savoir;
	}
	public String getSavoirfaireop() {
		return savoirfaireop;
	}
	public void setSavoirfaireop(String savoirfaireop) {
		this.savoirfaireop = savoirfaireop;
	}
	public String getSavoirfairerel() {
		return savoirfairerel;
	}
	public void setSavoirfairerel(String savoirfairerel) {
		this.savoirfairerel = savoirfairerel;
	}
	public String getAptitude() {
		return aptitude;
	}
	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}
	public CompetenceService getCompetenceService() {
		return competenceService;
	}
	public void setCompetenceService(CompetenceService competenceService) {
		this.competenceService = competenceService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCompetenceIdToBeUpdated() {
		return competenceIdToBeUpdated;
	}
	public void setCompetenceIdToBeUpdated(Integer competenceIdToBeUpdated) {
		this.competenceIdToBeUpdated = competenceIdToBeUpdated;
	}



}
