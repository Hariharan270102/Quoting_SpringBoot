package edu.capstone_project.EmailSender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.EmailSender.resource.EmailMessage;
import edu.capstone_project.EmailSender.service.impl.EmailSenderServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmailController {
	
	private final EmailSenderServiceImpl emailSenderService;
	
	@PostMapping("/send-email")
	@CrossOrigin(origins = "http://localhost:4200")
 	public ResponseEntity<EmailMessage> sendEmail(@RequestBody EmailMessage emailMessage) {
		EmailMessage emailMessage1 = new EmailMessage();
		emailMessage1.setSubject(emailMessage.getSubject());
		emailMessage1.setTo(emailMessage.getTo());
		emailMessage1.setOtp((int) (Math.random() * 100000));
		emailMessage1.setMessage(emailMessage.getMessage());
		System.out.println(emailMessage1.getMessage());
		this.emailSenderService.sendEmail(emailMessage1.getTo(),emailMessage1.getSubject(), emailMessage1.getMessage());
		
		return ResponseEntity.ok(emailMessage1);
	}

}
