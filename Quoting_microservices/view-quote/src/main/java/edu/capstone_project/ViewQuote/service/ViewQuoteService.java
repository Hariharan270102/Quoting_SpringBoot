package edu.capstone_project.ViewQuote.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.capstone_project.ViewQuote.model.ViewQuote;
import edu.capstone_project.ViewQuote.repository.ViewQuoteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewQuoteService {
	private final ViewQuoteRepository viewQuoteRepo;
	public String addQuote(ViewQuote quote) {
	    String planId = quote.getPlanId();
	    String user_email = quote.getUserEmail();
	    List<ViewQuote> vl = viewQuoteRepo.findByPlanIdAndEmailId(planId, user_email);
	    
	    if (vl.isEmpty()) {
	        System.out.println(planId);
	        viewQuoteRepo.save(quote);
	    } else {
	        ViewQuote existingQuote = vl.get(0);
	        existingQuote.setQuantity(existingQuote.getQuantity() + 1);
	        viewQuoteRepo.save(existingQuote);
	    }
	    
	    return "quote added successfully";
	}


	public List<ViewQuote> getQuote(String userEmail) {
		// TODO Auto-generated method stub
		List<ViewQuote> viewQuoteList=new ArrayList<>();
		return viewQuoteList=viewQuoteRepo.findByUserEmail(userEmail);
		 
	}


	public String removePlanQuantityFromQuote(ViewQuote removeQuote) {
		String user_email=removeQuote.getUserEmail();
		String planId=removeQuote.getPlanId();
		List<ViewQuote> vl=new ArrayList<>();
		vl=viewQuoteRepo.findByPlanIdAndEmailId(planId,user_email);
		ViewQuote existingQuote = vl.get(0);
		if(existingQuote.getQuantity()>1) {
			 existingQuote.setQuantity(existingQuote.getQuantity()-1);
		}
		else {
			deletePlanFromQuote(existingQuote.getPlanId(),existingQuote.getUserEmail());
		}
		
		 viewQuoteRepo.save(existingQuote);
		return "Quantity removed successfully";
	}


	public String deletePlanFromQuote(String planId, String userEmail) {
		viewQuoteRepo.deletePlanByPlanIdAndUserEmail(planId, userEmail);
		return "Plan deleted successfully";
	}


	
	

}
