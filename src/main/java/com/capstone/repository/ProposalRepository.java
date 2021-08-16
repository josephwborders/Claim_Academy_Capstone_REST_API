package com.capstone.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.capstone.entity.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository <Proposal, String> {
	
	@Query("SELECT P FROM Proposal P")
	List<Optional<Proposal>> findAllProposals();
	
	@Query("SELECT P FROM Proposal P WHERE P.companyName=?1")
	List<Optional<Proposal>> findProposalByCompany(String company);
	
	@Query("SELECT P FROM Proposal P WHERE P.user.email=?1")
	List<Optional<Proposal>> findProposalByUser(String email);
	
	@Query("SELECT P from Proposal P WHERE P.companyName LIKE %?1% OR P.jobTitle LIKE %?1% OR P.jobLocation LIKE %?1% OR P.user.email LIKE %?1%")
	List<Optional<Proposal>> findProposalByKeyword(String keyword);
	
	@Query("SELECT P from Proposal P WHERE P.id=?1")
	Proposal findProposalById(int id);
	
	@Transactional
	@Modifying
	@Query("DELETE from Proposal P WHERE P.id=?1")
	void deleteProposal(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Proposal P SET P.status=?1 WHERE P.id=?2")
	void updateStatus(String update, int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Proposal P SET P=?2 WHERE P.id=?1")
	Proposal updateProposal(Proposal prop, int id);
}
