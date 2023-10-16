package edu.capstone_project.ProductPlansQuoting.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import edu.capstone_project.ProductPlansQuoting.dto.LocationRequest;
import edu.capstone_project.ProductPlansQuoting.dto.SubscriptionsRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Component
@Table(name = "product_plans")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPlans 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_no;
	@Column(unique = true)
	private String planId;
	private String planName;
	private int planPrice;
	private String planValidity;
	private String planData;
	private String planCategory;
	@ManyToAny
	private List<Subscriptions> planSubscriptions;
	@ManyToAny
	private List<Locations> planLocations;
}
