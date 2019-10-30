package tn.esprit.formation.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.formation.entity.Formateur;
import tn.esprit.formation.service.impl.FormateurServiceImpl;

@ManagedBean(name = "formateurBean")
@SessionScoped
public class FormateurBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String prenomFormateur;
	private String nomFormateur;
	private String posteFormateur;
	private String mailFormateur;
	private int telFormateur;
    private Formateur selectedFormateur;

	@EJB
	FormateurServiceImpl formateurService;

	public void addFormateur() {
		formateurService.addFormateur(
				new Formateur(prenomFormateur, nomFormateur, posteFormateur, mailFormateur, telFormateur));
	}

	public void removeFormateur(int formateurId) {
		formateurService.removeFormateur(formateurId);
	}

	public FormateurBean() {
		super();
	}

	private List<Formateur> formateurs;

	public List<Formateur> getFormateurs() {
		formateurs = formateurService.getAllFormateurs();
		return formateurs;
	}

	public Formateur getFormateur(int id) {
		return formateurService.findFormateurpById(id);

	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public FormateurBean(String prenomFormateur, String nomFormateur, String passwordFormateur, String posteFormateur,
			String mailFormateur, int telFormateur, FormateurServiceImpl formateurService, List<Formateur> formateurs) {
		super();
		this.prenomFormateur = prenomFormateur;
		this.nomFormateur = nomFormateur;
		this.posteFormateur = posteFormateur;
		this.mailFormateur = mailFormateur;
		this.telFormateur = telFormateur;
		this.formateurService = formateurService;
		this.formateurs = formateurs;
	}

	public String getPrenomFormateur() {
		return prenomFormateur;
	}

	public void setPrenomFormateur(String prenomFormateur) {
		this.prenomFormateur = prenomFormateur;
	}

	public String getNomFormateur() {
		return nomFormateur;
	}

	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}

	public String getPosteFormateur() {
		return posteFormateur;
	}

	public Formateur getSelectedFormateur() {
		return selectedFormateur;
	}

	public void setSelectedFormateur(Formateur selectedFormateur) {
		this.selectedFormateur = selectedFormateur;
	}

	public void setPosteFormateur(String posteFormateur) {
		this.posteFormateur = posteFormateur;
	}

	public String getMailFormateur() {
		return mailFormateur;
	}

	public void setMailFormateur(String mailFormateur) {
		this.mailFormateur = mailFormateur;
	}

	public int getTelFormateur() {
		return telFormateur;
	}

	public void setTelFormateur(int telFormateur) {
		this.telFormateur = telFormateur;
	}

	public FormateurServiceImpl getFormateurService() {
		return formateurService;
	}

	public void setFormateurService(FormateurServiceImpl formateurService) {
		this.formateurService = formateurService;
	}


	private Integer formateurIdToBeUpdated;

	public void displayFormateur(Formateur formateur) {
		this.setFormateurIdToBeUpdated(formateur.getIdFormateur());
		this.setPrenomFormateur(formateur.getPrenomFormateur());
		this.setNomFormateur(formateur.getNomFormateur());
		this.setPosteFormateur(formateur.getPosteFormateur());
		this.setMailFormateur(formateur.getMailFormateur());
		this.setTelFormateur(formateur.getTelFormateur());

	}

	public void updateFormateur() {
		formateurService.updateFormateur(new Formateur(formateurIdToBeUpdated, prenomFormateur, nomFormateur,
				posteFormateur, mailFormateur, telFormateur));
	}

	public Integer getCollaborateurIdToBeUpdated() {
		return formateurIdToBeUpdated;
	}

	public void setFormateurIdToBeUpdated(Integer formateurIdToBeUpdated) {
		this.formateurIdToBeUpdated = formateurIdToBeUpdated;
	}

}
