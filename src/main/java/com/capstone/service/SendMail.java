package com.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.capstone.entity.Contact;
import com.capstone.entity.Proposal;

@Service
public class SendMail {
	
	@Autowired
	public
	JavaMailSender emailSender;
	
	public void sendEmail(String toEmail, String subject, String message) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(message);
		
		emailSender.send(msg);
		
	}
	
	public void contactMe(Contact contact) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("XXXXXXXX@gmail.com");
		msg.setReplyTo(contact.getEmail());
		msg.setSubject(contact.getSubject());
		msg.setText(contact.getMessage() + "\n" + contact.getName());
		
		emailSender.send(msg);
	}
	
	public void StatusUpdate(Proposal proposal) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(proposal.getUser().getEmail());
		msg.setSubject("Your Proposal Status Has Been Updated");
		msg.setText("Please login to your account to view the updated status");
		
		emailSender.send(msg);
	}

}