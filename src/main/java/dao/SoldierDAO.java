package dao;


import domain.*;
import java.util.List;

public interface SoldierDAO {

	Soldier addSoldier(Soldier soldier);
	void deleteSoldier(Soldier soldier);
	Soldier updateSoldier(Soldier soldier);
	List<Soldier> getAllSoldiers();
	Soldier getSoldierById(Long id);
}
