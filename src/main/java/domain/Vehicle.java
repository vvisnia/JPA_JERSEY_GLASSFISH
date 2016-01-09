package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

import java.util.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "vehicle.getAll", query = "Select v from Vehicle v"),
		@NamedQuery(name = "vehicle.getByID", query = "Select v from v.idVehicle = :idVehicle")

})
public class Vehicle {

	private Long idVehicle;
	private String name;
	private String type;
	private int speed;

	private List<Scout> Scout = new ArrayList<Scout>();

	public Long getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vehicle")
	@JsonIgnore
	public List<Scout> getScout() {
		return Scout;
	}

	public void setScout(List<Scout> scout) {
		this.Scout = scout;
	}
}
