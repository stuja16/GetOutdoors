package edu.lawrence.getoutdoors.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.getoutdoors.entities.Trail_Data;
import edu.lawrence.getoutdoors.interfaces.dtos.TrailDTO;
import edu.lawrence.getoutdoors.services.TrailService;

@RestController
@RequestMapping("/trails")
@CrossOrigin(origins = "*")
public class TrailController {
    
    private TrailService ts;

    public TrailController(TrailService ts) {
        this.ts = ts;
    }

    @GetMapping
	public ResponseEntity<List<TrailDTO>> findValidTrails() {
		List<Trail_Data> trails = ts.findValid();
		List<TrailDTO> results = new ArrayList<TrailDTO>();
		for(Trail_Data t : trails) {
			results.add(new TrailDTO(t));
		}
		return ResponseEntity.ok().body(results);
	}
}
