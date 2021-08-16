package com.capstone.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="user")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
	
	@Id
	private int id;

	@Column(name="avatar")
	private byte[] avatar;
	
	@Column(name="acct_created")
	private LocalDate acctCreated;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="company")
	private String company;
	
	@Column(name="title")
	private String title;
	
	@Column(name="permission")
	private String permission;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy ="user")
	private List<Proposal> proposals;
	
	public User() {
	}
	
	
	public User(int id, String firstName, String lastName, String email, String phone, String company, String title,
			String permission, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.title = title;
		this.permission = permission;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getAcctCreated() {
		return acctCreated;
	}


	public void setAcctCreated(LocalDate acctCreated) {
		this.acctCreated = acctCreated;
	}


	public byte[] getAvatar() {
		return avatar;
	}


	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	
	
}
