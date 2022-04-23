package com.getaf.tfar.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByLogin(String login);

	Boolean existsByLogin(String login);

	Boolean existsByEmail(String email);
	
	
}
