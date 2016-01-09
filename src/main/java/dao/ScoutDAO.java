package dao;
import domain.*;
import java.util.*;

public interface ScoutDAO {

	Scout addScout(Scout scout);
	void deleteScout(Scout scout);
	Scout updateScout(Scout scout);
	List<Scout> getAllScouts();
	Scout getScoutById(Long id);
	List<Scout> getScoutsBySoldierId(Soldier soldier);
	List<Scout> getScoutsByVehicleId(Vehicle vehicle);
}
