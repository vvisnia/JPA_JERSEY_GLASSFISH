package domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "Soldier")
@NamedQueries({
	@NamedQuery(name = "soldier.getAll", query = "Select s from Soldier s"),
	@NamedQuery(name = "soldier.getByID", query = "Select s from Soldier s where s.idSoldier = :idSoldier")
})

public class Soldier {
	private Long idSoldier;
	private String firstName;
	private String lastName;
	private String rank;

	
	private List<Scout> Scout = new ArrayList<Scout>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public Long getIdSoldier() {
		return idSoldier;
	}
	public void setIdSoldier(Long idSoldier) {
		this.idSoldier = idSoldier;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "soldier")
	@JsonIgnore
	public List<Scout> getScout(){
		return Scout;
	}
	public void setScout(List<Scout> Scout){
		this.Scout = Scout;
	}
	
	
	
}
