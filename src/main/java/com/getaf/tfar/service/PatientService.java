package com.getaf.tfar.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaf.tfar.converter.PatientConverter;
import com.getaf.tfar.domain.dto.PatientDto;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.domain.entity.Patient;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.FicheRepository;
import com.getaf.tfar.repository.PatientRepository;
@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientConverter patientConverter;
	
	@Autowired
	private FicheRepository ficheRepository;

	public List<Patient> listAll() {
		return patientRepository.findAll();
	}

	public Patient save(PatientDto patientDto) throws ResourceNotFoundException {
		Long idFiche = patientDto.getIdFiche();
		List<Fiche> fiches = ficheRepository.findAll();
		Fiche x = fiches.stream().filter(h -> h.getIdFiche().equals(idFiche)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The fiche is not found.");
		}
		Patient patient = patientConverter.dtoToEntity(patientDto);
		patientRepository.save(patient);
		return patient;
	}

	public Patient get(Long id) {
		return patientRepository.findById(id).get();
	}

	public void delete(Long id) {
		patientRepository.deleteById(id);
	}

}
