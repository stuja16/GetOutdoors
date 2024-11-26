package edu.lawrence.getoutdoors.entities;

// Java-level includes [Utility]
import java.util.List;

import edu.lawrence.getoutdoors.interfaces.dtos.ProfileDTO;
// Jakarta-level includes [Class Annotations]
import jakarta.persistence.Entity;

// Jakarta-level includes [Field Annotations]
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Profile{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "userid")
	private User user;
	
	private String fullname;
	
	private String emailaddress;
	
	private int countrycode;
	
	private String phonenumber;
	
	private String bio;
	
	@OneToMany(mappedBy = "profile")
	private List<GenreTag> genres;

	@OneToMany(mappedBy = "profile")
	private List<PlatformTag> platforms;
	
	public Profile() {}

	public Profile(ProfileDTO core) {
		fullname = core.getFullname();
		emailaddress = core.getEmailaddress();
		phonenumber = core.getPhonenumber();
		bio = core.getBio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<GenreTag> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreTag> genres) {
		this.genres = genres;
	}

	public List<PlatformTag> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<PlatformTag> platforms) {
		this.platforms = platforms;
	}
	
}