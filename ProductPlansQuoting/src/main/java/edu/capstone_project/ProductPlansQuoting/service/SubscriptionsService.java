package edu.capstone_project.ProductPlansQuoting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.capstone_project.ProductPlansQuoting.dto.SubscriptionsRequest;
import edu.capstone_project.ProductPlansQuoting.model.Subscriptions;
import edu.capstone_project.ProductPlansQuoting.repository.SubscriptionsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionsService {
	private final SubscriptionsRepository subscriptionsRepo;

	public String addSubscription(SubscriptionsRequest subscriptionReq) {
		Subscriptions subs=Subscriptions.builder().
							subscriptionName(subscriptionReq.getSubscriptionName()).build();
		subscriptionsRepo.save(subs);
		return "Subscription added successfully";
	}

	public List<Subscriptions> getSubscriptions() {
		List<Subscriptions> subsList=new ArrayList<>();
		return subsList=subscriptionsRepo.findAll();
		 
	}

}
