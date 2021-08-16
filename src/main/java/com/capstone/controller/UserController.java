package com.capstone.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Contact;
import com.capstone.entity.User;
import com.capstone.repository.UserRepository;
import com.capstone.service.SendMail;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	SendMail sm;
	
	@PostMapping("/saveUser")
	public void submitUserDetails(@RequestBody User user) {
		user.setAcctCreated(LocalDate.now());
		this.ur.save(user);
		sm.sendEmail(user.getEmail(), "Welcome to XXXX XXXX Capstone Project", "Thank you for registering your interest"
				+ " in employing XXXX XXXX. \n"
				+ "\n"
				+ "You may login using your email address and password.");
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> handleLogin(@RequestBody User user) {
		User us = this.ur.loginUser(user.getEmail(), user.getPassword());
		if (us == null) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<User>(us, HttpStatus.OK);
	}

	@GetMapping("/findAllUsers")
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> list = this.ur.findAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@GetMapping("/findByEmail")
	public ResponseEntity<User> findByEmail(String email) {
		User us = this.ur.findByEmail(email);
		return new ResponseEntity<User>(us, HttpStatus.OK);
	}
	
	@PostMapping("/contact")
	public void contactMe(@RequestBody Contact contact) {
		
		sm.contactMe(contact);
	}


}
