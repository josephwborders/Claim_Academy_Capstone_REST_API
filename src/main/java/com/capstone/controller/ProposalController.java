package com.capstone.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.entity.Archive;
import com.capstone.entity.Proposal;
import com.capstone.entity.User;
import com.capstone.repository.ArchiveRepository;
import com.capstone.repository.ProposalRepository;
import com.capstone.repository.UserRepository;
import com.capstone.service.SendMail;

@CrossOrigin
@RestController
public class ProposalController {
	
	@Autowired
	ProposalRepository pr;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	ArchiveRepository ar;
	
	@Autowired
	SendMail sm;
	
	@PostMapping("/saveProposal")
	public void submitProposal(@RequestBody Proposal proposal) {
		User user =  ur.findByEmail(proposal.getUser().getEmail());
		proposal.setUser(user);
		proposal.setProposalCreated(LocalDate.now());
		proposal.setStatus("Under Review");
		this.pr.save(proposal);
//		sm.sendEmail(proposal.getUser().getEmail(), "Thank You For Your Proposal", "Thank you for creating a proposal."
//				+ "\n"
//				+ "XXXX XXXX will now carefully consider your proposal against the others received. If your proposal is "
//				+ "short-listed, you will receive an additional notification and an invitation to schedule an introductory phone call."
//				+ "\n"
//				+ "Your interest is greatly appreciated."
//				+ "\n"
//				+ "Have a wonderful day!");
	}
	
	
	@GetMapping("/findAllProposals")
	public ResponseEntity<List<Optional<Proposal>>> findAllProposals() {
		List<Optional<Proposal>> propList = this.pr.findAllProposals();
		return new ResponseEntity<List<Optional<Proposal>>>(propList, HttpStatus.OK);
	}
	
	@GetMapping("/findProposalByCompany")
	public ResponseEntity<List<Optional<Proposal>>> findProposalByCompany(String company) {
		List<Optional<Proposal>> propList = this.pr.findProposalByCompany(company);
		return new ResponseEntity<>(propList, HttpStatus.OK);
	}
	
	@GetMapping("/findProposalByUser")
	public ResponseEntity<List<Optional<Proposal>>> findProposalByUser(String email) {
		List<Optional<Proposal>> propList = this.pr.findProposalByUser(email);
		if(propList != null) {
		return new ResponseEntity<>(propList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findProposalById")
	public ResponseEntity<Proposal> findProposalById(int id) {
		Proposal prop = this.pr.findProposalById(id);
		if(prop != null) {
		return new ResponseEntity<Proposal>(prop, HttpStatus.OK);
		}else {
			return new ResponseEntity<Proposal>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findProposalByKeyword")
	public ResponseEntity <List<Optional<Proposal>>> findProposalByKeyword(String keyword) {
		List<Optional<Proposal>> propList = this.pr.findProposalByKeyword(keyword);
		return new ResponseEntity<List<Optional<Proposal>>>(propList, HttpStatus.OK);
	}
	
	@PostMapping("/updateProposal")
	public ResponseEntity<Proposal> update(Proposal proposal){
		Proposal prop = pr.findProposalById(proposal.getId());
		prop.setId(proposal.getId());
		prop.setProposalCreated(proposal.getProposalCreated());
		prop.setDocument(proposal.getDocument());
		prop.setCompanyName(proposal.getCompanyName());
		prop.setCompanyInfo(proposal.getCompanyInfo());
		prop.setCompanyWebsite(proposal.getCompanyWebsite());
		prop.setJobTitle(proposal.getJobTitle());
		prop.setJobLocation(proposal.getJobLocation());
		prop.setJobDescription(proposal.getJobDescription());
		prop.setPayRange(proposal.getPayRange());
		prop.setBenefits(proposal.getBenefits());
		prop.setAdditional(proposal.getAdditional());
		prop.setStatus(proposal.getStatus());
		
		int id = proposal.getId();
		
		this.pr.updateProposal(prop, id);
		
		return new ResponseEntity<Proposal>(prop, HttpStatus.OK); 
	}
	
	@GetMapping("/updateStatusSelected")
	public void updateStatusSelected(int id){
		String update = "Selected for consideration";
		this.pr.updateStatus(update, id);
		//sm.StatusUpdate(proposal);

	}
	
	@GetMapping("/updateStatusDeclined")
	public void updateStatusDeclined(int id){
		String update = "Declined";
		this.pr.updateStatus(update, id);
		//sm.StatusUpdate(proposal);
	}
		
	@DeleteMapping("/delete")
	public void deleteProposal(int id) {
		Archive archive = new Archive();
		Proposal proposal = this.pr.findProposalById(id);
	
		archive.setId(proposal.getId());
		archive.setProposalCreated(proposal.getProposalCreated());
		archive.setDocument(proposal.getDocument());
		archive.setCompanyName(proposal.getCompanyName());
		archive.setCompanyInfo(proposal.getCompanyInfo());
		archive.setCompanyWebsite(proposal.getCompanyWebsite());
		archive.setJobTitle(proposal.getJobTitle());
		archive.setJobLocation(proposal.getJobLocation());
		archive.setJobDescription(proposal.getJobDescription());
		archive.setPayRange(proposal.getPayRange());
		archive.setBenefits(proposal.getBenefits());
		archive.setAdditional(proposal.getAdditional());
		archive.setStatus(proposal.getStatus());
		archive.setUser(proposal.getUser());
		this.ar.save(archive);
		
		pr.deleteProposal(id);
		
	}
	

}
