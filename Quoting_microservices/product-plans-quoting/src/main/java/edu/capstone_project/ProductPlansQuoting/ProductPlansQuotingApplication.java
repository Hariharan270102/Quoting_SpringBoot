package edu.capstone_project.ProductPlansQuoting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductPlansQuotingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPlansQuotingApplication.class, args);
	}

}
