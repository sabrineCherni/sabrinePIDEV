package tn.esprit.competence.ressources;

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


import tn.esprit.competence.entity.Formation;
import tn.esprit.competence.services.impl.FormationService;
@Path("formations")
 // @RequestScoped
public class FormationRessource {
	@EJB 
	FormationService formationService; 
	
	//@Secured 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
 	public Response getAllUser ()
 	
 	{	
		return Response.ok(formationService.getAllFormations()).build();
 	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser( Formation emp) {
		if (emp != null) {
		return Response.status(Status.CREATED).entity(formationService.ajouterFormation(emp)).build();
	}
		return Response.status(Status.BAD_REQUEST).entity("not created").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser( Formation emp) {
		if(formationService.updateFormation0(emp)!=null)
		{
		return Response.status(Status.ACCEPTED).entity(formationService.updateFormation0(emp)).build();}
		return Response.status(Status.NOT_MODIFIED).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
 	public Response getUser (@PathParam(value="id")int id)
 	
 	{	
		if(formationService.getFormationById(id) != null ) {
		
		return Response.ok(formationService.getFormationById(id)).build();
 	}
		return Response.status(Status.NOT_FOUND).build();
 	}
	
	@DELETE
 	@Path("{id}")
 	public Response deleteModules(@PathParam(value="id")int id)
 	{
		formationService.deleteFormationById(id);
 				return Response.status(Status.OK).build();}
	


}
