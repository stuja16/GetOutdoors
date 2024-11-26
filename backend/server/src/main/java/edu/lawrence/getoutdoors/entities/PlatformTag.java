package edu.lawrence.getoutdoors.entities;

// Jakarta-level includes [Class Annotations]
import jakarta.persistence.Entity;

// Jakarta-level includes [Field Annotations]
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class PlatformTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer platformTagID;
	
	@ManyToOne
	@JoinColumn(name = "profile")
	private Profile profile;
	
	private String name;
	
	public PlatformTag() {}

	public Integer getPlatformTagId() {
		return platformTagID;
	}

	public void setPlatformTagId(Integer platformTagID) {
		this.platformTagID = platformTagID;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}