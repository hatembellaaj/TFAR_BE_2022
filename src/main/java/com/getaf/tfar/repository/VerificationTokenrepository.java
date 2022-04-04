package com.getaf.tfar.repository;

import org.springframework.data.repository.CrudRepository;

import com.getaf.tfar.domain.entity.VerificationToken;

public interface VerificationTokenrepository extends CrudRepository<VerificationToken,Long>{
	VerificationToken findByToken(String token); 
}
