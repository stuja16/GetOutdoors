package edu.lawrence.getoutdoors.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lawrence.getoutdoors.entities.Trail_Data;
import edu.lawrence.getoutdoors.repositories.TrailRepository;

@Service
public class TrailService {
	@Autowired
	TrailRepository trailRepository;

	public List<Trail_Data> findValid() {
		return trailRepository.findValid();
	}
}
