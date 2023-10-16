package edu.capstone_project.UserRegisterQuoting.service;

import org.springframework.stereotype.Service;

import edu.capstone_project.UserRegisterQuoting.dto.UserRegisterRequest;
import edu.capstone_project.UserRegisterQuoting.model.LoginCredentials;
import edu.capstone_project.UserRegisterQuoting.model.UserRegister;
import edu.capstone_project.UserRegisterQuoting.repository.UserRegisterRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterService 
{
	
	private final UserRegisterRepository userRegisterRepo;

	public String addToUserRegisterDb(UserRegisterRequest userRegReq) {
		UserRegister userRegister=UserRegister.builder().
				firstname(userRegReq.getFirstname()).
				lastname(userRegReq.getLastname()).
				username(userRegReq.getUsername()).
				password(userRegReq.getPassword()).
				email(userRegReq.getEmail()).
				phonenumber(userRegReq.getPhonenumber()).
				address(userRegReq.getAddress()).
				state(userRegReq.getState()).
				district(userRegReq.getDistrict()).
				build();
//				country(userRegReq.getCountry()).build();
		 userRegisterRepo.save(userRegister);
				
		return "User registered successfully";
	}

	public LoginCredentials getCredentials(String credentials) {
		UserRegister userObj=new UserRegister();
		if(credentials.contains("@")) {
			userObj = userRegisterRepo.findByEmail(credentials);

		}
		else {
			userObj = userRegisterRepo.findByPhonenumber(credentials);

		}
		LoginCredentials loginCredentials=LoginCredentials.builder().firstname(userObj.getFirstname()).
				email(userObj.getEmail()).password(userObj.getPassword()).phonenumber(userObj.getPassword()).state(userObj.getState()).
				build();
		System.out.println(loginCredentials);
		
		// TODO Auto-generated method stub
		return loginCredentials;
	}

	

}
