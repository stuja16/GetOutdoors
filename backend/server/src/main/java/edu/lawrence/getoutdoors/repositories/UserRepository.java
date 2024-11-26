package edu.lawrence.getoutdoors.repositories;

// Java-level includes [Utility]
import java.util.List;
import java.util.UUID;

// Spring-level includes [Interfaces]
import org.springframework.data.jpa.repository.JpaRepository;

import edu.lawrence.getoutdoors.entities.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	
	List<User> findByUsername(String username);
	
}