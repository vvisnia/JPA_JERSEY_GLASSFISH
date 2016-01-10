package service;

import org.hibernate.*;

import dao.SoldierDAO;
import domain.Soldier;

import javax.ejb.Stateless;
import javax.persistence.*;

import java.util.*;



@Stateless
public class SoldierManager implements SoldierDAO {
	
	@PersistenceContext
	EntityManager em;

	public Soldier addSoldier(Soldier soldier) {
		em.persist(soldier);
		em.flush();
		return soldier;
	}

	public void deleteSoldier(Soldier soldier) {
		em.remove(em.getReference(Soldier.class, soldier.getIdSoldier()));
		
	}

	public Soldier updateSoldier(Soldier soldier) {
		return em.merge(soldier);
	}

	public List<Soldier> getAllSoldiers() {
		
		return em.createNamedQuery("soldier.getAll").getResultList();
	}

	public Soldier getSoldierById(Long id) {

		return em.find(Soldier.class, id);
	}

	
	
}
