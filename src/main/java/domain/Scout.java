package domain;


import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(name = "scout.getAll", query = "Select w from Scout w"),
		@NamedQuery(name = "scout.getById", query = "Select w from Scout where w.Scout = :idScout"),
		@NamedQuery(name = "scout.getByIdSoldier", query = "Select w from Scout where w.soldier = :idSoldier"),
		@NamedQuery(name = "scout.getByIdVehicle", query = "Select w from Scout where w.vehicle = :idVehicle")
})



public class Scout {

		private Long idScout;
		private String Notes;
		
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
			return Notes;
		}
		public void setNotes(String notes) {
			Notes = notes;
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
