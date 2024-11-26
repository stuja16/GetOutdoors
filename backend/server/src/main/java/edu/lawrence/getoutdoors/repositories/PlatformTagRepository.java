package edu.lawrence.getoutdoors.repositories;

// Spring-level includes [Interfaces]
import org.springframework.data.jpa.repository.JpaRepository;

import edu.lawrence.getoutdoors.entities.PlatformTag;

public interface PlatformTagRepository extends JpaRepository<PlatformTag, Integer>{
	
}