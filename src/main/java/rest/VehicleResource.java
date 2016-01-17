package rest;

import dao.VehicleDAO;
import domain.Vehicle;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

@Stateless
@Path("/vehicle")
public class VehicleResource {
	@EJB
	private VehicleDAO vehicleManager;

	@POST
	@Path("/addVehicle")
	public Response addVehicle(@FormParam("name") String name,
			@FormParam("type") String type,
			@FormParam("speed") int speed) {
		Vehicle vehicle = new Vehicle();
		vehicle.setName(name);
		vehicle.setType(type);
		vehicle.setSpeed(speed);
		vehicleManager.addVehicle(vehicle);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/getAllVehicles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> getAllVehicles() {
		return vehicleManager.getAllVehicles();
	}

	@GET
	@Path("/getVehicle/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicle getVehicleById(@PathParam("id") Long id) {
		return vehicleManager.getVehicleById(id);
	}

	@POST
	@Path("/deleteVehicle")
	public Response deleteVehicle(@FormParam("idVehicle") long idVehicle) {
		Vehicle vehicle = new Vehicle();
		vehicle.setIdVehicle(idVehicle);
		vehicleManager.deleteVehicle(vehicle);
		return Response.status(Response.Status.OK).build();
	}

}
