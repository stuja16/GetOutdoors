package edu.lawrence.getoutdoors.interfaces.dtos;

// Java-level includes [Utility]
import java.util.UUID;

import edu.lawrence.getoutdoors.entities.Registration;

public class RegistrationDTO{
	
	private Integer eventid;
	
	private UUID userid;
	
	public RegistrationDTO() {}

	public RegistrationDTO(Registration core) {
		eventid = core.getId();
		userid = core.getUser().getId();
	}

	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public UUID getUserid() {
		return userid;
	}

	public void setUserid(UUID userid) {
		this.userid = userid;
	}
	
}