package edu.capstone_project.ProductPlansQuoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public void editProduct(@RequestBody ProductPlansRequest editProduct) {
		System.out.println("from put controller");
		productPlansService.editProductPlan(editProduct);
	}
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ProductPlansResponse> sendProductPlans(){
//		System.out.println(productPlansService.sendProductPlans());
		return productPlansService.sendProductPlans();

	}
	
//	@GetMapping("/search-product")
//	@CrossOrigin(origins="http://localhost:4200")
//	public List<ProductPlansResponse> sendProductPlan(@RequestParam String planName) {
//		return productPlansService.searchProduct(planName);
//		 
//	} 
	
	@GetMapping("/search-product/{planName}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<ProductPlansResponse> sendProductPlan(@PathVariable("planName") String planName) {
		return productPlansService.searchProduct(planName);
		 
	}
	
	
	@GetMapping("/location_category")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ProductPlansResponse> getProductsByLocationAndCategory(@RequestParam("selectedLocation") String selectedLocation,@RequestParam("selectedCategory") String selectedCategory) {
		System.out.println(selectedCategory);
		if("".equals(selectedCategory) || "ALL".equals(selectedCategory)) {
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
