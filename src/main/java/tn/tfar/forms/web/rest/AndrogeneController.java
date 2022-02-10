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

import tn.tfar.forms.converter.AndrogeneConverter;
import tn.tfar.forms.domain.dto.AndrogeneDto;
import tn.tfar.forms.domain.entity.Androgene;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.service.AndrogeneService;

@RestController
@RequestMapping("/api/androgenes")
public class AndrogeneController {
	@Autowired
	private AndrogeneService androgeneService;
	
	@Autowired
	private AndrogeneConverter androgeneConverter;

	// get all androgenesDto
	@GetMapping("/findAll")
	public List<AndrogeneDto> getAllAndrogenesDto() {

		List<Androgene> findAll = androgeneService.listAll();
		return androgeneConverter.entityToDto(findAll);
	}

	// get androgeneDto by id
	@GetMapping("/find/{id}")
	public AndrogeneDto getAndrogeneDtoById(@PathVariable(value = "id") long id) {
		Androgene androgene = androgeneService.get(id);
		return androgeneConverter.entityToDto(androgene);
	}

	// create androgeneDto
	@PostMapping("/save")
	public AndrogeneDto save(@RequestBody AndrogeneDto androgeneDto)  throws Exception {
		return androgeneConverter.entityToDto(androgeneService.save(androgeneDto));
	}
	

	
	// update androgeneDto
	@PutMapping("/save/{id}")
	public AndrogeneDto updateAndrogeneDto(@RequestBody AndrogeneDto androgeneDto, @PathVariable("id") long id)  throws Exception {
		Androgene existingandrogene = androgeneService.get(id);
		existingandrogene.setMois(androgeneDto.getMois());
		existingandrogene.setReponse(androgeneDto.getReponse());
		existingandrogene.setFiche(new Fiche(androgeneDto.getIdFiche()));
		AndrogeneDto a=androgeneConverter.entityToDto(existingandrogene);
		return androgeneConverter.entityToDto(androgeneService.save(a));
	}
	
	
	// delete androgene by id
		@DeleteMapping("delete/{id}")
		public String deleteAndrogene(@PathVariable("id") long id) {
			Androgene existingandrogene = androgeneService.get(id);
			androgeneService.delete(id);
			return existingandrogene.toString() + " is deleted";
		}

}
