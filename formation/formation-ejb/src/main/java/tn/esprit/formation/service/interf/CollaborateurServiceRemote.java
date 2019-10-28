package tn.esprit.formation.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.formation.entity.Collaborateur;


@Remote
public interface CollaborateurServiceRemote {
	
	public int addColl(Collaborateur collaborateur);
	public void removeColl(int id);
	public void updateColl(Collaborateur collaborateur);
	//public Employe findEmpById(int id);
	public Collaborateur getCollaborateurByEmailAndPassword(String mail, String password);
	public List<Collaborateur> getAllCollaborateurs();

}
