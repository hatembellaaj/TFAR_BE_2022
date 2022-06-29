package com.getaf.tfar.service;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.getaf.tfar.converter.Fiche2Converter;
import com.getaf.tfar.converter.FicheConverter;
import com.getaf.tfar.domain.dto.AndrogeneDto;
import com.getaf.tfar.domain.dto.CytogenetiqueDto;
import com.getaf.tfar.domain.dto.Fiche2Dto;
import com.getaf.tfar.domain.dto.FicheDto;
import com.getaf.tfar.domain.dto.FicheListDto;
import com.getaf.tfar.domain.entity.Androgene;
import com.getaf.tfar.domain.entity.Cytogenetique;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.domain.entity.Laboratoire;
import com.getaf.tfar.domain.entity.Patient;
import com.getaf.tfar.domain.entity.User;
import com.getaf.tfar.exception.ResourceNotFoundException;
import com.getaf.tfar.repository.AndrogeneRepository;
import com.getaf.tfar.repository.CytogenetiqueRepository;
import com.getaf.tfar.repository.FicheRepository;
import com.getaf.tfar.repository.PatientRepository;
import com.getaf.tfar.repository.UserRepository;
@Service
public class FicheService {
	Patient patient;

	Cytogenetique cytogenetique;

	Androgene androgene;

	@Autowired
	private AndrogeneRepository androgeneRepository;

	@Autowired
	private FicheRepository ficheRepository;

	@Autowired
	private CytogenetiqueRepository cytogenetiqueRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private FicheConverter ficheConverter;

	@Autowired
	private Fiche2Converter fiche2Converter;

	public List<Fiche> listAll() {
		return ficheRepository.findAll();
	}

	public List<FicheListDto> listAllFicheListDto() {
		return ficheRepository.findAllFicheListDto();
	}

	public Fiche save(Fiche2Dto fiche2Dto) throws ResourceNotFoundException {

		if ((fiche2Dto.getNdossierFiche() == null) || fiche2Dto.getDateDiagnostique() == null
				|| fiche2Dto.getDateEnregistrement() == null || fiche2Dto.getPatient().getNdPatient() == null
				|| fiche2Dto.getPatient().getNom() == null || fiche2Dto.getPatient().getPrenom() == null) {
			throw new ResourceNotFoundException(
					"The ndossierFiche or DateDiagnostique Fiche or DateEnregistrement or ndpatient or "
							+ "nom patient or prenom patient  are not found.");
		}

		Long codeUser = fiche2Dto.getCode_user();
		List<User> users = userRepository.findAll();
		User x = users.stream().filter(h -> h.getCode().equals(codeUser)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The user having code "+ codeUser +"is not found.");
		}
		FicheDto ficheDto = fiche2Converter.Fiche2DtoToDFicheDto(fiche2Dto);
		Fiche fiche = ficheConverter.toEntity(ficheDto);
		fiche.setUser(x);
		
		System.out.println("form to save  : " +  fiche.toString());
		
		Fiche savedFiche = ficheRepository.save(fiche);

		System.out.println(savedFiche + "    ffffffffffffffff");

		patient = new Patient(fiche2Dto.getPatient().getNdPatient(), fiche2Dto.getPatient().getNom(),
				fiche2Dto.getPatient().getPrenom(), fiche2Dto.getPatient().getSexe(),
				fiche2Dto.getPatient().getDateNaissance(), fiche2Dto.getPatient().getLieuNaissance(),
				fiche2Dto.getPatient().getAdresse(), fiche2Dto.getPatient().getReperes(),
				fiche2Dto.getPatient().getGouvernorat(), fiche2Dto.getPatient().getTel(),
				fiche2Dto.getPatient().getPrenomPere(), fiche2Dto.getPatient().getNomMere(),
				fiche2Dto.getPatient().getPrenomMere(), fiche2Dto.getPatient().getNomGmp(),
				fiche2Dto.getPatient().getNomGmm(), new Fiche(savedFiche.getIdFiche()));

		Patient r = patientRepository.save(patient);

		System.out.println(r + "   rrrrrrrrrrrrrrr");

		for (CytogenetiqueDto cytoDto : fiche2Dto.getCytogenetique()) {

			cytogenetique = new Cytogenetique(cytoDto.getLymphocytes(), cytoDto.getDateSang(),
					cytoDto.getAgentPortant(), cytoDto.getInstabilite(), cytoDto.getInstabilitePourcentage(),
					cytoDto.getIr(), cytoDto.getIrPourcentage(), cytoDto.getMoelle(), cytoDto.getDateMoelle(),
					cytoDto.getResultatMoelle(), new Laboratoire(cytoDto.getIdLaboratoire()),
					new Fiche(savedFiche.getIdFiche()));

			Cytogenetique c = cytogenetiqueRepository.save(cytogenetique);

		}
		
		for (AndrogeneDto androDto : fiche2Dto.getAndrogene()) {
			
			androgene = new Androgene(androDto.getMois(), androDto.getReponse(),
					new Fiche(savedFiche.getIdFiche()));

			Androgene a = androgeneRepository.save(androgene);
			
		}

		

		return savedFiche;
	}

	public Fiche get(Long id) {
		return ficheRepository.findById(id).get();
	}

	@Transactional
	public void delete(Long id) {
		patientRepository.DeletePatientByIdFiche(id);
		cytogenetiqueRepository.DeleteCytogenetiqueByIdFiche(id);
		androgeneRepository.DeleteAndrogeneByIdFiche(id);
		ficheRepository.deleteById(id);
	}

	public Fiche update(Fiche2Dto fiche2Dto) throws ResourceNotFoundException {
		if ((fiche2Dto.getNdossierFiche() == null) || fiche2Dto.getDateDiagnostique() == null
				|| fiche2Dto.getDateEnregistrement() == null || fiche2Dto.getPatient().getNdPatient() == null
				|| fiche2Dto.getPatient().getNom() == null || fiche2Dto.getPatient().getPrenom() == null) {
			throw new ResourceNotFoundException(
					"The ndossierFiche or DateDiagnostique Fiche or DateEnregistrement or ndpatient or "
							+ "nom patient or prenom patient  are not found.");
		}

		Long codeUser = fiche2Dto.getCode_user();
		List<User> users = userRepository.findAll();
		User x = users.stream().filter(h -> h.getCode().equals(codeUser)).findAny().orElse(null);
		if (x == null) {
			throw new ResourceNotFoundException("The user is not found.");
		}

		FicheDto ficheDto = fiche2Converter.Fiche2DtoToDFicheDto(fiche2Dto);
		Fiche fiche = ficheConverter.toEntity(ficheDto);
		fiche.setIdFiche(fiche2Dto.getIdFiche());
		System.out.println("begin update fiche");
		Fiche savedFiche = ficheRepository.save(fiche);

		System.out.println("end update fiche");

		patient = new Patient(fiche2Dto.getPatient().getIdPatient(), fiche2Dto.getPatient().getNdPatient(),
				fiche2Dto.getPatient().getNom(), fiche2Dto.getPatient().getPrenom(), fiche2Dto.getPatient().getSexe(),
				fiche2Dto.getPatient().getDateNaissance(), fiche2Dto.getPatient().getLieuNaissance(),
				fiche2Dto.getPatient().getAdresse(), fiche2Dto.getPatient().getReperes(),
				fiche2Dto.getPatient().getGouvernorat(), fiche2Dto.getPatient().getTel(),
				fiche2Dto.getPatient().getPrenomPere(), fiche2Dto.getPatient().getNomMere(),
				fiche2Dto.getPatient().getPrenomMere(), fiche2Dto.getPatient().getNomGmp(),
				fiche2Dto.getPatient().getNomGmm(), new Fiche(savedFiche.getIdFiche()));
		System.out.println("begin update patient");
		Patient r = patientRepository.save(patient);
		System.out.println("end update patient");

		// System.out.println("eeeeeeeeeeeeeee"+fiche2Dto.getCytogenetique().getNetudeCyto());

		for (CytogenetiqueDto cytoDto : fiche2Dto.getCytogenetique()) {

			cytogenetique = new Cytogenetique(cytoDto.getNetudeCyto(),cytoDto.getLymphocytes(), cytoDto.getDateSang(),
					cytoDto.getAgentPortant(), cytoDto.getInstabilite(), cytoDto.getInstabilitePourcentage(),
					cytoDto.getIr(), cytoDto.getIrPourcentage(), cytoDto.getMoelle(), cytoDto.getDateMoelle(),
					cytoDto.getResultatMoelle(), new Laboratoire(cytoDto.getIdLaboratoire()),
					new Fiche(savedFiche.getIdFiche()));

			Cytogenetique c = cytogenetiqueRepository.save(cytogenetique);

		}
		
		for (AndrogeneDto androDto : fiche2Dto.getAndrogene()) {
			
			androgene = new Androgene(androDto.getId(), androDto.getMois(),
					androDto.getReponse(), new Fiche(savedFiche.getIdFiche()));

			System.out.println("begin update andro");
			Androgene a = androgeneRepository.save(androgene);
			System.out.println("end update andro");
			
		}

		

		return savedFiche;

	}
}
