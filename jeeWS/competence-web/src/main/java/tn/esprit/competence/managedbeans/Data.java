package tn.esprit.competence.managedbeans;

import java.io.Serializable; 

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.competence.entity.Role;

@ManagedBean(name = "data") 
@ApplicationScoped 
public class Data implements Serializable { 
	private static final long serialVersionUID = 1L; 
	public Role[] getRoles() { return Role.values(); }

}
