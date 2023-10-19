package edu.capstone_project.ViewQuote.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewQuote 
{
//	
//	 userEmail,
//     userPhonenumber,
//     product.planId,
//     product.planName,
//	product.planPrice,
//     product.planData,
//     product.planValidity,
//     product.planCategory,
//     product.planSubscriptions,
//     product.planLocations
//	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
