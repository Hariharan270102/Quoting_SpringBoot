package edu.capstone_project.ProductPlansQuoting.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_locations")
public class Locations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locId;
	@Column(unique = true)
	private String locations;

}
