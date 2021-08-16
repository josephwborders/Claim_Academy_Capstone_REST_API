package com.capstone.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.capstone.entity.Archive;
import com.capstone.repository.ArchiveRepository;

@CrossOrigin
@RestController
public class ArchiveController {

	@Autowired
	ArchiveRepository ar;
	
	@GetMapping("/findAllArchives")
	public ResponseEntity<List<Optional<Archive>>> findAllArchives() {
		List<Optional<Archive>> arcList = this.ar.findAllArchives();
		return new ResponseEntity<List<Optional<Archive>>>(arcList, HttpStatus.OK);
	}
	
	@GetMapping("/findArchiveByCompany")
	public ResponseEntity<List<Optional<Archive>>> findArchiveByCompany(String company) {
		List<Optional<Archive>> arcList = this.ar.findArchiveByCompany(company);
		return new ResponseEntity<>(arcList, HttpStatus.OK);
	}
	
	@GetMapping("/findArchiveByUser")
	public ResponseEntity<List<Archive>> findArchiveByUser(String email) {
		List<Archive> arcList = this.ar.findArchiveByUser(email);
		return new ResponseEntity<>(arcList, HttpStatus.OK);
	}
	
	@GetMapping("/findArchiveById")
	public ResponseEntity<Archive> findArchiveById(int id) {
		Archive arc = this.ar.findArchiveById(id);
		if(arc != null) {
		return new ResponseEntity<Archive>(arc, HttpStatus.OK);
		}else {
			return new ResponseEntity<Archive>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findArchiveByKeyword")
	public ResponseEntity <List<Optional<Archive>>> findArchiveByKeyword(String keyword) {
		List<Optional<Archive>> arcList = this.ar.findArchiveByKeyword(keyword);
		return new ResponseEntity<List<Optional<Archive>>>(arcList, HttpStatus.OK);
	}
	
}
