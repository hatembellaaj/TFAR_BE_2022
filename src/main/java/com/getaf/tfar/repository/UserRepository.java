package com.getaf.tfar.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.Patient;
import com.getaf.tfar.domain.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByLogin(String login);

	Boolean existsByLogin(String login);

	Boolean existsByEmail(String email);
	
	@Query("SELECT u FROM com.getaf.tfar.domain.entity.User u WHERE u.code = :idOfUser") 
	User findUserByCode(@Param("idOfUser") Long idOfUser);
}
