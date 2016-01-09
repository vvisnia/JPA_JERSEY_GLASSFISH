	package dao;


	import domain.*;
	import java.util.List;


public interface VehicleDAO {

	

		Vehicle addVehicle(Vehicle vehicle);
		void deleteVehicle(Vehicle vehicle);
		Vehicle updateVehicle(Vehicle vehicle);
		List<Vehicle> getAllVehicles();
		Vehicle getVehicleById(Long id);
	

}
