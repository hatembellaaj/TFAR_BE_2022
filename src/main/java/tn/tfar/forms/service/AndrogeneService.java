package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.converter.AndrogeneConverter;
import tn.tfar.forms.domain.dto.AndrogeneDto;
import tn.tfar.forms.domain.entity.Androgene;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.exception.ResourceNotFoundException;
import tn.tfar.forms.repository.AndrogeneRepository;
import tn.tfar.forms.repository.FicheRepository;
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
