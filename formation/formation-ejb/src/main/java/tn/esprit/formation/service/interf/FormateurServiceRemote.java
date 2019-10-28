package tn.esprit.formation.service.interf;

import java.util.List;

import tn.esprit.formation.entity.Formateur;



public interface FormateurServiceRemote {
	
	public int addFormateur(Formateur formateur);
	public void removeFormateur(int id);
	public void updateFormateur(Formateur formateur);
	//public Formateur getFormateurByEmailAndPassword(String mail, String password);
	public List<Formateur> getAllFormateurs();


}
