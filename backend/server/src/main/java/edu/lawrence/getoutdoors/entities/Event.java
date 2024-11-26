package edu.lawrence.getoutdoors.entities;

// Java-level includes [Time]
import java.time.Instant;

// Java-level includes [Utility]
import java.util.List;

// Jakarta-level includes [Class Annotations]
import jakarta.persistence.Entity;

// Jakarta-level includes [Field Annotations]
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//Jakarta-level includes [Enums]
import jakarta.persistence.GenerationType;

@Entity
public class Event{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User host;
	
	private String name;
	private String description;
	private String location;
	
	private String timeZone;
	private Instant startTime;
	private Instant endTime;
	
	@OneToMany(mappedBy = "event")
	private List<Registration> registrations;
	
	// Genre and Platform tags not set up for events yet
//	private List<GenreTag> genres;
//	private List<PlatformTag> platforms;
	
	public Event() {
		name = "";
		description = "";
		location = "";
		
		timeZone = "";
		startTime = Instant.EPOCH;
		endTime = Instant.EPOCH;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	
}