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

import com.getaf.tfar.converter.LaboratoireConverter;
import com.getaf.tfar.domain.dto.LaboratoireDto;
import com.getaf.tfar.domain.entity.Laboratoire;
import com.getaf.tfar.service.LaboratoireService;

@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {
	@Autowired
	private LaboratoireService laboratoireService;
	
	@Autowired
	private LaboratoireConverter laboratoireConverter;

	// get all laboratoiresDto
	@GetMapping("/findAll")
	public List<LaboratoireDto> getAllLaboratoiresDto() {
		List<Laboratoire> findAll = laboratoireService.listAll();
		return laboratoireConverter.entityToDto(findAll);
	}

	// get laboratoireDto by id
	@GetMapping("/find/{id}")
	public LaboratoireDto getLaboratoireDtoById(@PathVariable(value = "id") long id) {
		Laboratoire laboratoire = laboratoireService.get(id);
		return  laboratoireConverter.entityToDto(laboratoire);
	}

	// create laboratoireDto
	@PostMapping("/save")
	public LaboratoireDto save(@RequestBody LaboratoireDto laboratoireDto) {
		return laboratoireConverter.entityToDto(laboratoireService.save(laboratoireConverter.dtoToEntity(laboratoireDto)));
	}
	

	
	// update laboratoireDto
	@PutMapping("/save/{id}")
	public LaboratoireDto updateLaboratoireDto(@RequestBody LaboratoireDto laboratoireDto, @PathVariable("id") long id) {
		Laboratoire existinglaboratoire = laboratoireService.get(id);
		existinglaboratoire.setNom(laboratoireDto.getNom());
		return laboratoireConverter.entityToDto(laboratoireService.save(existinglaboratoire));
	}
	
	
	// delete laboratoire by id
		@DeleteMapping("delete/{id}")
		public String deleteLaboratoire(@PathVariable("id") long id) {
			Laboratoire existinglaboratoire = laboratoireService.get(id);
			laboratoireService.delete(id);
			return existinglaboratoire.toString()+ " is deleted";
		}

}
