package edu.lawrence.getoutdoors.interfaces;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.getoutdoors.entities.Profile;
import edu.lawrence.getoutdoors.entities.User;
import edu.lawrence.getoutdoors.exceptions.DuplicateException;
import edu.lawrence.getoutdoors.exceptions.UnauthorizedException;
import edu.lawrence.getoutdoors.interfaces.dtos.ProfileDTO;
import edu.lawrence.getoutdoors.interfaces.dtos.UserDTO;
import edu.lawrence.getoutdoors.security.AppUserDetails;
import edu.lawrence.getoutdoors.services.JwtService;
import edu.lawrence.getoutdoors.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    private UserService us;

    private JwtService jwtService;
    
    public UserController(UserService us, JwtService jwtService) {
        this.us = us;
        this.jwtService = jwtService;
    }

    // Register new user
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
        if (user.getUsername().isBlank() || user.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
        String key;
        try {
        key = us.save(user);
        } catch(DuplicateException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user);
        } 
        String token = jwtService.makeJwt(key);
        user.setToken(token);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserDTO> checkLogin(@RequestBody UserDTO user) {
        User result = us.findByNameAndPassword(user.getUsername(), user.getPassword());
        if (result == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        }
        String token = jwtService.makeJwt(result.getId().toString());
        user.setToken(token);
        return ResponseEntity.ok().body(user);
    }
    
    @PostMapping("/profile")
    public ResponseEntity<ProfileDTO> saveProfile(Authentication authentication,@RequestBody ProfileDTO profile) {
    	AppUserDetails details = (AppUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
    	ProfileDTO ret = profile;
    	
    	System.out.println(profile);
    	
    	try {
    		ret = us.saveProfile(id,profile);
    	} catch(UnauthorizedException ex) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ret);
    	} catch(DuplicateException ex) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body(ret);
    	}
    	return ResponseEntity.status(HttpStatus.CREATED).body(ret);
    }
    
    @GetMapping("/profile")
    public ResponseEntity<ProfileDTO> getProfile(Authentication authentication) {
    	AppUserDetails details = (AppUserDetails) authentication.getPrincipal();
    	UUID id = UUID.fromString(details.getUsername());
    	Profile result = us.findProfile(id);
    	if(result == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	ProfileDTO response = new ProfileDTO(result);
    	return ResponseEntity.ok().body(response);
    }
}