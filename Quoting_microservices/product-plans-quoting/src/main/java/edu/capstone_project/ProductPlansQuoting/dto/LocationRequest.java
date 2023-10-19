package edu.capstone_project.ProductPlansQuoting.dto;

import org.springframework.stereotype.Component;

import edu.capstone_project.ProductPlansQuoting.model.Locations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LocationRequest {
	private String locations;
}
