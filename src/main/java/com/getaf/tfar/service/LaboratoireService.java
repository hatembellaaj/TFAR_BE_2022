package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.domain.entity.Laboratoire;
import com.getaf.tfar.repository.LaboratoireRepository;
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
