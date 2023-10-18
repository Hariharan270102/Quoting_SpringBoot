package edu.capstone_project.ViewQuote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.ViewQuote.model.ViewQuote;
import edu.capstone_project.ViewQuote.service.ViewQuoteService;

@RestController
@RequestMapping("/view-quote")
public class ViewQuoteController {
	@Autowired
	ViewQuoteService quoteService;
	
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String addQuote(@RequestBody ViewQuote quote) {
		System.out.println("hii from quote controller");
		System.out.println(quote);
		return quoteService.addQuote(quote);
		
	}
	
	@PutMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String removePlanQuantityFromQuote(@RequestBody ViewQuote removeQuote) {
		return quoteService.removePlanQuantityFromQuote(removeQuote);
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ViewQuote> getQuote(@RequestParam String userEmail ){
		System.out.println(quoteService.getQuote(userEmail));
		return quoteService.getQuote(userEmail);
	}
	
	@DeleteMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String deletePlanFromQuote(@RequestParam String planId,@RequestParam String userEmail) {
		return quoteService.deletePlanFromQuote(planId,userEmail);
		
	}

	

}
