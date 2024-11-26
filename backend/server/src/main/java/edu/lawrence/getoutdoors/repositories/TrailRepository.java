package edu.lawrence.getoutdoors.repositories;

import java.util.List;

// Spring-level includes [Interfaces]
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.getoutdoors.entities.Trail_Data;

public interface TrailRepository extends JpaRepository<Trail_Data, Integer>{
    @Query("select t from Trail_Data t where trail_name IS NOT NULL")
	List<Trail_Data> findValid();
}
