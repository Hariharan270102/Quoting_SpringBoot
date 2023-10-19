package edu.capstone_project.ViewQuote;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class ViewQuoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewQuoteApplication.class, args);
	}

}
