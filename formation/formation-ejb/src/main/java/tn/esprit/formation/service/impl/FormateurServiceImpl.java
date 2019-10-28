package tn.esprit.formation.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.formation.entity.Formateur;
import tn.esprit.formation.service.interf.FormateurServiceRemote;


@Stateless
@LocalBean
public class FormateurServiceImpl implements FormateurServiceRemote{
	
	@PersistenceContext(unitName = "formation-ejb")
	EntityManager em;

	@Override
	public int addFormateur(Formateur formateur) {
		System.out.println("In addFormateur : ");
		em.persist(formateur);
		System.out.println("Out of addFormateur" + formateur.getIdFormateur());
		return formateur.getIdFormateur();
	}

	@Override
	public void removeFormateur(int id) {
		System.out.println("In removeformateur : ");
		em.remove(em.find(Formateur.class, id));
		System.out.println("Out of removeFormateur : ");
		
	}

	@Override
	public void updateFormateur(Formateur formateur) {
		Formateur fr = em.find(Formateur.class, formateur.getIdFormateur());
		fr.setPrenomFormateur(formateur.getPrenomFormateur());
		fr.setNomFormateur(formateur.getNomFormateur());
		fr.setPosteFormateur(formateur.getPosteFormateur());
		fr.setMailFormateur(formateur.getMailFormateur());
		fr.setTelFormateur(formateur.getTelFormateur());
	
		
	}

	@Override
	public List<Formateur> getAllFormateurs() {
		List<Formateur> formateur = em.createQuery("Select fr from Formateur fr",
				Formateur.class).getResultList();
		return formateur;
	}

}
