package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.converter.CousinConverter;
import tn.tfar.forms.domain.dto.CousinDto;
import tn.tfar.forms.domain.entity.Cousin;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.exception.ResourceNotFoundException;
import tn.tfar.forms.repository.CousinRepository;
import tn.tfar.forms.repository.FicheRepository;

@Service
public class CousinService {
	@Autowired
	private CousinRepository cousinRepository;
	
	@Autowired
	private CousinConverter cousinConverter;

	@Autowired
	private FicheRepository ficheRepository;
	
	public List<Cousin> listAll() {
		return cousinRepository.findAll();
	}

	public Cousin save(CousinDto cousinDto) throws ResourceNotFoundException {
		
		
		Long idFiche = cousinDto.getIdFiche();
		List<Fiche> fiches =ficheRepository.findAll();
		Fiche x = fiches.stream().filter(h -> h.getIdFiche().equals(idFiche)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The fiche is not found.");
		}
		Cousin cousin = cousinConverter.dtoToEntity(cousinDto);
		cousinRepository.save(cousin);
		return cousin;
	}

	public Cousin get(long id) {
		return cousinRepository.findById(id).get();
	}
	
	public void delete(long id) {
		cousinRepository.deleteById(id);
	}
}
