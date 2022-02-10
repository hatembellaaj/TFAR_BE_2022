package tn.tfar.forms.converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.tfar.forms.domain.dto.AndrogeneDto;
import tn.tfar.forms.domain.dto.CytogenetiqueDto;
import tn.tfar.forms.domain.dto.Fiche2Dto;
import tn.tfar.forms.domain.dto.FicheDto;
import tn.tfar.forms.domain.dto.PatientDto;
import tn.tfar.forms.repository.AndrogeneRepository;
import tn.tfar.forms.repository.CytogenetiqueRepository;
import tn.tfar.forms.repository.PatientRepository;
import java.util.List;

@Component
public class Fiche2Converter {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientConverter patientConverter;
	
	@Autowired
	private AndrogeneRepository androgeneRepository;
	
	@Autowired
	private AndrogeneConverter androgeneConverter;
	
	@Autowired
	private CytogenetiqueRepository cytogenetiqueRepository;
	
	@Autowired
	private CytogenetiqueConverter cytogenetiqueConverter;

	public FicheDto Fiche2DtoToDFicheDto(Fiche2Dto fiche2Dto) {

		ModelMapper mapper = new ModelMapper();
		FicheDto map = mapper.map(fiche2Dto, FicheDto.class);
		return map;
	}
	
	
	public Fiche2Dto FicheDtoToDFiche2Dto(FicheDto ficheDto) {
		
		Long idOfFiche=ficheDto.getIdFiche();
		PatientDto patientDto=patientConverter.entityToDto(patientRepository.findPatientByIdFiche(idOfFiche));
		List<AndrogeneDto> androgeneDto=androgeneConverter.entityToDto(androgeneRepository.findAndrogeneByIdFiche(idOfFiche));
		List<CytogenetiqueDto> cytogenetiqueDto=cytogenetiqueConverter.entityToDto(cytogenetiqueRepository.findCytogenetiqueByIdFiche(idOfFiche));
		ModelMapper mapper = new ModelMapper();
		Fiche2Dto map = mapper.map(ficheDto, Fiche2Dto.class);
		map.setPatient(patientDto);
		map.setAndrogene(androgeneDto);
		map.setCytogenetique(cytogenetiqueDto);
		return map;
	}
}
