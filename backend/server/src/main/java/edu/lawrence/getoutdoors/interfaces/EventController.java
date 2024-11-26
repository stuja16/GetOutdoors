package edu.lawrence.getoutdoors.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.getoutdoors.entities.Event;
import edu.lawrence.getoutdoors.exceptions.DuplicateException;
import edu.lawrence.getoutdoors.exceptions.InvalidException;
import edu.lawrence.getoutdoors.interfaces.dtos.EventDTO;
import edu.lawrence.getoutdoors.interfaces.dtos.RegistrationDTO;
import edu.lawrence.getoutdoors.security.AppUserDetails;
import edu.lawrence.getoutdoors.services.EventService;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventController {
	private EventService es;

    public EventController(EventService es) {
		this.es = es;
	}

    // Register new user
    @PostMapping
    public ResponseEntity<EventDTO> save(Authentication authentication,@RequestBody EventDTO event) {
		AppUserDetails details = (AppUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
		event.setUserid(id);
        if (event.getUserid().toString().isBlank() || event.getName().isBlank() || event.getLocation().isBlank() || event.getStartTime().toString().isBlank() || event.getEndTime().toString().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(event);
        }
        try {
        	es.save(event);
        } catch(DuplicateException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(event);
        } catch(InvalidException ex) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(event);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

	@GetMapping("/{id}")
	public ResponseEntity<EventDTO> findById(@PathVariable Integer id) {

		Event event;
		try {
			event = es.findById(id);
		} catch (InvalidException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		EventDTO result = new EventDTO(event);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping
	public ResponseEntity<List<EventDTO>> findFutureEvents() {
		List<Event> events = es.findFuture();
		List<EventDTO> results = new ArrayList<EventDTO>();
		for(Event e : events) {
			results.add(new EventDTO(e));
		}
		return ResponseEntity.ok().body(results);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<RegistrationDTO> register(Authentication authentication,
			@PathVariable("id") Integer id) {

		AppUserDetails details = (AppUserDetails) authentication.getPrincipal();
		UUID userId = UUID.fromString(details.getUsername());

		RegistrationDTO ret = new RegistrationDTO();
		ret.setEventid(id);
		ret.setUserid(userId);

		try {
			es.saveRegistration(ret);
		} catch (DuplicateException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(ret);
		} catch (InvalidException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ret);
		}

		return ResponseEntity.ok().body(ret);
	}
	
	@GetMapping("/{id}/registrations")
	public ResponseEntity<List<RegistrationDTO>> getRegistrations(Authentication authentication,
			@PathVariable("id") Integer id) {

		List<RegistrationDTO> ret = new ArrayList<RegistrationDTO>();

		try {
			ret = es.getRegistrations(id);
		} catch (InvalidException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ret);
		}

		return ResponseEntity.ok().body(ret);
	}
}
