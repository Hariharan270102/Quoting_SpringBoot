package edu.capstone_project.ProductPlansQuoting.dto;

import org.springframework.stereotype.Component;

import edu.capstone_project.ProductPlansQuoting.model.Subscriptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionsRequest {
	private String subscriptionName;

}
