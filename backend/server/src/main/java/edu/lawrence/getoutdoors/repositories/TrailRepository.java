package edu.lawrence.getoutdoors.repositories;

// Spring-level includes [Interfaces]
import org.springframework.data.jpa.repository.JpaRepository;

import edu.lawrence.getoutdoors.entities.Trail;

public interface TrailRepository extends JpaRepository<Trail, Integer>{
    
}
