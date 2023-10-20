package edu.capstone_project.ViewQuote.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewQuoteExcel {
	private String userEmail;
	private String userPhonenumber;
	private String planId;
	private String planName;
	private Integer planPrice;
	private String planData;
	private String planValidity;
	private String planCategory;
	private List<String> planSubscription;
	private List<String> planLocations;
	private int quantity;

}
