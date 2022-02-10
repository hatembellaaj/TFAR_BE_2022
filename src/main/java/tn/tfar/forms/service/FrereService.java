package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.converter.FrereConverter;
import tn.tfar.forms.domain.dto.FrereDto;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.domain.entity.Frere;
import tn.tfar.forms.exception.ResourceNotFoundException;
import tn.tfar.forms.repository.FicheRepository;
import tn.tfar.forms.repository.FrereRepository;
@Service
public class FrereService {
	@Autowired
	private FrereRepository frereRepository;
	
	@Autowired
	private FrereConverter frereConverter;

	@Autowired
	private FicheRepository ficheRepository;

	public List<Frere> listAll() {
		return frereRepository.findAll();
	}

public Frere save(FrereDto frereDto) throws ResourceNotFoundException {
		
		Long idFiche = frereDto.getIdFiche();
		List<Fiche> fiches =ficheRepository.findAll();
		Fiche x = fiches.stream().filter(h -> h.getIdFiche().equals(idFiche)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The fiche is not found.");
		}
		Frere frere = frereConverter.dtoToEntity(frereDto);
		frereRepository.save(frere);
		return frere;
	}

	public Frere get(long id) {
		return frereRepository.findById(id).get();
	}
	
	public void delete(long id) {
		frereRepository.deleteById(id);
	}
}
