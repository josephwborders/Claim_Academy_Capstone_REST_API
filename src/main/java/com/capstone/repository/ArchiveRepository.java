package com.capstone.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.capstone.entity.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository <Archive, String> {

	@Query("SELECT A FROM Archive A")
	List<Optional<Archive>> findAllArchives();
	
	@Query("SELECT A FROM Archive A WHERE A.companyName=?1")
	List<Optional<Archive>> findArchiveByCompany(String company);
	
	@Query("SELECT A FROM Archive A WHERE A.user.email=?1")
	List<Archive> findArchiveByUser(String email);
	
	@Query("SELECT A from Archive A WHERE A.companyName LIKE %?1% OR A.jobTitle LIKE %?1% OR A.jobLocation LIKE %?1% OR A.user.email LIKE %?1%")
	List<Optional<Archive>> findArchiveByKeyword(String keyword);
	
	@Query("SELECT A from Archive A WHERE A.id=?1")
	Archive findArchiveById(int id);
	
	@Transactional
	@Modifying
	@Query("DELETE from Archive A WHERE A.id=?1")
	void deleteArchive(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Archive A SET A.status=?1 WHERE A.id=?2")
	void updateStatus(String update, int id);
	
}
