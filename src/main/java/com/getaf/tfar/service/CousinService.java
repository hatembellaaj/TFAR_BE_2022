package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.converter.CousinConverter;
import com.getaf.tfar.domain.dto.CousinDto;
import com.getaf.tfar.domain.entity.Cousin;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.CousinRepository;
import com.getaf.tfar.repository.FicheRepository;

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
