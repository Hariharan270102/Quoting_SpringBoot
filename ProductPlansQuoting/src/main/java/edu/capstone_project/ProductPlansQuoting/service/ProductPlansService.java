package edu.capstone_project.ProductPlansQuoting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.capstone_project.ProductPlansQuoting.dto.ProductPlansRequest;
import edu.capstone_project.ProductPlansQuoting.dto.ProductPlansResponse;
import edu.capstone_project.ProductPlansQuoting.model.ProductPlans;
import edu.capstone_project.ProductPlansQuoting.repository.ProductPlansRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductPlansService {
	private final ProductPlansRepository productPlansRepo;
	
//	private final ProductPlansResponse productPlansResponse;

	public String addProductPlan(ProductPlansRequest prodPlanReq) {
		  ProductPlans prodPlans=ProductPlans.builder().
								planId(prodPlanReq.getPlanId()). 
								planName(prodPlanReq.getPlanName()). 
								planPrice(prodPlanReq.getPlanPrice()). 
								planValidity(prodPlanReq.getPlanValidity()). 
								planData(prodPlanReq.getPlanData()). 
								planCategory(prodPlanReq.getPlanCategory()). 
								planSubscriptions(prodPlanReq.getPlanSubscriptions()). 
								planLocations(prodPlanReq.getPlanLocations()).
								build();
		  System.out.println(prodPlans);
		  System.out.println(prodPlanReq.getPlanLocations());
		  productPlansRepo.save(prodPlans);
		  
		  return "Product added successfully";
		
	}

	public List<ProductPlansResponse> sendProductPlans() {
		// TODO Auto-generated method stub
		List<ProductPlansResponse> productPlansresponseList=new ArrayList<>();
		List<ProductPlans> productPlansList= new ArrayList<>();

		productPlansList=productPlansRepo.findAll();
		
//		System.out.println(productPlansList);
		
		
		for(ProductPlans i : productPlansList) {
//			System.out.println(i);
			ProductPlansResponse productPlansResponse=new ProductPlansResponse();
			productPlansResponse.setPlanId(i.getPlanId());
			productPlansResponse.setPlanName(i.getPlanName());
			productPlansResponse.setPlanPrice(i.getPlanPrice());
			productPlansResponse.setPlanValidity(i.getPlanValidity());
			productPlansResponse.setPlanData(i.getPlanData());
			productPlansResponse.setPlanCategory(i.getPlanCategory());
			productPlansResponse.setPlanSubscriptions(i.getPlanSubscriptions());
			productPlansResponse.setPlanLocations(i.getPlanLocations());
			
			productPlansresponseList.add(productPlansResponse);
			
		}
		
		System.out.println(productPlansresponseList);
		return productPlansresponseList;
	}

	public static ProductPlansResponse sendProductPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductPlansResponse> getProductsByLocationAndCategory(String selectedLocation, String selectedCategory) {
		ProductPlansResponse productPlansResponse=new ProductPlansResponse();
		List<ProductPlansResponse> responseList=new ArrayList<>();
		List<ProductPlans> ppl=new ArrayList<>();
		ppl=productPlansRepo.findProductsByLocationAndCategory(selectedLocation,selectedCategory);
		for(ProductPlans i:ppl) {
			ProductPlansResponse productPlansResponse1=new ProductPlansResponse();
			productPlansResponse1.setPlanId(i.getPlanId());
			productPlansResponse1.setPlanName(i.getPlanName());
			productPlansResponse1.setPlanPrice(i.getPlanPrice());
			productPlansResponse1.setPlanValidity(i.getPlanValidity());
			productPlansResponse1.setPlanData(i.getPlanData());
			productPlansResponse1.setPlanCategory(i.getPlanCategory());
			productPlansResponse1.setPlanSubscriptions(i.getPlanSubscriptions());
			productPlansResponse1.setPlanLocations(i.getPlanLocations());
			
			responseList.add(productPlansResponse1);
			
		}
//		System.out.println("from product plans service getProductsByLocationAndCategory "+productPlansRepo.findProductsByLocationAndCategory(selectedLocation,selectedCategory));
		return responseList;
		
	}

	public ProductPlansResponse searchProduct(String planName) {
		return null;
		
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct(String planId) {
		this.productPlansRepo.deleteByPlanId(planId);
		// TODO Auto-generated method stub
		
	}
	
}
