package edu.lawrence.getoutdoors.interfaces.dtos;

// Java-level incldues [Utility]
import java.util.ArrayList;
import java.util.List;

import edu.lawrence.getoutdoors.entities.Profile;

public class ProfileDTO{
	private String user;
	private String fullname;
	private String emailaddress;
	private int countrycode;
	private String phonenumber;
	private String bio;
	private List<String> genres;
	private List<String> platforms;
	
	public ProfileDTO() {
		countrycode = 1;
	}

	public ProfileDTO(Profile core) {
		user = core.getUser().getId().toString();
		fullname = core.getFullname();
		emailaddress = core.getEmailaddress();
		phonenumber = core.getPhonenumber();
		bio = core.getBio();
		
		genres = new ArrayList<String>();
		core.getGenres().forEach((g) -> genres.add(g.getName()));
		
		platforms = new ArrayList<String>();
		core.getPlatforms().forEach((p) -> platforms.add(p.getName()));
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
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

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	public List<String> getPlatforms() {
		return platforms;
	}
	
	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}
	
}