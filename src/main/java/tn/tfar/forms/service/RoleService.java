package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.converter.RoleConverter;
import tn.tfar.forms.domain.dto.RoleDto;
import tn.tfar.forms.domain.entity.Role;
import tn.tfar.forms.domain.entity.User;
import tn.tfar.forms.exception.ResourceNotFoundException;
import tn.tfar.forms.repository.RoleRepository;
import tn.tfar.forms.repository.UserRepository;
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
