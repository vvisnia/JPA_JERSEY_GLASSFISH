package service;

import dao.ScoutDAO;

import domain.*;

import javax.ejb.Stateless;
import javax.persistence.*;

import java.util.*;

@Stateless
public class ScoutManager implements ScoutDAO {

	@PersistenceContext
	EntityManager em;

	public Scout addScout(Scout scout) {
		em.persist(scout);
		em.flush();
		return scout;
	}

	public void deleteScout(Scout scout) {
		em.remove(em.getReference(Scout.class, scout.getIdScout()));
	}

	public Scout updateScout(Scout scout) {
		return (Scout) em.merge(scout);
	}

	public List<Scout> getAllScouts() {
		return em.createNamedQuery("scout.getAll").getResultList();
	}

	public Scout getScoutById(Long id) {
		return em.find(Scout.class, id);
	}

	public List<Scout> getScoutsBySoldierId(Soldier soldier) {
		return em.createNamedQuery("scout.getByIdSoldier")
				.setParameter("idSoldier", soldier.getIdSoldier())
				.getResultList();
	}

	public List<Scout> getScoutsByVehicleId(Vehicle vehicle) {
		return em.createNamedQuery("scout.getByIdVehicle")
				.setParameter("idVehicle", vehicle.getIdVehicle())
				.getResultList();
	}
}
