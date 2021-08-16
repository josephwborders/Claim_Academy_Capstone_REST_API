package com.capstone.entity;

public class Contact {

	private String email;
	
	private String name;
	
	private String subject;
	
	private String message;
	
	

	public Contact() {
	}

	public Contact(String email, String name, String subject, String message) {
		this.email = email;
		this.name = name;
		this.subject = subject;
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.message = message;
	}
	
	
}
