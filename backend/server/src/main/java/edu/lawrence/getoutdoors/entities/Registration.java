package edu.lawrence.getoutdoors.entities;

// Jakarta-level includes [Class Annotations]
import jakarta.persistence.Entity;

// Jakarta-level includes [Class Annotations]
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// Jakarta-level includes [Enums]
import jakarta.persistence.GenerationType;

@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "event")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	public Registration() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}