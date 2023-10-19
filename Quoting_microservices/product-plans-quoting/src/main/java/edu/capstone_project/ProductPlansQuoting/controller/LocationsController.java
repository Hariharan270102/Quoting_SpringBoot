package edu.capstone_project.ProductPlansQuoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.ProductPlansQuoting.dto.LocationRequest;
import edu.capstone_project.ProductPlansQuoting.dto.LocationResponse;
import edu.capstone_project.ProductPlansQuoting.model.Locations;
import edu.capstone_project.ProductPlansQuoting.service.LocationsService;

@RestController
@RequestMapping("/locations")
public class LocationsController {
	@Autowired
	LocationsService locationsService;
	
	@PostMapping()
	public String addLocation(@RequestBody LocationRequest locationReq) {
		System.out.println("hehehe");
		return locationsService.addLocation(locationReq);
	}
	
	@GetMapping()
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Locations> getLocations(){
		System.out.println("hiii");
		System.out.println(locationsService.getLocations());
		return locationsService.getLocations();
		
	}

}
