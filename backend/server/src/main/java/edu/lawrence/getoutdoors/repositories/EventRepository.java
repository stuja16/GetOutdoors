package edu.lawrence.getoutdoors.repositories;

// Java-level includes [Utility]
import java.time.Instant;
import java.util.List;

// Spring-level includes [Interfaces]
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.getoutdoors.entities.Event;
import edu.lawrence.getoutdoors.entities.User;

public interface EventRepository extends JpaRepository<Event, Integer>{
	List<Event> findByName(String name);
	List<Event> findByHost(User host);

	@Query("select e from Event e where startTime>=:now")
	List<Event> findFuture(Instant now);
}