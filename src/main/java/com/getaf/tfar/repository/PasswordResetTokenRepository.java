package com.getaf.tfar.repository;
import org.springframework.data.repository.CrudRepository;

import com.getaf.tfar.domain.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken,Long>{
	PasswordResetToken findByToken(String token);
}
