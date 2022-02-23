package com.getaf.tfar.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.getaf.tfar.domain.dto.PatientDto;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.domain.entity.Patient;
@Component
public class PatientConverter {
	public PatientDto entityToDto(Patient patient) {

		PatientDto map = new PatientDto(patient.getIdPatient(),patient.getNdPatient(),patient.getNom(),patient.getPrenom(),
				patient.getSexe(),patient.getDateNaissance(),patient.getLieuNaissance(),
				patient.getAdresse(),patient.getReperes(),patient.getGouvernorat(),patient.getTel(),
				patient.getPrenomPere(),patient.getNomMere(),patient.getPrenomMere(),
				patient.getNomGmp(),patient.getNomGmm(),patient.getFiche().getIdFiche());
		return map;
	}

	public List<PatientDto> entityToDto(List<Patient> patient) {

		return patient.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Patient dtoToEntity(PatientDto patientDto) {

		Patient map = new Patient(patientDto.getIdPatient(),patientDto.getNdPatient(),patientDto.getNom(),patientDto.getPrenom(),
				patientDto.getSexe(),patientDto.getDateNaissance(),patientDto.getLieuNaissance(),
				patientDto.getAdresse(),patientDto.getReperes(),patientDto.getGouvernorat(),patientDto.getTel(),
				patientDto.getPrenomPere(),patientDto.getNomMere(),patientDto.getPrenomMere(),
				patientDto.getNomGmp(),patientDto.getNomGmm(),new Fiche(patientDto.getIdFiche()));

		return map;
	}

	public List<Patient> dtoToEntity(List<PatientDto> patientDto) {

		return patientDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
}
