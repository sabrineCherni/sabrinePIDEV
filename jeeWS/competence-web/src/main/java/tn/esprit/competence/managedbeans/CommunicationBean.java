package tn.esprit.competence.managedbeans;

import java.io.Serializable; 
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.xml.registry.infomodel.User;

import tn.esprit.competence.entity.Communication;
import tn.esprit.competence.entity.Competence;
import tn.esprit.competence.entity.Role;
import tn.esprit.competence.services.impl.CommunicationService;


@ManagedBean(name = "communicationBean") 
@SessionScoped 
public class CommunicationBean implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	private  List<Communication> communications;
    private  String nomemploye;
	private  String linguistique ;
	private  String sociolinguistique ;
	private  String socioculturelle ;
	private  String strategique; 
    private  Integer communicationIdToBeUpdated; 
    
	
	
    
    @EJB
	CommunicationService  communicationService; 
	public void addCommunication() { 
		
	   communicationService.ajouterCommunication(new  Communication( nomemploye,  linguistique, sociolinguistique ,socioculturelle,strategique) ); 
	   }
	public void removeCommunication(int communicationId) { 
		communicationService.deleteCommunicationById(communicationId); }
	public void displayCommunication(Communication empl) { 
    this.setNomemploye(empl.getNomemploye());  
	this.setLinguistique(empl.getLinguistique()); 
	this.setSociolinguistique(empl.getSociolinguistique()); 
	this.setSocioculturelle(empl.getSocioculturelle()); 
	this.setStrategique(empl.getStrategique());
	this.setcommunicationIdToBeUpdated(empl.getId()); }

	
	public void updateCommunication() { 
		communicationService.updateCommunication(new Communication(  communicationIdToBeUpdated,  nomemploye, linguistique, sociolinguistique,socioculturelle, strategique));
		} 
	public  void updateCommunication2() { 
		communicationService.updateCommunication2(new Communication("", "bien", "bien","bien","bien"));
		} 
	public  void updateCommunication3() { 
		communicationService.updateCommunication2(new Communication("", "moyen", "moyen","moyen","moyen"));
		} 
	public  void updateCommunication4() { 
		communicationService.updateCommunication2(new Communication("", "faible", "faible","faible","faible"));
		} 
	
	
	public  void updateCompetence15() { 
		communicationService.updateCommunication6(new Communication("", "bien"));
		} 
	public  void updateCompetence16() { 
		communicationService.updateCommunication6(new Communication("", "moyen"));
		} 
	public  void updateCompetence17() { 
		communicationService.updateCommunication6(new Communication("", "faible"));
		} 
	public  void updateCompetence5() { 
		communicationService.updateCommunication7(new Communication("","", "bien"));
		} 
	public  void updateCompetence6() { 
		communicationService.updateCommunication7(new Communication("","", "moyen"));
		} 
	public  void updateCompetence7() { 
		communicationService.updateCommunication7(new Communication("","", "faible"));
		} 
	
	public  void updateCompetence8() { 
		communicationService.updateCommunication8(new Communication("","","", "bien"));
		} 
	public  void updateCompetence9() { 
		communicationService.updateCommunication8(new Communication("","","", "moyen"));
		} 
	public  void updateCompetence10() { 
		communicationService.updateCommunication8(new Communication("","","", "faible"));
		} 
	public  void updateCompetence11() { 
		communicationService.updateCommunication9(new Communication("","","","", "bien"));
		} 
	public  void updateCompetence12() { 
		communicationService.updateCommunication9(new Communication("","","","", "moyen"));
		} 
	public  void updateCompetence13() { 
		communicationService.updateCommunication9(new Communication("","","","", "faible"));
		} 
	
	public void updateTest2() {
		
		if(UserBean.result<2) {updateCommunication4();}
		else if (UserBean.result==2) {updateCommunication3();}
		else if(UserBean.result>2) {updateCommunication2();}
	
		
		}
	
	public void updateTest6() {
		
		if(UserlBean.result<2) {updateCompetence17();}
		else if (UserlBean.result==2) {updateCompetence16();}
		else if(UserlBean.result>2) {updateCompetence15();}
	
		
		}
public void updateTest7() {
		
		if(UserslBean.result<2) {updateCompetence7();}
		else if (UserslBean.result==2) {updateCompetence6();}
		else if(UserslBean.result>2) {updateCompetence5();}
	
		
		}

public void updateTest8() {
	
	if(UserscBean.result<2) {updateCompetence10();}
	else if (UserscBean.result==2) {updateCompetence9();}
	else if(UserscBean.result>2) {updateCompetence8();}

	
	}

public void updateTest9() {
	
	if(UsersBean.result<2) {updateCompetence13();}
	else if (UsersBean.result==2) {updateCompetence12();}
	else if(UsersBean.result>2) {updateCompetence11();}

	
	}
	

	
	public List<Communication> getCommunications() {
		communications = communicationService.getAllCommunications(); 
		return communications;
	}
	
	public Integer getcommunicationIdToBeUpdated() {
		return communicationIdToBeUpdated;
	}
	public void setcommunicationIdToBeUpdated(Integer  communicationIdToBeUpdated) {
		this.communicationIdToBeUpdated = communicationIdToBeUpdated;
	}
	public String getNomemploye() {
		return nomemploye;
	}
	public void setNomemploye(String nomemploye) {
		this.nomemploye = nomemploye;
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
	public Integer getCommunicationIdToBeUpdated() {
		return communicationIdToBeUpdated;
	}
	public void setCommunicationIdToBeUpdated(Integer communicationIdToBeUpdated) {
		this.communicationIdToBeUpdated = communicationIdToBeUpdated;
	}
	public CommunicationService getCommunicationService() {
		return communicationService;
	}
	public void setCommunicationService(CommunicationService communicationService) {
		this.communicationService = communicationService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setCommunications(List<Communication> communications) {
		this.communications = communications;
	}

	
	



}
