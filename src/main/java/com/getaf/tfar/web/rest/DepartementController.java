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

import com.getaf.tfar.converter.DepartementConverter;
import com.getaf.tfar.domain.dto.DepartementDto;
import com.getaf.tfar.domain.entity.Departement;
import com.getaf.tfar.service.DepartementService;
@RestController
@RequestMapping("/api/departements")
public class DepartementController {
	@Autowired
	private DepartementService departementService;
	
	@Autowired
	private DepartementConverter departementConverter;

	// get all departementsDto
	@GetMapping("/findAll")
	public List<DepartementDto> getAllDepartementsDto() {

		List<Departement> findAll = departementService.listAll();
		return departementConverter.entityToDto(findAll);
	}

	// get departementDto by code
	@GetMapping("/find/{code}")
	public DepartementDto getDepartementDtoById(@PathVariable(value = "code") long id) {
		Departement departement = departementService.get(id);
		return departementConverter.entityToDto(departement);
	}

	// create departementDto
	@PostMapping("/save")
	public DepartementDto save(@RequestBody DepartementDto departementDto) {
		return departementConverter.entityToDto(departementService.save(departementConverter.dtoToEntity(departementDto)));
	}
	

	
	// update departementDto
	@PutMapping("/save/{code}")
	public DepartementDto updateDepartementDto(@RequestBody DepartementDto departementDto, @PathVariable("code") long id) {
		Departement existingdepartement = departementService.get(id);
		existingdepartement.setNom(departementDto.getNom());
		return departementConverter.entityToDto(departementService.save(existingdepartement));
	}
	
	
	// delete departement by code
		@DeleteMapping("delete/{code}")
		public String deleteDepartement(@PathVariable("code") long id) {
			Departement existingdepartement = departementService.get(id);
			departementService.delete(id);
			return existingdepartement.toString() + " is deleted";
		}
}
