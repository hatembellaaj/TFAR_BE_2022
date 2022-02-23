package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.converter.FrereConverter;
import com.getaf.tfar.domain.dto.FrereDto;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.domain.entity.Frere;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.FicheRepository;
import com.getaf.tfar.repository.FrereRepository;
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
