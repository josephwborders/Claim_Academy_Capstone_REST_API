package com.capstone.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="archive")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Archive {

	@Id
	private int id;
	
	@Column(name="proposal_created")
	private LocalDate proposalCreated;
	
	@Column(name="document")
	private byte[] document;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_info")
	private String companyInfo;
	
	@Column(name="company_website")
	private String companyWebsite;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_location")
	private String jobLocation;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="pay_range")
	private String payRange;
	
	@Column(name="benefits")
	private String benefits;
	
	@Column(name="additional")
	private String additional;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public Archive() {
	}

	public Archive(int id, LocalDate proposalCreated, byte[] document, String companyName, String companyInfo,
			String companyWebsite, String jobTitle, String jobLocation, String jobDescription, String payRange,
			String benefits, String additional, String status) {
		this.id = id;
		this.proposalCreated = proposalCreated;
		this.document = document;
		this.companyName = companyName;
		this.companyInfo = companyInfo;
		this.companyWebsite = companyWebsite;
		this.jobTitle = jobTitle;
		this.jobLocation = jobLocation;
		this.jobDescription = jobDescription;
		this.payRange = payRange;
		this.benefits = benefits;
		this.additional = additional;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getProposalCreated() {
		return proposalCreated;
	}

	public void setProposalCreated(LocalDate proposalCreated) {
		this.proposalCreated = proposalCreated;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getPayRange() {
		return payRange;
	}

	public void setPayRange(String payRange) {
		this.payRange = payRange;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
