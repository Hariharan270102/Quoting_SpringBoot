package edu.capstone_project.UserRegisterQuoting.dto;

import org.springframework.stereotype.Component;

import edu.capstone_project.UserRegisterQuoting.model.UserRegister;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class UserRegisterRequest
{
	private int userId;
	public String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private String phonenumber;
	private String address;
//	private String city;
	private String state;
	private String district;
//	private String country;

}
