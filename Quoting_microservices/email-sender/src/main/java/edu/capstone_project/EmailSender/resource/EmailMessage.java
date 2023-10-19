package edu.capstone_project.EmailSender.resource;

public class EmailMessage {
	private String to;
	private String subject;
	private int otp;
	private String message;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message="<html><body>"

		                + "<h2 style='color: red;'>RECOVER YOUR PASSWORD</h2>"

		                + "<p style='font-size: 16px;'>Dear User,</p>"

		                + "<p style='font-size: 16px;'>Please enter the otp to change yout password</p>"
		                
		                + "<p style='font-size: 16px;'>Your OTP is : "+this.otp+" </p>"


		                + "<p style='font-size: 16px;'>If you have any questions or need assistance, please contact our support team.</p>"

		                + "</body></html>";
	}
	public EmailMessage(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = this.message;
	}
	public EmailMessage() {
		super();
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		 this.otp = otp;
	}

}
