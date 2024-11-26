package edu.lawrence.getoutdoors.interfaces;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.getoutdoors.exceptions.DuplicateException;
import edu.lawrence.getoutdoors.exceptions.InvalidException;
import edu.lawrence.getoutdoors.interfaces.dtos.RegistrationDTO;
import edu.lawrence.getoutdoors.security.AppUserDetails;
import edu.lawrence.getoutdoors.services.EventService;

@RestController
@RequestMapping("/registrations")
@CrossOrigin(origins = "*")
public class RegistrationController {
	private EventService es;

    public RegistrationController() {}

    // Register new user
    @PostMapping
    public ResponseEntity<RegistrationDTO> save(Authentication authentication,@RequestBody RegistrationDTO reg) {
		AppUserDetails details = (AppUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
		reg.setUserid(id);
        if (reg.getUserid().toString().isBlank() || reg.getEventid().toString().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reg);
        }
        try {
        	es.saveRegistration(reg);
        } catch(DuplicateException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(reg);
        } catch(InvalidException ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reg);
		}
        return ResponseEntity.status(HttpStatus.CREATED).body(reg);
    }
}
