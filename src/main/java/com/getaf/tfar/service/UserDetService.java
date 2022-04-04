package com.getaf.tfar.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.getaf.tfar.domain.entity.User;
import com.getaf.tfar.domain.entity.UserDet;
import com.getaf.tfar.repository.UserRepository;
@Service
public class UserDetService {
	@Autowired
	private UserRepository userRepository;
		
	public UserDetails loadUserByLogin(String login) throws UsernameNotFoundException {
		 User user = this.userRepository.findByLogin(login);
		 UserDet userDet = new UserDet(user); 

		 
		 return userDet ; 
	}
}
