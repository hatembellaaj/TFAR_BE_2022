package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.converter.CytogenetiqueConverter;
import com.getaf.tfar.domain.dto.CytogenetiqueDto;
import com.getaf.tfar.domain.entity.Cytogenetique;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.domain.entity.Laboratoire;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.CytogenetiqueRepository;
import com.getaf.tfar.repository.FicheRepository;
import com.getaf.tfar.repository.LaboratoireRepository;
@Service
public class CytogenetiqueService {
	@Autowired
	private CytogenetiqueRepository cytogenetiqueRepository;
	
	@Autowired
	private CytogenetiqueConverter cytogenetiqueConverter;
	
	@Autowired
	private LaboratoireRepository laboratoireRepository;
	
	@Autowired
	private FicheRepository ficheRepository;
	
	
	public List<Cytogenetique> listAll() {
		return cytogenetiqueRepository.findAll();	
	}
	
	public Cytogenetique save(CytogenetiqueDto cytogenetiqueDto)throws ResourceNotFoundException {
		
		Long idLaboratoire = cytogenetiqueDto.getIdLaboratoire();
		List<Laboratoire> laboratoires = laboratoireRepository.findAll();
		Laboratoire x = laboratoires.stream().filter(h -> h.getId().equals(idLaboratoire)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The laboratoire is not found.");
		}

		Long idFiche = cytogenetiqueDto.getIdFiche();
		List<Fiche> fiches = ficheRepository.findAll();
		Fiche y = fiches.stream().filter(h -> h.getIdFiche().equals(idFiche)).findAny().orElse(null);
		if (y == null) {
			throw new ResourceNotFoundException("The fiche is not found.");
		}
		
		Cytogenetique cytogenetique = cytogenetiqueConverter.dtoToEntity(cytogenetiqueDto);
		cytogenetiqueRepository.save(cytogenetique);
		return cytogenetique;
	}
	
	public Cytogenetique get(long id) {
		return cytogenetiqueRepository.findById(id).get();
	}
	
	public void delete(long id) {
		cytogenetiqueRepository.deleteById(id);
	}
}
