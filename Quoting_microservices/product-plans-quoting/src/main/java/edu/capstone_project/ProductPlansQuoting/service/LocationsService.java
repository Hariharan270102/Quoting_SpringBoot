package edu.capstone_project.ProductPlansQuoting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.capstone_project.ProductPlansQuoting.dto.LocationRequest;
import edu.capstone_project.ProductPlansQuoting.dto.LocationResponse;
import edu.capstone_project.ProductPlansQuoting.model.Locations;
import edu.capstone_project.ProductPlansQuoting.repository.LocationsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationsService {
	private final LocationsRepository locationsRepo;

	public String addLocation(LocationRequest locationReq) {
		System.out.println(locationReq);
		Locations location=Locations.builder().locations(locationReq.getLocations()).build();
		System.out.println(location);
		locationsRepo.save(location);
		return "Location added successfully";
	}

	public List<Locations> getLocations() {
		// TODO Auto-generated method stub
		return locationsRepo.findAll();
	}
	

	
}
