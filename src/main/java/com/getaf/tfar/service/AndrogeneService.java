package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.converter.AndrogeneConverter;
import com.getaf.tfar.domain.dto.AndrogeneDto;
import com.getaf.tfar.domain.entity.Androgene;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.AndrogeneRepository;
import com.getaf.tfar.repository.FicheRepository;
@Service
public class AndrogeneService {
	@Autowired
	private AndrogeneRepository androgeneRepository;
	
	@Autowired
	private AndrogeneConverter androgeneConverter;
	
	@Autowired
	private FicheRepository ficheRepository;
	
	
	public List<Androgene> listAll() {
		return androgeneRepository.findAll();	
	}
	
	public Androgene save(AndrogeneDto androgeneDto) throws ResourceNotFoundException{
		
		Long idFiche = androgeneDto.getIdFiche();
		List<Fiche> fiches =ficheRepository.findAll();
		Fiche x = fiches.stream().filter(h -> h.getIdFiche().equals(idFiche)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The fiche is not found.");
		}
		
		Androgene androgene = androgeneConverter.dtoToEntity(androgeneDto);
		androgeneRepository.save(androgene);
		return androgene;
	}
	
	public Androgene get(long id) {
		return androgeneRepository.findById(id).get();
	}
	
	public void delete(long id) {
		androgeneRepository.deleteById(id);
	}

}
