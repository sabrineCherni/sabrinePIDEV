package tn.esprit.formation.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.formation.entity.Collaborateur;
import tn.esprit.formation.service.interf.CollaborateurServiceRemote;


@Stateless
@LocalBean

public class CollaborateurServiceImpl implements CollaborateurServiceRemote {
	
	@PersistenceContext(unitName = "formation-ejb")
	EntityManager em;

	@Override
	public int addColl(Collaborateur collaborateur) {
		System.out.println("In addColl : ");
		em.persist(collaborateur);
		System.out.println("Out of addColl" + collaborateur.getId());
		return collaborateur.getId();
	}

	@Override
	public void removeColl(int id) {
		System.out.println("In removeColl : ");
		em.remove(em.find(Collaborateur.class, id));
		System.out.println("Out of removeColl : ");
		
	}

	@Override
	public void updateColl(Collaborateur collaborateur) {
		Collaborateur c = em.find(Collaborateur.class, collaborateur.getId());
		c.setPrenom(collaborateur.getPrenom());
		c.setNom(collaborateur.getNom());
		c.setPassword(collaborateur.getPassword());
		c.setPoste(collaborateur.getPoste());
		c.setMail(collaborateur.getMail());
		c.setTel(collaborateur.getTel());
	
		
	}
	


	@Override
	public List<Collaborateur> getAllCollaborateurs() {
			List<Collaborateur> collaborateur = em.createQuery("Select c from Collaborateur c",
					Collaborateur.class).getResultList();
			return collaborateur;
	}

	@Override
	public Collaborateur getCollaborateurByEmailAndPassword(String mail, String password) {
		TypedQuery<Collaborateur> query =
				em.createQuery("SELECT c FROM Collaborateur c WHERE c.mail=:mail AND c.password=:password ",
						Collaborateur.class);
				query.setParameter("mail",mail);
				query.setParameter("password", password);
				Collaborateur collaborateur = null;
				try { collaborateur = query.getSingleResult(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }
				return collaborateur;
	}

}
