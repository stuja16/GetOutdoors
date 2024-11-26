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
public class GenreTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genreTagID;
	
	@ManyToOne
	@JoinColumn(name = "profile")
	private Profile profile;
	
	private String name;
	
	public GenreTag() {}

	public Integer getGenreTagId() {
		return genreTagID;
	}

	public void setGenreTagId(Integer genreTagId) {
		this.genreTagID = genreTagId;
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