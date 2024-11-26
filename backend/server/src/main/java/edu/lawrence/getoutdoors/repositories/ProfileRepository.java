package edu.lawrence.getoutdoors.repositories;

// Java-level includes [Utility]
import java.util.Optional;
import java.util.UUID;

// Spring-level includes [Interfaces]
import org.springframework.data.jpa.repository.JpaRepository;

import edu.lawrence.getoutdoors.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	
	Optional<Profile> findByUserId(UUID userid);
	
}