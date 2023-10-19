package edu.capstone_project.ProductPlansQuoting.dto;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Component
public class LocationResponse {
	private String locations;

}
