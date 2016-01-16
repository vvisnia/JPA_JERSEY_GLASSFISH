package service;

import org.hibernate.*;

import dao.VehicleDAO;
import domain.Vehicle;

import javax.ejb.Stateless;
import javax.persistence.*;

import java.util.*;



@Stateless
public class VehicleManager implements VehicleDAO {
	
	@PersistenceContext
	EntityManager em;

	public Vehicle addVehicle(Vehicle vehicle) {
		em.persist(vehicle);
		em.flush();
		return vehicle;
	}

	public void deleteVehicle(Vehicle vehicle) {
		em.remove(em.getReference(Vehicle.class, vehicle.getIdVehicle()));
		
	}

	public Vehicle updateVehicle(Vehicle vehicle) {
		return em.merge(vehicle);
	}

	public List<Vehicle> getAllVehicles() {
		
		return em.createNamedQuery("vehicle.getAll").getResultList();
	}

	public Vehicle getVehicleById(Long id) {

		return em.find(Vehicle.class, id);
	}

	
	
}
