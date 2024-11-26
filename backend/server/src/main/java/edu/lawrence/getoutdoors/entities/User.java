package edu.lawrence.getoutdoors.entities;

// Java-level includes [Utility]
import java.util.List;
import java.util.UUID;

// Jakarta-level includes [Class Annotaions]
import jakarta.persistence.Entity;

// Jakarta-leve includes [Field Annotations]
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String username;
	
	private String password;
	
	@OneToOne(mappedBy = "user")
	private Profile profile;
	
	@OneToMany(mappedBy = "host")
	private List<Event> events;
	
	@OneToMany(mappedBy = "user")
	private List<Registration> registrations;
	
	public User() {}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	
}