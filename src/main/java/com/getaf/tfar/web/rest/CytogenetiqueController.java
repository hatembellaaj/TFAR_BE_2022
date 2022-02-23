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

import com.getaf.tfar.converter.CytogenetiqueConverter;
import com.getaf.tfar.domain.dto.CytogenetiqueDto;
import com.getaf.tfar.domain.entity.Cytogenetique;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.domain.entity.Laboratoire;
import com.getaf.tfar.service.CytogenetiqueService;
@RestController
@RequestMapping("/api/cytogenetiques")
public class CytogenetiqueController {
	@Autowired
	private CytogenetiqueService cytogenetiqueService;
	
	@Autowired
	private CytogenetiqueConverter cytogenetiqueConverter;

	// get all cytogenetiquesDto
	@GetMapping("/findAll")
	public List<CytogenetiqueDto> getAllCytogenetiquesDto() {
		List<Cytogenetique> findAll = cytogenetiqueService.listAll();
		return cytogenetiqueConverter.entityToDto(findAll);
	}

	// get cytogenetiqueDto by nEtudeCyto
	@GetMapping("/find/{nEtudeCyto}")
	public CytogenetiqueDto getUserById(@PathVariable(value = "nEtudeCyto") Long id) {
		Cytogenetique cytogenetique = cytogenetiqueService.get(id);
		return cytogenetiqueConverter.entityToDto(cytogenetique);
	}

	// create cytogenetiqueDto
	@PostMapping("/save")
	public CytogenetiqueDto save(@RequestBody CytogenetiqueDto cytogenetiqueDto) throws Exception {
		return cytogenetiqueConverter.entityToDto(cytogenetiqueService.save(cytogenetiqueDto));
	}

	// update cytogenetiqueDto
	@PutMapping("/save/{nEtudeCyto}")
	public CytogenetiqueDto updateCytogenetiqueDto(@RequestBody CytogenetiqueDto cytogenetiqueDto,
			@PathVariable("nEtudeCyto") Long id) throws Exception {
		Cytogenetique existingcytogenetique = cytogenetiqueService.get(id);
		existingcytogenetique.setLymphocytes(cytogenetiqueDto.getLymphocytes());
		existingcytogenetique.setDateSang(cytogenetiqueDto.getDateSang());
		existingcytogenetique.setAgentPortant(cytogenetiqueDto.getAgentPortant());
		existingcytogenetique.setInstabilite(cytogenetiqueDto.getInstabilite());
		existingcytogenetique.setInstabilitePourcentage(cytogenetiqueDto.getInstabilitePourcentage());
		existingcytogenetique.setIr(cytogenetiqueDto.getIr());
		existingcytogenetique.setIrPourcentage(cytogenetiqueDto.getIrPourcentage());
		existingcytogenetique.setMoelle(cytogenetiqueDto.getMoelle());
		existingcytogenetique.setDateMoelle(cytogenetiqueDto.getDateMoelle());
		existingcytogenetique.setResultatMoelle(cytogenetiqueDto.getResultatMoelle());
		existingcytogenetique.setLaboratoire(new Laboratoire(cytogenetiqueDto.getIdLaboratoire()));
		existingcytogenetique.setFiche(new Fiche(cytogenetiqueDto.getIdFiche()));
		return cytogenetiqueConverter.entityToDto(cytogenetiqueService.save(cytogenetiqueConverter.entityToDto(existingcytogenetique)));
	}

	// delete cytogenetique by nEtudeCyto
	@DeleteMapping("delete/{nEtudeCyto}")
	public String deleteCytogenetique(@PathVariable("nEtudeCyto") Long id) {
		Cytogenetique existingcytogenetique = cytogenetiqueService.get(id);
		cytogenetiqueService.delete(id);
		return existingcytogenetique.toString() +  " is deleted";
	}


}
