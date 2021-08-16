package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class MailController {

	@Autowired
	JavaMailSender emailSender;
	
}