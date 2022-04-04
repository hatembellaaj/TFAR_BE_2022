package com.getaf.tfar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
User findByLogin(String login);
   

}
