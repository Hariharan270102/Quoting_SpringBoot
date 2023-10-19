package edu.capstone_project.UserRegisterQuoting.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "user_register_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegister 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phonenumber;
	private String address;
//	private String city;
	private String state;
	private String district;
//	private String country;
	

}
