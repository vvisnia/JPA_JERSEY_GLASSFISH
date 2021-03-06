package rest;

import dao.SoldierDAO;
import domain.Soldier;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

@Stateless
@Path("/soldier")
public class SoldierResource {
	@EJB
	private SoldierDAO soldierManager;

	@POST
	@Path("/addSoldier")
	public Response addSoldier(@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("rank") String rank) {
		Soldier soldier = new Soldier();
		soldier.setFirstName(firstName);
		soldier.setLastName(lastName);
		soldier.setRank(rank);
		soldierManager.addSoldier(soldier);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@POST
	@Path("/updateSoldier")
	public Response updateSoldier(@FormParam("idSoldier") long idSoldier,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("rank") String rank) {
		Soldier soldier = new Soldier();
		soldier.setIdSoldier(idSoldier);
		soldier.setFirstName(firstName);
		soldier.setLastName(lastName);
		soldier.setRank(rank);
		soldierManager.updateSoldier(soldier);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@GET
	@Path("/getAllSoldiers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Soldier> getAllSoldiers() {
		return soldierManager.getAllSoldiers();
	}

	@GET
	@Path("/getSoldier/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Soldier getSoldierById(@PathParam("id") Long id) {
		return soldierManager.getSoldierById(id);
	}

	@POST
	@Path("/deleteSoldier")
	public Response deleteSoldier(@FormParam("idSoldier") long idSoldier) {
		Soldier soldier = new Soldier();
		soldier.setIdSoldier(idSoldier);
		soldierManager.deleteSoldier(soldier);
		return Response.status(Response.Status.OK).build();
	}

}
