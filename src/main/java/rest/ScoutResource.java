package rest;

import dao.*;
import domain.Scout;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

@Stateless
@Path("/scout")
public class ScoutResource {
	@EJB
	private ScoutDAO scoutManager;
	@EJB
	private SoldierDAO soldierManager;
	@EJB
	private VehicleDAO vehicleManager;

	@POST
	@Path("/addScout")
	public Response addScout(@FormParam("Notes") String Notes,
			@FormParam("soldier") String soldier,
			@FormParam("vehicle") String vehicle) {
		Long soldierId = Long.parseLong(soldier.substring(0,
				soldier.indexOf('.')));
		Long vehicleId = Long.parseLong(vehicle.substring(0,
				vehicle.indexOf('.')));
		Scout scout = new Scout();
		scout.setNotes(Notes);

		scout.setSoldier(soldierManager.getSoldierById(soldierId));
		scout.setVehicle(vehicleManager.getVehicleById(vehicleId));
		scoutManager.addScout(scout);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/getAllScouts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Scout> getAllScouts() {
		return scoutManager.getAllScouts();
	}

	@GET
	@Path("/getScout/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Scout getScoutById(@PathParam("id") Long id) {
		return scoutManager.getScoutById(id);
	}

	@POST
	@Path("/deleteScout")
	public Response deletescout(@FormParam("idScout") long idScout) {
		Scout scout = new Scout();
		scout.setIdScout(idScout);
		scoutManager.deleteScout(scout);
		return Response.status(Response.Status.OK).build();
	}

}
