package tn.esprit.competence.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.competence.entity.Communication;

@Remote
public interface CommunicationServiceRemote {
	
	
	public int ajouterCommunication(Communication communication);
	public void deleteCommunicationById(int communicationId);
	public List<Communication> getAllCommunications();
	public void updateCommunication(Communication communication);
	void updateCommunication2(Communication communication);


}
