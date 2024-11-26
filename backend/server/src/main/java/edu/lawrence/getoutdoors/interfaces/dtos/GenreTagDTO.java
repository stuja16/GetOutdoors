package edu.lawrence.getoutdoors.interfaces.dtos;

import edu.lawrence.getoutdoors.entities.GenreTag;

public class GenreTagDTO {
	
	private Integer profile;
	
	private String name;
	
	public GenreTagDTO() {}
	
	public GenreTagDTO(GenreTag core) {
		this();
		
		profile = core.getProfile().getId();
		name = core.getName();
	}

	public Integer getProfile() {
		return profile;
	}

	public void setProfile(Integer profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}