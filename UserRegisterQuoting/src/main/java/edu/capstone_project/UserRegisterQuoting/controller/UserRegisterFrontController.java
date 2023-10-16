package edu.capstone_project.UserRegisterQuoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String registerUser(@RequestBody UserRegisterRequest userRegReq) {
		System.out.println(userRegReq.firstname);
		return userRegService.addToUserRegisterDb(userRegReq);	
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public LoginCredentials getCredentials(@RequestParam String credentials) {
		log.info(credentials);
		return userRegService.getCredentials(credentials);
	}

}
