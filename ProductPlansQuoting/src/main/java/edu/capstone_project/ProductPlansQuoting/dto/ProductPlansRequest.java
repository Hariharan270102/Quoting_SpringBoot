package edu.capstone_project.ProductPlansQuoting.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.capstone_project.ProductPlansQuoting.model.Locations;
import edu.capstone_project.ProductPlansQuoting.model.Subscriptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPlansRequest {
	private String planId;
	private String planName;
	private int planPrice;
	private String planValidity;
	private String planData;
	private String planCategory;
	private List<Subscriptions> planSubscriptions;
	private List<Locations> planLocations;

}
