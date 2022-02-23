package com.getaf.tfar.web.rest;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getaf.tfar.converter.Fiche2Converter;
import com.getaf.tfar.converter.FicheConverter;
import com.getaf.tfar.domain.dto.Fiche2Dto;
import com.getaf.tfar.domain.dto.FicheDto;
import com.getaf.tfar.domain.dto.FicheListDto;
import com.getaf.tfar.domain.entity.Fiche;
import com.getaf.tfar.repository.FicheRepository;
import com.getaf.tfar.service.FicheService;

@RestController
@RequestMapping("/api/fiches")
public class FicheController {
	@Autowired
	private FicheService ficheService;
	
	@Autowired
	private FicheRepository ficheRepository;
	
	@Autowired
	private FicheConverter ficheConverter;
	
	@Autowired
	private Fiche2Converter fiche2Converter;

	// get all fiches
	@GetMapping("/findAll")
	public List<FicheDto> getAllFiches() {
		List<Fiche> findAll = ficheService.listAll();
		return ficheConverter.toDto(findAll);
	}
	
	@GetMapping("/findAllFicheListDto")
	public List<FicheListDto> getAllFichesListDto() {
		List<FicheListDto> findAllListDto = ficheService.listAllFicheListDto();
		return findAllListDto;
	}

	// get fiche by nDossierFiche
		@GetMapping("/find/{idFiche}")
		public Fiche2Dto getFicheDtoById(@PathVariable(value = "idFiche") Long id) {
			Fiche fiche = ficheService.get(id);
			System.out.println("aaaaaaaaaaaaa "+ficheService.get(id)+"   ddddddddddd");
			return fiche2Converter.FicheDtoToDFiche2Dto( ficheConverter.toDto(fiche));
		}

		// create ficheDto
		@PostMapping("/save") 
		public Fiche2Dto save(@RequestBody Fiche2Dto fiche2Dto)  throws Exception{
			return fiche2Converter.FicheDtoToDFiche2Dto(ficheConverter.toDto(ficheService.save(fiche2Dto)));
		}
		

		
		// update ficheDto
		@PutMapping("/save/{idFiche}")
		public Fiche2Dto updateFiche(@RequestBody Fiche2Dto fiche2Dto,@PathVariable(value = "idFiche") Long id) throws Exception{
			 return fiche2Converter.FicheDtoToDFiche2Dto(ficheConverter.toDto(ficheService.update(fiche2Dto)));
		}
		/*
		// update ficheDto
				@PutMapping("/save/{idFiche}")
				public FicheDto updateFiche(@RequestBody FicheListDto ficheListDto, @PathVariable("idFiche") Long id) throws Exception{
					Fiche fiche=ficheService.get(id);
					FicheListDto ficheupdate = ficheListDto;
					ficheupdate.setIdFiche(id);
					return ficheConverter.toDto(ficheService.save(ficheupdate));
				}*/
		
		
		// delete fiche by nDossierFiche
			@DeleteMapping("delete/{idFiche}")
			public String deleteFiche(@PathVariable("idFiche") Long id) {
				Fiche existingfiche = ficheService.get(id);
				ficheService.delete(id);
				return existingfiche.toString() + " is deleted";
			}
			
			@GetMapping("/statuiv")
			public HashMap<String, Long> getnbreUIV() {
				
				Long nbreFaite=ficheRepository.countuivFaite();
				Long nbreNonFaite=ficheRepository.countuivNonFaite();
				Long nbreMoin1=ficheRepository.countuivMoin1();
				Long nbreNP=ficheRepository.countuivNP();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Faite",  nbreFaite);
				map.put("Nonfaite", nbreNonFaite );
				map.put("Moin1",  nbreMoin1);
				map.put("np",  nbreNP);
				
				return map;
			}
			
			@GetMapping("/statcellularite")
			public HashMap<String, Long> getnbreCellularite() {
				
				Long nbreNormale=ficheRepository.countcellulariteNormale();
				Long nbreDiminuee=ficheRepository.countcellulariteDiminuee();
				Long nbreMoin1=ficheRepository.countcellulariteMoin1();
				Long nbreNP=ficheRepository.countcellulariteNP();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Normale",  nbreNormale);
				map.put("Diminuee", nbreDiminuee );
				map.put("Moin1",  nbreMoin1);
				map.put("np",  nbreNP);
				
				return map;
			}
			
			@GetMapping("/statmorphologie")
			public HashMap<String, Long> getnbreMorphologie() {
				
				Long nbreNormale=ficheRepository.countmorphologieNormale();
				Long nbreDysplasie=ficheRepository.countmorphologieDysplasie();
				Long nbreMoin1=ficheRepository.countmorphologieMoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Normale",  nbreNormale);
				map.put("Dysplasie", nbreDysplasie );
				map.put("Moin1",  nbreMoin1);
				
				return map;
			}
}
