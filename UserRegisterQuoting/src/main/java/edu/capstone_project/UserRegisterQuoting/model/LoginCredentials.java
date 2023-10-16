package edu.capstone_project.UserRegisterQuoting.model;

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
public class LoginCredentials 
{
	private String firstname;
	private String email;
	private String password;
	private String phonenumber;
	private String state;


}
