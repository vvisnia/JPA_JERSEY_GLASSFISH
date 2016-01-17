package domain;

import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "scout.getAll", query = "Select w from Scout w"),
		@NamedQuery(name = "scout.getById", query = "Select w from Scout w where w.idScout = :idScout"),
		@NamedQuery(name = "scout.getByIdSoldier", query = "Select w from Scout w where w.soldier = :idSoldier"),
		@NamedQuery(name = "scout.getByIdVehicle", query = "Select w from Scout w where w.vehicle = :idVehicle") })
public class Scout {

	private Long idScout;
	private String notes;

	private Soldier soldier;
	private Vehicle vehicle;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdScout() {
		return idScout;
	}

	public void setIdScout(Long idScout) {
		this.idScout = idScout;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@ManyToOne
	@JoinColumn(name = "idSoldier")
	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	@ManyToOne
	@JoinColumn(name = "idVehicle")
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
