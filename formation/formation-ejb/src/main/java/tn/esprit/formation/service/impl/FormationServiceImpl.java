package tn.esprit.formation.service.impl;
	
	import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.formation.entity.Formation;
import tn.esprit.formation.service.interf.FormationServiceRemote;


	@Stateless
	@LocalBean

	public class FormationServiceImpl implements FormationServiceRemote {
		
		@PersistenceContext(unitName = "formation-ejb")
		EntityManager em;

		@Override
		public int addFormation(Formation formation) {
			System.out.println("In addFormation : ");
			em.persist(formation);
			System.out.println("Out of addFormation" + formation.getIdFormation());
			return formation.getIdFormation();
		}

		

		@Override
		public void updateFormation(Formation formation) {
			Formation c = em.find(Formation.class, formation.getIdFormation());
			c.setNomFormation(formation.getNomFormation());
			c.setTypeFormation(formation.getTypeFormation());
			c.setNbPlaceFormation(formation.getNbPlaceFormation());
		    c.setDateDebutFormation(formation.getDateDebutFormation());
		    c.setDateFinFormation(formation.getDateFinFormation());
			c.setNbParticipant(formation.getNbParticipant());
			
		}

		@Override
		public void updateFormationAfterParticipation(Formation formation) {
			Formation c = em.find(Formation.class, formation.getIdFormation());
			c.setNomFormation(formation.getNomFormation());
			c.setTypeFormation(formation.getTypeFormation());
			c.setNbPlaceFormation(formation.getNbPlaceFormation());
		    c.setDateDebutFormation(formation.getDateDebutFormation());
		    c.setDateFinFormation(formation.getDateFinFormation());
			c.setNbParticipant(formation.getNbParticipant());
			c.setCollaborateurs(formation.getCollaborateurs());
			
		}
		@Override
		public List<Formation> getAllFormations() {
			List<Formation> formation = em.createQuery("Select f from Formation f",
					Formation.class).getResultList();
			return formation;
		}



		@Override
		public void removeFormation(int id) {
			System.out.println("In removeFormation : ");
			em.remove(em.find(Formation.class, id));
			System.out.println("Out of removeFormation : ");
			
		}

		

}
