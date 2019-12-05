package tn.esprit.timesheet.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.timesheet.entity.Employe;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.impl.TimesheetService;
@Path("taches")
@RequestScoped
public class TacheRessource {
	@EJB 
	TimesheetService timesheetService;
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
 	public Response getAllTaches ()
 	
 	{	if(timesheetService.getAllTaches()!=null)
		return Response.ok(timesheetService.getAllTaches()).build();
 	return Response.status(Status.NOT_FOUND).build();
 	}
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
 	public Response getTache (@PathParam(value="id")String id)
 	
 	{	if(timesheetService.getTacheById(id)!=null)
		return Response.ok(timesheetService.getTacheById(id)).build();
 	return Response.status(Status.NOT_FOUND).build();
 	}
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/{idprojet}")
 	public Response getTacheprojet (@PathParam(value="id")String id,@PathParam(value="idprojet")int idprojet)
 	
 	{	if(timesheetService.affecterTacheAProjet(id,idprojet)!=null)
		return Response.ok(timesheetService.affecterTacheAProjet(id,idprojet)).build();
 	return Response.status(Status.NOT_ACCEPTABLE).build();
 	}
	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTache( Tache tac) {
		
		return Response.status(Status.CREATED).entity(timesheetService.ajouterTache(tac)).build();
	}
	@Secured
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTache( Tache tac) {
		return Response.status(Status.ACCEPTED).entity(timesheetService.updateTache2( tac)).build();
	}
	@Secured
	@DELETE
 	@Path("{id}")
 	public Response deleteTache(@PathParam(value="id")String id)
 	{
		timesheetService.deleteTacheById(id);;
 				return Response.status(Status.OK).build();}
}
