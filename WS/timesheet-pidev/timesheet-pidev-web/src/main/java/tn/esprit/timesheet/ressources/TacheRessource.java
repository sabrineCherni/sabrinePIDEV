package tn.esprit.timesheet.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.timesheet.services.impl.TimesheetService;
@Path("taches")
@RequestScoped
public class TacheRessource {
	@EJB 
	TimesheetService timesheetService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
 	public Response getAllUser ()
 	
 	{	
		return Response.ok(timesheetService.getAllTaches()).build();
 	}

}
