package edu.capstone_project.UserRegisterQuoting.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.UserRegisterQuoting.dto.UserRegisterRequest;
import edu.capstone_project.UserRegisterQuoting.model.LoginCredentials;
import edu.capstone_project.UserRegisterQuoting.service.UserRegisterService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/registerUser")
@Slf4j
public class UserRegisterFrontController 
{
	@Autowired
	UserRegisterService userRegService;
	
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200/")
	public Boolean registerUser(@RequestBody UserRegisterRequest userRegReq) {
		System.out.println(userRegReq.firstname);
		return userRegService.addToUserRegisterDb(userRegReq);	
	}
	
	@PutMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String changePassword(@RequestBody Map<String,String> changeUserCredentials) {
		System.out.println("from change pwd controller");
		String user_email=changeUserCredentials.get("user_email");
//		String user_email="gdrive05hari@gmail.com";
		String password=changeUserCredentials.get("password");
		System.out.println(user_email+" "+password);
		return userRegService.changeCredentials(user_email,password);
		
		
	}
	
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public LoginCredentials getCredentials(@RequestParam String credentials) throws Exception {
		log.info(credentials);
		return userRegService.getCredentials(credentials);
	}
	
//	@GetMapping("/check")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Boolean checkCredentials(@RequestParam String username,@RequestParam String password) throws Exception {
//		
//		return userRegService.checkCredentials(username,password);
//		
//	}
//	

	

	

}
