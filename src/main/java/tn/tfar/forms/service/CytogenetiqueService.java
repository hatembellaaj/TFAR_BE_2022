package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.converter.CytogenetiqueConverter;
import tn.tfar.forms.domain.dto.CytogenetiqueDto;
import tn.tfar.forms.domain.entity.Cytogenetique;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.domain.entity.Laboratoire;
import tn.tfar.forms.exception.ResourceNotFoundException;
import tn.tfar.forms.repository.CytogenetiqueRepository;
import tn.tfar.forms.repository.FicheRepository;
import tn.tfar.forms.repository.LaboratoireRepository;

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
