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
import tn.esprit.timesheet.services.impl.EmployeService;
@Path("users")
@RequestScoped
public class EmployeRessource {
	@EJB
	EmployeService employeService; 
	
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
 	public Response getAllUser ()
 	
 	{	
		return Response.ok(employeService.getAllEmployes()).build();
 	}
	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
 	public Response getUser (@PathParam(value="id")int id)
 	
 	{	
		return Response.ok(employeService.getEmployeById(id)).build();
 	}
	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser( Employe emp) {
		return Response.status(Status.CREATED).entity(employeService.ajouterEmploye(emp)).build();
	}
	@Secured
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser( Employe emp) {
		return Response.status(Status.ACCEPTED).entity(employeService.updateEmploye2(emp)).build();
	}
	@Secured
	@DELETE
 	@Path("{id}")
 	public Response deleteModules(@PathParam(value="id")int id)
 	{
		employeService.deleteEmployeById(id);
 				return Response.status(Status.OK).build();}
 				
 		
 		

}
