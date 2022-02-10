package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.domain.entity.Organisme;
import tn.tfar.forms.repository.OrganismeRepository;

@Service
public class OrganismeService {
	@Autowired
	private OrganismeRepository organismeRepository;
	
	
	public List<Organisme> listAll() {
		return organismeRepository.findAll();	
	}
	
	public Organisme save(Organisme organisme) {
		organismeRepository.save(organisme);
		return organisme;
	}
	
	public Organisme get(long id) {
		return organismeRepository.findById(id).get();
	}
	
	public void delete(long id) {
		organismeRepository.deleteById(id);
	}
}
