package tn.tfar.forms.web.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.tfar.forms.converter.RoleConverter;
import tn.tfar.forms.domain.dto.RoleDto;
import tn.tfar.forms.domain.entity.Role;
import tn.tfar.forms.domain.entity.User;
import tn.tfar.forms.service.RoleService;
@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleConverter roleConverter;
	
	// get all rolesDto
	@GetMapping("/findAll")
	public List<RoleDto> getAllRoles() {
		List<Role> findAll = roleService.listAll();
		return roleConverter.entityToDto(findAll);
	}

	// get roleDto by idRole
	@GetMapping("/find/{idRole}")
	public RoleDto getRoleById(@PathVariable(value = "idRole") Long id) {
		Role role = roleService.get(id);
		return roleConverter.entityToDto(role);
	}

	// create roleDto
	@PostMapping("/save")
	public RoleDto save(@RequestBody RoleDto roleDto) throws Exception {
		return roleConverter.entityToDto(roleService.save(roleDto));
	}

	// update roleDto
	@PutMapping("/save/{idRole}")
	public RoleDto updateRoleDto(@RequestBody RoleDto roleDto, @PathVariable("idRole") Long id) throws Exception {
		Role existingrole = roleService.get(id);
		existingrole.setTitre(roleDto.getTitre());
		existingrole.setDescription(roleDto.getDescription());
		existingrole.setDeleted(roleDto.getDeleted());
		existingrole.setUser(new User(roleDto.getCodeUser()));
		RoleDto x=roleConverter.entityToDto(existingrole);
		return roleConverter.entityToDto(roleService.save(x));
	}

	// delete role by idRole
	@DeleteMapping("delete/{idRole}")
	public String deleteRole(@PathVariable("idRole") Long id) {
		Role existingrole = roleService.get(id);
		roleService.delete(id);
		return existingrole.toString() + " is deleted";
	}
}
