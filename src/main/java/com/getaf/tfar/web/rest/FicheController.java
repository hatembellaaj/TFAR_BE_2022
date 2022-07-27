package com.getaf.tfar.web.rest;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
			
			
			@GetMapping("/statsyndromeanemique")
			public HashMap<String, Long> getnbreSyndromeAnemique() {
				
				Long nbreOui=ficheRepository.countsyndromeAnemiqueOui();
				Long nbreNon=ficheRepository.countsyndromeAnemiqueNon();
				Long nbreNP=ficheRepository.countsyndromeAnemiqueNP();
				Long nbremoin1=ficheRepository.countsyndromeAnemiquemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			
			@GetMapping("/statsyndromehemorragique")
			public HashMap<String, Long> getnbreSyndromeHemorragique() {
				
				Long nbreOui=ficheRepository.countsyndromeHemOui();
				Long nbreNon=ficheRepository.countsyndromeHemNon();
				Long nbreNP=ficheRepository.countsyndromeHemNP();
				Long nbremoin1=ficheRepository.countsyndromeHemmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			
			@GetMapping("/statsyndromeinfectieux")
			public HashMap<String, Long> getnbreSyndromeInfectieux() {
				
				Long nbreOui=ficheRepository.countsyndromeInfOui();
				Long nbreNon=ficheRepository.countsyndromeInfNon();
				Long nbreNP=ficheRepository.countsyndromeInfNP();
				Long nbremoin1=ficheRepository.countsyndromeInfmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			
			@GetMapping("/statcancer")
			public HashMap<String, Long> getnbreCancer() {
				
				Long nbreOui=ficheRepository.countcancerOui();
				Long nbreNon=ficheRepository.countcancerNon();
				Long nbreNP=ficheRepository.countcancerNP();
				Long nbremoin1=ficheRepository.countcancermoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			
			@GetMapping("/stathypotrophie")
			public HashMap<String, Long> getnbreHypotrophie() {
				
				Long nbreOui=ficheRepository.counthypotrophieOui();
				Long nbreNon=ficheRepository.counthypotrophieNon();
				Long nbreNP=ficheRepository.counthypotrophieNP();
				Long nbremoin1=ficheRepository.counthypotrophiemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

		
			
			
			@GetMapping("/stattroublecroissance")
			public HashMap<String, Long> getnbreTroublecroissance() {
				
				Long nbreOui=ficheRepository.counttroubleCroiOui();
				Long nbreNon=ficheRepository.counttroubleCroiNon();
				Long nbreNP=ficheRepository.counttroubleCroiNP();
				Long nbremoin1=ficheRepository.counttroubleCroimoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			
			@GetMapping("/statatteintecut")
			public HashMap<String, Long> getnbreAtteintecut() {
				
				Long nbreOui=ficheRepository.countatteinteCutOui();
				Long nbreNon=ficheRepository.countatteinteCutNon();
				Long nbreNP=ficheRepository.countatteinteCutNP();
				Long nbremoin1=ficheRepository.countatteinteCutmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			
			@GetMapping("/stathyperpigmentation")
			public HashMap<String, Long> getnbreHyperpig() {
				
				Long nbreOui=ficheRepository.counthyperPigOui();
				Long nbreNon=ficheRepository.counthyperPigNon();
				Long nbreNP=ficheRepository.counthyperPigNP();
				Long nbremoin1=ficheRepository.counthyperPigmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			
			@GetMapping("/statatteintetete")
			public HashMap<String, Long> getnbreAtteintetete() {
				
				Long nbreOui=ficheRepository.countatteinteTeteOui();
				Long nbreNon=ficheRepository.countatteinteTeteNon();
				Long nbreNP=ficheRepository.countatteinteTeteNP();
				Long nbremoin1=ficheRepository.countatteinteTetemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			
			@GetMapping("/statatteinteoss")
			public HashMap<String, Long> getnbreAtteinteoss() {
				
				Long nbreOui=ficheRepository.countatteinteOssOui();
				Long nbreNon=ficheRepository.countatteinteOssNon();
				Long nbreNP=ficheRepository.countatteinteOssNP();
				Long nbremoin1=ficheRepository.countatteinteOssmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			
			@GetMapping("/statanomaliedig")
			public HashMap<String, Long> getnbreAnomaliedig() {
				
				Long nbreOui=ficheRepository.countanomDigOui();
				Long nbreNon=ficheRepository.countanomDigNon();
				Long nbreNP=ficheRepository.countanomDigNP();
				Long nbremoin1=ficheRepository.countanomDigmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}


			@GetMapping("/statmalformationuro")
			public HashMap<String, Long> getnbreMalformationuro() {
				
				Long nbreOui=ficheRepository.countmalUroOui();
				Long nbreNon=ficheRepository.countmalUroNon();
				Long nbreNP=ficheRepository.countmalUroNP();
				Long nbremoin1=ficheRepository.countmalUromoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}


			@GetMapping("/statmicrocephalie")
			public HashMap<String, Long> getnbreMicrocephalie() {
				
				Long nbreOui=ficheRepository.countmicrocephalieOui();
				Long nbreNon=ficheRepository.countmicrocephalieNon();
				Long nbreNP=ficheRepository.countmicrocephalieNP();
				Long nbremoin1=ficheRepository.countmicrocephaliemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			
			@GetMapping("/statmicrophtalmie")
			public HashMap<String, Long> getnbreMicrophtalmie() {
				
				Long nbreOui=ficheRepository.countmicrophtalmieOui();
				Long nbreNon=ficheRepository.countmicrophtalmieNon();
				Long nbreNP=ficheRepository.countmicrophtalmieNP();
				Long nbremoin1=ficheRepository.countmicrophtalmiemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statecho")
			public HashMap<String, Long> getnbreEcho() {
				
				Long nbreFaite=ficheRepository.countechoFaite();
				Long nbreNonfaite=ficheRepository.countechoNonfaite();
				Long nbreMoin1=ficheRepository.countechoMoin1();
				Long nbreNP=ficheRepository.countechoNP();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Faite",  nbreFaite);
				map.put("Nonfaite", nbreNonfaite );
				map.put("Moin1",  nbreMoin1);
				map.put("NP",  nbreNP);

				return map;
			}

			@GetMapping("/statdecouvertefortuite")
			public HashMap<String, Long> getnbreDecouverteFort() {
				
				Long nbreOui=ficheRepository.countdecouverteFortOui();
				Long nbreNon=ficheRepository.countdecouverteFortNon();
				Long nbreNP=ficheRepository.countdecouverteFortNP();
				Long nbremoin1=ficheRepository.countdecouverteFortmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statenquetefam")
			public HashMap<String, Long> getnbreEnqueteFam() {
				
				Long nbreOui=ficheRepository.countenqueteFamOui();
				Long nbreNon=ficheRepository.countenqueteFamNon();
				Long nbreNP=ficheRepository.countenqueteFamNP();
				Long nbremoin1=ficheRepository.countenqueteFammoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/stattachecafe")
			public HashMap<String, Long> getnbreTacheCaf() {
				
				Long nbreOui=ficheRepository.counttacheCafOui();
				Long nbreNon=ficheRepository.counttacheCafNon();
				Long nbreNP=ficheRepository.counttacheCafNP();
				Long nbremoin1=ficheRepository.counttacheCafmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/statfacietriang")
			public HashMap<String, Long> getnbreFacieTrig() {
				
				Long nbreOui=ficheRepository.countfacieTrigOui();
				Long nbreNon=ficheRepository.countfacieTrigNon();
				Long nbreNP=ficheRepository.countfacieTrigNP();
				Long nbremoin1=ficheRepository.countfacieTrigmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/stattraitsfins")
			public HashMap<String, Long> getnbreTraitsFin() {
				
				Long nbreOui=ficheRepository.counttraitsFinOui();
				Long nbreNon=ficheRepository.counttraitsFinNon();
				Long nbreNP=ficheRepository.counttraitsFinNP();
				Long nbremoin1=ficheRepository.counttraitsFinmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statreinectopique")
			public HashMap<String, Long> getnbreReinEctop() {
				
				Long nbreOui=ficheRepository.countreinEctopOui();
				Long nbreNon=ficheRepository.countreinEctopNon();
				Long nbreNP=ficheRepository.countreinEctopNP();
				Long nbremoin1=ficheRepository.countreinEctopmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statreinfercheval")
			public HashMap<String, Long> getnbreReinFerChev() {
				
				Long nbreOui=ficheRepository.countreinFerChevOui();
				Long nbreNon=ficheRepository.countreinFerChevNon();
				Long nbreNP=ficheRepository.countreinFerChevNP();
				Long nbremoin1=ficheRepository.countreinFerChevmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/statreinunique")
			public HashMap<String, Long> getnbreReinunique() {
				
				Long nbreOui=ficheRepository.countreinUniqueOui();
				Long nbreNon=ficheRepository.countreinUniqueNon();
				Long nbreNP=ficheRepository.countreinUniqueNP();
				Long nbremoin1=ficheRepository.countreinUniquemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statretardpubertaire")
			public HashMap<String, Long> getnbreRetardPubertaire() {
				
				Long nbreOui=ficheRepository.countretardPubertaireOui();
				Long nbreNon=ficheRepository.countretardPubertaireNon();
				Long nbreNP=ficheRepository.countretardPubertaireNP();
				Long nbremoin1=ficheRepository.countretardPubertairemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statanomaliepouce")
			public HashMap<String, Long> getnbreAnomPouce() {
				
				Long nbreOui=ficheRepository.countanomPouceOui();
				Long nbreNon=ficheRepository.countanomPouceNon();
				Long nbreNP=ficheRepository.countanomPouceNP();
				Long nbremoin1=ficheRepository.countanomPoucemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statanomalieautredoigts")
			public HashMap<String, Long> getnbreanomAutreDoigts() {
				
				Long nbreOui=ficheRepository.countanomAutreDoigtsOui();
				Long nbreNon=ficheRepository.countanomAutreDoigtsNon();
				Long nbreNP=ficheRepository.countanomAutreDoigtsNP();
				Long nbremoin1=ficheRepository.countanomAutreDoigtsmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statagenesieradius")
			public HashMap<String, Long> getnbreagenesieRadius() {
				
				Long nbreOui=ficheRepository.countagenesieRadiusOui();
				Long nbreNon=ficheRepository.countagenesieRadiusNon();
				Long nbreNP=ficheRepository.countagenesieRadiusNP();
				Long nbremoin1=ficheRepository.countagenesieRadiusmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statanomalieorteil")
			public HashMap<String, Long> getnbreanomOrteil() {
				
				Long nbreOui=ficheRepository.countanomOrteilOui();
				Long nbreNon=ficheRepository.countanomOrteilNon();
				Long nbreNP=ficheRepository.countanomOrteilNP();
				Long nbremoin1=ficheRepository.countanomOrteilmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/statspinabifida")
			public HashMap<String, Long> getnbrespinabifida() {
				
				Long nbreOui=ficheRepository.countbifideOui();
				Long nbreNon=ficheRepository.countbifideNon();
				Long nbreNP=ficheRepository.countbifideNP();
				Long nbremoin1=ficheRepository.countbifidemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
		
			@GetMapping("/statluxconghanche")
			public HashMap<String, Long> getnbreluxCongHanche() {
				
				Long nbreOui=ficheRepository.countluxCongHancheOui();
				Long nbreNon=ficheRepository.countluxCongHancheNon();
				Long nbreNP=ficheRepository.countluxCongHancheNP();
				Long nbremoin1=ficheRepository.countluxCongHanchemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
		
			@GetMapping("/statanomalieneuro")
			public HashMap<String, Long> getnbreanomNeuro() {
				
				Long nbreOui=ficheRepository.countanomNeuroOui();
				Long nbreNon=ficheRepository.countanomNeuroNon();
				Long nbreNP=ficheRepository.countanomNeuroNP();
				Long nbremoin1=ficheRepository.countanomNeuromoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statretardmental")
			public HashMap<String, Long> getnbreretardMent() {
				
				Long nbreOui=ficheRepository.countretardMentOui();
				Long nbreNon=ficheRepository.countretardMentNon();
				Long nbreNP=ficheRepository.countretardMentNP();
				Long nbremoin1=ficheRepository.countretardMentmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
		
			@GetMapping("/stathypoacousie")
			public HashMap<String, Long> getnbrehypoacousie() {
				
				Long nbreOui=ficheRepository.counthypoacousieOui();
				Long nbreNon=ficheRepository.counthypoacousieNon();
				Long nbreNP=ficheRepository.counthypoacousieNP();
				Long nbremoin1=ficheRepository.counthypoacousiemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statstrabisme")
			public HashMap<String, Long> getnbrestrabisme() {
				
				Long nbreOui=ficheRepository.countstrabismeOui();
				Long nbreNon=ficheRepository.countstrabismeNon();
				Long nbreNP=ficheRepository.countstrabismeNP();
				Long nbremoin1=ficheRepository.countstrabismemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statanomaliecardiovas")
			public HashMap<String, Long> getnbreanomCardVas() {
				
				Long nbreOui=ficheRepository.countanomCardVasOui();
				Long nbreNon=ficheRepository.countanomCardVasNon();
				Long nbreNP=ficheRepository.countanomCardVasNP();
				Long nbremoin1=ficheRepository.countanomCardVasmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statechocoeur")
			public HashMap<String, Long> getnbreechoCoeur() {
				
				Long nbreOui=ficheRepository.countechoCoeurOui();
				Long nbreNon=ficheRepository.countechoCoeurNon();
				Long nbreNP=ficheRepository.countechoCoeurNP();
				Long nbremoin1=ficheRepository.countechoCoeurmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/statendocrinopathie")
			public HashMap<String, Long> getnbreEndocrinopathie() {
				
				Long nbreOui=ficheRepository.countendocrinopathieOui();
				Long nbreNon=ficheRepository.countendocrinopathieNon();
				Long nbreNP=ficheRepository.countendocrinopathieNP();
				Long nbremoin1=ficheRepository.countendocrinopathiemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/statcongelationcellule")
			public HashMap<String, Long> getnbrecongelationCellule() {
				
				Long nbreFaite=ficheRepository.countcongelationcelluleFaite();
				Long nbreNonFaite=ficheRepository.countcongelationcelluleNonfaite();
				Long nbreMoin1=ficheRepository.countcongelationcelluleMoin1();
				Long nbreNP=ficheRepository.countcongelationcelluleNP();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Faite",  nbreFaite);
				map.put("Nonfaite", nbreNonFaite );
				map.put("Moin1",  nbreMoin1);
				map.put("NP",  nbreNP);
				
				return map;
			}
			@GetMapping("/stattransfusion")
			public HashMap<String, Long> getnbretransfusion() {
				
				Long nbreOui=ficheRepository.counttransfusionOui();
				Long nbreNon=ficheRepository.counttransfusionNon();
				Long nbreNP=ficheRepository.counttransfusionNP();
				Long nbremoin1=ficheRepository.counttransfusionmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/statcg")
			public HashMap<String, Long> getnbrecg() {
				
				Long nbcgMoin1=ficheRepository.countnbcgMoin1();
				Long nbcgInf10=ficheRepository.countnbcgInf10();
				Long nbcgBetween10Et20=ficheRepository.countnbcgBetween10Et20();
				Long nbcgSup20=ficheRepository.countnbcgSup20();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Moin1",  nbcgMoin1);
				map.put("Inf10", nbcgInf10 );
				map.put("Between10Et20",  nbcgBetween10Et20);
				map.put("Sup20",  nbcgSup20);

				return map;
			}
			
			@GetMapping("/statchelationFer")
			public HashMap<String, Long> getnbrechelationFer() {
				
				Long nbreOui=ficheRepository.countchelationferOui();
				Long nbreNon=ficheRepository.countchelationferNon();
				Long nbreNP=ficheRepository.countchelationferNP();
				Long nbremoin1=ficheRepository.countchelationfermoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			@GetMapping("/statcp")
			public HashMap<String, Long> getnbrecp() {
				
				Long nbcpMoin1=ficheRepository.countnbcpMoin1();
				Long nbcpInf10=ficheRepository.countnbcpInf10();
				Long nbcpBetween10Et20=ficheRepository.countnbcpBetween10Et20();
				Long nbcpSup20=ficheRepository.countnbcpSup20();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Moin1",  nbcpMoin1);
				map.put("Inf10", nbcpInf10 );
				map.put("Between10Et20",  nbcpBetween10Et20);
				map.put("Sup20",  nbcpSup20);

				return map;
			}

			@GetMapping("/statnilevar")
			public HashMap<String, Long> getnbrenilevar() {
				
				Long nbreOui=ficheRepository.countnilevarOui();
				Long nbreNon=ficheRepository.countnilevarNon();
				Long nbreNP=ficheRepository.countnilevarNP();
				Long nbremoin1=ficheRepository.countnilevarmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			@GetMapping("/statoxymetholone")
			public HashMap<String, Long> getnbreoxymetholone() {
				
				Long nbreOui=ficheRepository.countoxymetholoneOui();
				Long nbreNon=ficheRepository.countoxymetholoneNon();
				Long nbreNP=ficheRepository.countoxymetholoneNP();
				Long nbremoin1=ficheRepository.countoxymetholonemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			@GetMapping("/statandrotordyl")
			public HashMap<String, Long> getnbreandrotordyl() {
				
				Long nbreOui=ficheRepository.countandrotordylOui();
				Long nbreNon=ficheRepository.countandrotordylNon();
				Long nbreNP=ficheRepository.countandrotordylNP();
				Long nbremoin1=ficheRepository.countandrotordylmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			
			@GetMapping("/stattoxicite")
			public HashMap<String, Long> getnbretoxicite() {
				
				Long nbreVirilisation=ficheRepository.counttoxiciteVirilisation();
				Long nbreHepatique=ficheRepository.counttoxiciteHepatique();
				Long nbreAutre=ficheRepository.counttoxiciteAutre();
				Long nbreMoin1=ficheRepository.counttoxiciteMoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Virilisation",  nbreVirilisation);
				map.put("Hepatique", nbreHepatique );
				map.put("Autre",  nbreAutre);
				map.put("Moin1",  nbreMoin1);

				return map;
			}
			@GetMapping("/statenqueteHLA")
			public HashMap<String, Long> getnbreenqueteHLA() {
				
				Long nbreOui=ficheRepository.countenqueteHLAOui();
				Long nbreNon=ficheRepository.countenqueteHLANon();
				Long nbreNP=ficheRepository.countenqueteHLANP();
				Long nbremoin1=ficheRepository.countenqueteHLAmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statcyclophosphamide")
			public HashMap<String, Long> getnbrecyclophosphamide() {
				
				Long nbreOui=ficheRepository.countcyclophosphamideOui();
				Long nbreNon=ficheRepository.countcyclophosphamideNon();
				Long nbreNP=ficheRepository.countcyclophosphamideNP();
				Long nbremoin1=ficheRepository.countcyclophosphamidemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}

			@GetMapping("/statgreffefaite")
			public HashMap<String, Long> getnbregreffeFaite() {
				
				Long nbreOui=ficheRepository.countgreffeFaiteOui();
				Long nbreNon=ficheRepository.countgreffeFaiteNon();
				Long nbreNP=ficheRepository.countgreffeFaiteNP();
				Long nbremoin1=ficheRepository.countgreffeFaitemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			@GetMapping("/statfludarabine")
			public HashMap<String, Long> getnbrefludarabine() {
				
				Long nbreOui=ficheRepository.countfludarabineOui();
				Long nbreNon=ficheRepository.countfludarabineNon();
				Long nbreNP=ficheRepository.countfludarabineNP();
				Long nbremoin1=ficheRepository.countfludarabinemoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			@GetMapping("/statbusulfan")
			public HashMap<String, Long> getnbrebusulfan() {
				
				Long nbreOui=ficheRepository.countbusulfanOui();
				Long nbreNon=ficheRepository.countbusulfanNon();
				Long nbreNP=ficheRepository.countbusulfanNP();
				Long nbremoin1=ficheRepository.countbusulfanmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}
			@GetMapping("/statserotherapie")
			public HashMap<String, Long> getnbreserotherapie() {
				
				Long nbreFaite=ficheRepository.countserotherapieFaite();
				Long nbreNonFaite=ficheRepository.countserotherapieNonfaite();
				Long nbreMoin1=ficheRepository.countserotherapieMoin1();
				Long nbreNP=ficheRepository.countserotherapieNP();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Faite",  nbreFaite);
				map.put("Nonfaite", nbreNonFaite );
				map.put("Moin1",  nbreMoin1);
				map.put("NP",  nbreNP);
				
				return map;
			}
			@GetMapping("/statsmd")
			public HashMap<String, Long> getnbresmd() {
				
				Long nbreOui=ficheRepository.countsmdOui();
				Long nbreNon=ficheRepository.countsmdNon();
				Long nbreNP=ficheRepository.countsmdNP();
				Long nbremoin1=ficheRepository.countsmdmoin1();
				
				
				
				HashMap<String, Long> map=new HashMap<String, Long>();
				map.put("Oui",  nbreOui);
				map.put("Non", nbreNon );
				map.put("NP",  nbreNP);
				map.put("moin1",  nbremoin1);

				return map;
			}


}
