package edu.capstone_project.ProductPlansQuoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.ProductPlansQuoting.dto.SubscriptionsRequest;
import edu.capstone_project.ProductPlansQuoting.model.Subscriptions;
import edu.capstone_project.ProductPlansQuoting.service.SubscriptionsService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionsController {
	@Autowired
	SubscriptionsService subsService;
	
	@PostMapping()
	public String addSubscriptions(@RequestBody SubscriptionsRequest subscriptionReq) {
		return subsService.addSubscription(subscriptionReq);
	
	}
	
	@GetMapping()
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Subscriptions> getSubscriptions() {
		return subsService.getSubscriptions();
		
		
	}
	

}
