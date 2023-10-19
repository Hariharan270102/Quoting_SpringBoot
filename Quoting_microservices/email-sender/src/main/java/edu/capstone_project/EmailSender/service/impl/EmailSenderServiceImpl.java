package edu.capstone_project.EmailSender.service.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl{
	
	private final JavaMailSender javaMailSender;
	
	public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}

	public void sendEmail(String to, String subject, String msg) {
		// TODO Auto-generated method stub
//		System.out.println(message);
//		SimpleMailMessage mailMessage=new SimpleMailMessage();
//		mailMessage.setFrom("gdrive05hari@gmail.com");
//		mailMessage.setTo(to);
//		mailMessage.setSubject(subject);
//		mailMessage.setText(message);
//		
//		
//		this.javaMailSender.send(mailMessage);
		try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("gdrive05hari@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(msg, true); // Set the second parameter to 'true' to indicate HTML content

            javaMailSender.send(message);
        } catch (MessagingException e) {
            // Handle the exception appropriately (e.g., log or throw)
            e.printStackTrace();
        }
	}

}
