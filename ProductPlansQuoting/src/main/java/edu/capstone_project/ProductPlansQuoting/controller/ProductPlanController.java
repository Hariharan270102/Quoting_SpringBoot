package edu.capstone_project.ProductPlansQuoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import edu.capstone_project.ProductPlansQuoting.dto.ProductPlansRequest;
import edu.capstone_project.ProductPlansQuoting.dto.ProductPlansResponse;
import edu.capstone_project.ProductPlansQuoting.service.ProductPlansService;

@RestController
@RequestMapping("/productplan")
public class ProductPlanController 
{
	@Autowired
	ProductPlansService productPlansService;
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public String addProductPlan(@RequestBody ProductPlansRequest prodPlanReq) {
		System.out.println(prodPlanReq);
		return productPlansService.addProductPlan(prodPlanReq);
		
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ProductPlansResponse> sendProductPlans(){
//		System.out.println(productPlansService.sendProductPlans());
		return productPlansService.sendProductPlans();

	}
	
	@GetMapping("/search-product")
	@CrossOrigin(origins="http://localhost:4200")
	public ProductPlansResponse sendProductPlan(@RequestParam String planName) {
		productPlansService.searchProduct(planName);
		return null;
	}
	
	
	@GetMapping("/location_category")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ProductPlansResponse> getProductsByLocationAndCategory(@RequestParam("selectedLocation") String selectedLocation,@RequestParam("selectedCategory") String selectedCategory) {
		if("".equals(selectedCategory)) {
			selectedCategory="NULL";
		}
		return productPlansService.getProductsByLocationAndCategory(selectedLocation,selectedCategory);
		
		
	}
	
	@DeleteMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteProduct(@RequestParam String planId) {
		System.out.println(planId);
		System.out.println("in delete");
		this.productPlansService.deleteProduct(planId);
		
	}
	
	


}
