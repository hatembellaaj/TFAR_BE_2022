package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.converter.RoleConverter;
import com.getaf.tfar.domain.dto.RoleDto;
import com.getaf.tfar.domain.entity.Role;
import com.getaf.tfar.domain.entity.User;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.RoleRepository;
import com.getaf.tfar.repository.UserRepository;
@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	
	public List<Role> listAll() {
		return roleRepository.findAll();	
	}
	
	public Role save(RoleDto roleDto) throws ResourceNotFoundException{
		
		
		Long codeuser = roleDto.getCodeUser();
		List<User> users = userRepository.findAll();
		User x = users.stream().filter(h -> h.getCode().equals(codeuser)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The user is not found.");
		}
		Role r=roleConverter.dtoToEntity(roleDto);
		roleRepository.save(r);
		return r;
	}
	
	public Role get(long id) {
		return roleRepository.findById(id).get();
	}
	
	public void delete(long id) {
		roleRepository.deleteById(id);
	}
}
