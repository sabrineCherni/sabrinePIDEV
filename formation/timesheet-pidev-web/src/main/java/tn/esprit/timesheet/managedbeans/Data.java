package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.timesheet.entity.Role;
import tn.esprit.timesheet.entity.Status;

@ManagedBean(name = "data") 
@ApplicationScoped 
public class Data implements Serializable { 
	private static final long serialVersionUID = 1L; 
	public Role[] getRoles() { return Role.values(); }
	public Status[] getStatus() { return Status.values(); }

}
