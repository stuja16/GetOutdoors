package edu.lawrence.getoutdoors.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Spring-level includes [Class Annotations]
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lawrence.getoutdoors.entities.Event;
import edu.lawrence.getoutdoors.entities.Registration;
import edu.lawrence.getoutdoors.entities.User;
import edu.lawrence.getoutdoors.exceptions.DuplicateException;
import edu.lawrence.getoutdoors.exceptions.InvalidException;
import edu.lawrence.getoutdoors.interfaces.dtos.EventDTO;
import edu.lawrence.getoutdoors.interfaces.dtos.RegistrationDTO;
import edu.lawrence.getoutdoors.repositories.EventRepository;
import edu.lawrence.getoutdoors.repositories.RegistrationRepository;
import edu.lawrence.getoutdoors.repositories.UserRepository;

@Service
public class EventService{
	@Autowired
	EventRepository eventRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    UserRepository userRepository;
	
    // Register new event
	public String save(EventDTO e) throws DuplicateException, InvalidException {
        
		// I removed duplicate checking for now b/c I'm not sure how we could do that effectively
        // There are so many parameters that would constitute a different event if changed, and
        // there is not one variable that is unique to each event

		Optional<User> maybeUser = userRepository.findById(e.getUserid());
		if (!maybeUser.isPresent())
			throw new InvalidException();
		
		Event newE = new Event();
		newE.setHost(maybeUser.get());
		newE.setName(e.getName());
        newE.setDescription(e.getDescription());
        newE.setLocation(e.getLocation());
        newE.setTimeZone(e.getTimeZone());
        newE.setStartTime(CTService.strToInst(e.getStartTime(), newE.getTimeZone()));
        newE.setEndTime(CTService.strToInst(e.getEndTime(), newE.getTimeZone()));
        // When an event is first created, there should not be any registrants
        eventRepository.save(newE);
		return newE.getId().toString();
	}

    public Event findById(Integer id) throws InvalidException {
    	Optional<Event> maybeEvent = eventRepository.findById(id);
    	if(!maybeEvent.isPresent())
    		throw new InvalidException();
    	
		return maybeEvent.get();
	}

    public List<Event> findFuture() {
		return eventRepository.findFuture(Instant.now());
	}

    public void saveRegistration(RegistrationDTO reg) throws DuplicateException, InvalidException {
        // Check if event exists
        Optional<Event> maybeEvent = eventRepository.findById(reg.getEventid());
        if(!maybeEvent.isPresent())
			throw new InvalidException();
        Event event = maybeEvent.get();

        // Create Registration object
        Registration newReg = new Registration();
        newReg.setUser(userRepository.findById(reg.getUserid()).get());
        newReg.setEvent(event);

        // Check for duplicates in Registration table
        Optional<Registration> maybeRegistration = registrationRepository.checkForDuplicates(newReg.getEvent().getId(), newReg.getUser().getId());
		if(maybeRegistration.isPresent())
			throw new DuplicateException();

        // Log Registration
		System.out.println("Testing");
        registrationRepository.save(newReg);
    }
    
	public List<RegistrationDTO> getRegistrations(Integer id) throws InvalidException {
		Optional<Event> maybeEvent = eventRepository.findById(id);
		if (!maybeEvent.isPresent())
			throw new InvalidException();

		List<RegistrationDTO> ret = new ArrayList<RegistrationDTO>();

		maybeEvent.get().getRegistrations().forEach((r) -> {
			ret.add(new RegistrationDTO(r));
		});

		if (ret.size() == 0) {
			RegistrationDTO r = new RegistrationDTO();
			r.setEventid(-1);
			r.setUserid(null);
			ret.add(r);
		}

		return ret;
	}
}