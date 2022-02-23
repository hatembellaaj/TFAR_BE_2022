package com.getaf.tfar.web.rest;
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

import com.getaf.tfar.converter.OrganismeConverter;
import com.getaf.tfar.domain.dto.OrganismeDto;
import com.getaf.tfar.domain.entity.Organisme;
import com.getaf.tfar.service.OrganismeService;

@RestController
@RequestMapping("/api/organismes")

public class OrganismeController {
	@Autowired
	private OrganismeService organismeService;
	
	@Autowired
	private OrganismeConverter organismeConverter;

	// get all organismesDto
	@GetMapping("/findAll")
	public List<OrganismeDto> getAllOrganismes() {
		List<Organisme> findAll = organismeService.listAll();
		return organismeConverter.entityToDto(findAll);
	}

	// get organismeDto by code
	@GetMapping("/find/{code}")
	public OrganismeDto getOrganismeDtoById(@PathVariable(value = "code") long id) {
		Organisme organisme = organismeService.get(id);
		return organismeConverter.entityToDto(organisme);
	}

	// create organismeDto
	@PostMapping("/save")
	public OrganismeDto save(@RequestBody OrganismeDto organismeDto) {
		return organismeConverter.entityToDto(organismeService.save(organismeConverter.dtoToEntity(organismeDto)));

	}

	// update organismeDto
	@PutMapping("/save/{code}")
	public OrganismeDto updateOrganismeDto(@RequestBody OrganismeDto organismeDto, @PathVariable("code") long id) {
		Organisme existingorganisme = organismeService.get(id);
		existingorganisme.setNom(organismeDto.getNom());
		existingorganisme.setAdresse(organismeDto.getAdresse());
		existingorganisme.setTel(organismeDto.getTel());
		existingorganisme.setContact(organismeDto.getContact());
		existingorganisme.setEmail(organismeDto.getEmail());
		//existingorganisme.setType(OrganismeType.valueOf(organismeDto.getType()));
		
		existingorganisme.setType(organismeDto.getType());
		
		return organismeConverter.entityToDto(organismeService.save(existingorganisme));
	}


	// delete organismeDto by code
	@DeleteMapping("delete/{code}")
	public String deleteOrganisme(@PathVariable("code") long id) {
		Organisme existingorganisme = organismeService.get(id);
		organismeService.delete(id);
		return existingorganisme.toString() + " is deleted";
	}

}
