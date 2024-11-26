package edu.lawrence.getoutdoors.interfaces.dtos;

// Java-level includes [Utility]
import java.util.UUID;

import edu.lawrence.getoutdoors.entities.Event;
import edu.lawrence.getoutdoors.services.CTService;

// Java-level includes [Time]
import java.time.Instant;

public class EventDTO {
	
	private Integer eventId;
	
	private UUID userid;
	
	private String name;
	
	private String description;

	private String location;
	
	private String timeZone;
	
	private String startTime;
	
	private String endTime;
	
	private Integer numRegistered;
	
	public EventDTO() {
		eventId = 0;
		name = "";
		description = "";
		location = "";
		timeZone = "UTC";
		startTime = "12:00 AM, 1/01/1970 UTC"; // Instant.EPOCH as raw formatted string
		endTime = "12:00 AM, 1/01/1970 UTC";
		numRegistered = 0;
	}
	
	public EventDTO(Event core) {
		eventId = core.getId();
		userid = core.getHost().getId();
		name = core.getName();
		description = core.getDescription();
		location = core.getLocation();
		timeZone = core.getTimeZone().isBlank() ? "UTC" : core.getTimeZone();
		startTime = CTService.instToStr(core.getStartTime(), timeZone);
		endTime = CTService.instToStr(core.getEndTime(), timeZone);
		
		numRegistered = core.getRegistrations().size();
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public UUID getUserid() {
		return userid;
	}

	public void setUserid(UUID userid) {
		this.userid = userid;
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
		return this.location;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = CTService.instToStr(startTime, timeZone);
	}
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setEndTime(Instant endTime) {
		this.startTime = CTService.instToStr(endTime, timeZone);
	}
	
	public Integer getNumRegistered() {
		return numRegistered;
	}

	public void setNumRegistered(Integer numRegistered) {
		this.numRegistered = numRegistered;
	}
	
}