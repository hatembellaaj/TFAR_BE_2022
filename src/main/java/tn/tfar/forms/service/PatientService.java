package tn.tfar.forms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tfar.forms.converter.PatientConverter;
import tn.tfar.forms.domain.dto.PatientDto;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.domain.entity.Patient;
import tn.tfar.forms.exception.ResourceNotFoundException;
import tn.tfar.forms.repository.FicheRepository;
import tn.tfar.forms.repository.PatientRepository;

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
