package com.capstone.repository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, String> {
	
	@Query("SELECT U FROM User U WHERE U.email=?1 AND U.password=?2")
	User loginUser(String email, String password);
	
	@Query("SELECT U FROM User U")
	List<User> findAllUsers();
	
	@Query("SELECT U FROM User U WHERE U.email=?1")
	User findByEmail(String email);

}
