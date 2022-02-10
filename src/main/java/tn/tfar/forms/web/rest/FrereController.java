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
import tn.tfar.forms.converter.FrereConverter;
import tn.tfar.forms.domain.dto.FrereDto;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.domain.entity.Frere;
import tn.tfar.forms.service.FrereService;

@RestController
@RequestMapping("/api/freres")
public class FrereController {
	@Autowired
	private FrereService frereService;
	
	@Autowired
	private FrereConverter frereConverter;

	// get all freresDto
	@GetMapping("/findAll")
	public List<FrereDto> getAllFreres() {
		List<Frere> findAll = frereService.listAll();
		return frereConverter.entityToDto(findAll);
	}

	// get frereDto by frereId
	@GetMapping("/find/{frereId}")
	public FrereDto getCousinDtoById(@PathVariable(value = "frereId") long id) {
		Frere frere = frereService.get(id);
		return frereConverter.entityToDto(frere);
	}

	// create frereDto 
			@PostMapping("/save")
			public FrereDto save(@RequestBody FrereDto frereDto)  throws Exception {
				return frereConverter.entityToDto(frereService.save(frereDto));
			}

			// update frereDto 
			@PutMapping("/save/{id}")
			public FrereDto updateFrereDto(@RequestBody FrereDto frereDto, @PathVariable("id") long id)  throws Exception {
				Frere existingfrere = frereService.get(id);
				existingfrere.setNom(frereDto.getNom());
				existingfrere.setPrenom(frereDto.getPrenom());
				existingfrere.setAtteint(frereDto.getAtteint());
				existingfrere.setPlaceFratrie(frereDto.getPlaceFratrie());
				existingfrere.setSexe(frereDto.getSexe());
				existingfrere.setDecedes(frereDto.getDecedes());
				existingfrere.setAge(frereDto.getAge());
				existingfrere.setFiche(new Fiche(frereDto.getIdFiche()));
				FrereDto f=frereConverter.entityToDto(existingfrere);
				return frereConverter.entityToDto(frereService.save(f));
			}

			// delete frere by frereId
			@DeleteMapping("delete/{frereId}")
			public String deleteFrere(@PathVariable("frereId") long id) {
				Frere existingfrere = frereService.get(id);
				frereService.delete(id);
				return existingfrere.toString() + " is deleted";
			}
}
