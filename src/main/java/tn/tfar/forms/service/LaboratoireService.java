package tn.tfar.forms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.domain.entity.Laboratoire;
import tn.tfar.forms.repository.LaboratoireRepository;
@Service
public class LaboratoireService {
	@Autowired
	private LaboratoireRepository laboratoireRepository;
	
	
	public List<Laboratoire> listAll() {
		return laboratoireRepository.findAll();	
	}
	
	public Laboratoire save(Laboratoire laboratoire) {
		laboratoireRepository.save(laboratoire);
		return laboratoire;
	}
	
	public Laboratoire get(long id) {
		return laboratoireRepository.findById(id).get();
	}
	
	public void delete(long id) {
		laboratoireRepository.deleteById(id);
	}

}
