package com.getaf.tfar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.domain.entity.Departement;
import com.getaf.tfar.repository.DepartementRepository;
@Service
public class DepartementService {
	@Autowired
	private DepartementRepository departementRepository;
	
	
	public List<Departement> listAll() {
		return departementRepository.findAll();	
	}
	
	public Departement save(Departement departement) {
		departementRepository.save(departement);
		return departement;
	}
	
	public Departement get(long id) {
		return departementRepository.findById(id).get();
	}
	
	public void delete(long id) {
		departementRepository.deleteById(id);
	}
}
