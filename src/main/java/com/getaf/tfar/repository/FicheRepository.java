package com.getaf.tfar.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.dto.FicheListDto;
import com.getaf.tfar.domain.entity.Fiche;
@Repository
public interface FicheRepository extends JpaRepository<Fiche, Long>{
	@Query("SELECT new com.getaf.tfar.domain.dto.FicheListDto(f.idFiche, f.ndossierFiche, f.dateDiagnostique, f.dateEnregistrement"
			+ ",f.user.organisme.nom,f.user.departement.nom,p.nom,p.prenom) FROM Fiche f  LEFT JOIN Patient p on p.fiche.idFiche=f.idFiche")
	List<FicheListDto> findAllFicheListDto();

	// uiv

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.uiv ='Faite'")
	Long countuivFaite();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.uiv ='Nonfaite'")
	Long countuivNonFaite();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.uiv ='Moin1'")
	Long countuivMoin1();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.uiv ='NP'")
	Long countuivNP();

	// cellularite

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cellularite ='Normale'")
	Long countcellulariteNormale();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cellularite ='Diminuee'")
	Long countcellulariteDiminuee();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cellularite ='Moin1'")
	Long countcellulariteMoin1();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cellularite ='NP'")
	Long countcellulariteNP();

	// morphologie

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.morphologie ='Normale'")
	Long countmorphologieNormale();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.morphologie ='Dysplasie'")
	Long countmorphologieDysplasie();

	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.morphologie ='Moin1'")
	Long countmorphologieMoin1();
	
	//syndrome anemique
	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeAnemique ='Oui'")
	Long countsyndromeAnemiqueOui();
	
	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeAnemique ='Non'")
	Long countsyndromeAnemiqueNon();
	
	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeAnemique ='NP'")
	Long countsyndromeAnemiqueNP();
	
	@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeAnemique ='moin1'")
	Long countsyndromeAnemiquemoin1();

	//syndrome hemorragique
		@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeHem ='Oui'")
		Long countsyndromeHemOui();
		
		@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeHem ='Non'")
		Long countsyndromeHemNon();
		
		@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeHem ='NP'")
		Long countsyndromeHemNP();
		
		@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeHem ='moin1'")
		Long countsyndromeHemmoin1();
		
		//syndrome infectieux
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeInf ='Oui'")
				Long countsyndromeInfOui();
				
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeInf ='Non'")
				Long countsyndromeInfNon();
				
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeInf ='NP'")
				Long countsyndromeInfNP();
				
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.syndromeInf ='moin1'")
				Long countsyndromeInfmoin1();


	   //cancer
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cancer ='Oui'")
				Long countcancerOui();
				
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cancer ='Non'")
				Long countcancerNon();
				
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cancer ='NP'")
				Long countcancerNP();
				
				@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cancer ='moin1'")
				Long countcancermoin1();
				
		 //hypotrophie
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypotrophie ='Oui'")
							Long counthypotrophieOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypotrophie ='Non'")
							Long counthypotrophieNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypotrophie ='NP'")
							Long counthypotrophieNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypotrophie ='moin1'")
							Long counthypotrophiemoin1();
							
		//troubleCroissance
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.troubleCroi ='Oui'")
							Long counttroubleCroiOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.troubleCroi ='Non'")
							Long counttroubleCroiNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.troubleCroi ='NP'")
							Long counttroubleCroiNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.troubleCroi ='moin1'")
							Long counttroubleCroimoin1();
								
	  //atteinte cutanée
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteCut ='Oui'")
							Long countatteinteCutOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteCut ='Non'")
							Long countatteinteCutNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteCut ='NP'")
							Long countatteinteCutNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteCut ='moin1'")
							Long countatteinteCutmoin1();

	//hyperpigmentation
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hyperPig ='Oui'")
							Long counthyperPigOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hyperPig ='Non'")
							Long counthyperPigNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hyperPig ='NP'")
							Long counthyperPigNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hyperPig ='moin1'")
							Long counthyperPigmoin1();

    //atteinte de le tete	
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteTete ='Oui'")
							Long countatteinteTeteOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteTete ='Non'")
							Long countatteinteTeteNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteTete ='NP'")
							Long countatteinteTeteNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteTete ='moin1'")
							Long countatteinteTetemoin1();

	//atteinte osseuse
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteOss ='Oui'")
							Long countatteinteOssOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteOss ='Non'")
							Long countatteinteOssNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteOss ='NP'")
							Long countatteinteOssNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.atteinteOss ='moin1'")
							Long countatteinteOssmoin1();

   //anomalie digestive
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomDig ='Oui'")
							Long countanomDigOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomDig ='Non'")
							Long countanomDigNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomDig ='NP'")
							Long countanomDigNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomDig ='moin1'")
							Long countanomDigmoin1();
							
  //malformation urogénitale
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.malUro ='Oui'")
							Long countmalUroOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.malUro ='Non'")
							Long countmalUroNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.malUro ='NP'")
							Long countmalUroNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.malUro ='moin1'")
							Long countmalUromoin1();
							
  //microcephalie
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microcephalie ='Oui'")
							Long countmicrocephalieOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microcephalie ='Non'")
							Long countmicrocephalieNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microcephalie ='NP'")
							Long countmicrocephalieNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microcephalie ='moin1'")
							Long countmicrocephaliemoin1();

//microphtalmie
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microphtalmie ='Oui'")
							Long countmicrophtalmieOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microphtalmie ='Non'")
							Long countmicrophtalmieNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microphtalmie ='NP'")
							Long countmicrophtalmieNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.microphtalmie ='moin1'")
							Long countmicrophtalmiemoin1();
			
	//echo
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echo ='Faite'")
							Long countechoFaite();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echo ='Nonfaite'")
							Long countechoNonfaite();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echo ='Moin1'")
							Long countechoMoin1();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echo ='NP'")
							Long countechoNP();
	//decouverte fortuite
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.decouverteFort ='Oui'")
							Long countdecouverteFortOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.decouverteFort ='Non'")
							Long countdecouverteFortNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.decouverteFort ='NP'")
							Long countdecouverteFortNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.decouverteFort ='moin1'")
							Long countdecouverteFortmoin1();
	//enquete familiale
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteFam ='Oui'")
							Long countenqueteFamOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteFam ='Non'")
							Long countenqueteFamNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteFam ='NP'")
							Long countenqueteFamNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteFam ='moin1'")
							Long countenqueteFammoin1();
	//tachecafé
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.tacheCaf ='Oui'")
							Long counttacheCafOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.tacheCaf ='Non'")
							Long counttacheCafNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.tacheCaf ='NP'")
							Long counttacheCafNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.tacheCaf ='moin1'")
							Long counttacheCafmoin1();
	//faciés triangulaire
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.facieTrig ='Oui'")
							Long countfacieTrigOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.facieTrig ='Non'")
							Long countfacieTrigNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.facieTrig ='NP'")
							Long countfacieTrigNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.facieTrig ='moin1'")
							Long countfacieTrigmoin1();
//traits Fin
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.traitsFin ='Oui'")
							Long counttraitsFinOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.traitsFin ='Non'")
							Long counttraitsFinNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.traitsFin ='NP'")
							Long counttraitsFinNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.traitsFin ='moin1'")
							Long counttraitsFinmoin1();
	//rein ectopique
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinEctop ='Oui'")
							Long countreinEctopOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinEctop ='Non'")
							Long countreinEctopNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinEctop ='NP'")
							Long countreinEctopNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinEctop ='moin1'")
							Long countreinEctopmoin1();
	//Rein en fer à cheval
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinFerChev ='Oui'")
							Long countreinFerChevOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinFerChev ='Non'")
							Long countreinFerChevNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinFerChev ='NP'")
							Long countreinFerChevNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinFerChev ='moin1'")
							Long countreinFerChevmoin1();
	//rein unique	
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinUnique ='Oui'")
							Long countreinUniqueOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinUnique ='Non'")
							Long countreinUniqueNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinUnique ='NP'")
							Long countreinUniqueNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.reinUnique ='moin1'")
							Long countreinUniquemoin1();
//retard pubertaire
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardPubertaire ='Oui'")
							Long countretardPubertaireOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardPubertaire ='Non'")
							Long countretardPubertaireNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardPubertaire ='NP'")
							Long countretardPubertaireNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardPubertaire ='moin1'")
							Long countretardPubertairemoin1();
//anomalie de pouce
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomPouce ='Oui'")
							Long countanomPouceOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomPouce ='Non'")
							Long countanomPouceNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomPouce ='NP'")
							Long countanomPouceNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomPouce ='moin1'")
							Long countanomPoucemoin1();
			//Anomalie des autres doigts :
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomAutreDoigts ='Oui'")
							Long countanomAutreDoigtsOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomAutreDoigts ='Non'")
							Long countanomAutreDoigtsNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomAutreDoigts ='NP'")
							Long countanomAutreDoigtsNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomAutreDoigts ='moin1'")
							Long countanomAutreDoigtsmoin1();
				//Agénésie du radius :
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.agenesieRadius ='Oui'")
							Long countagenesieRadiusOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.agenesieRadius ='Non'")
							Long countagenesieRadiusNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.agenesieRadius ='NP'")
							Long countagenesieRadiusNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.agenesieRadius ='moin1'")
							Long countagenesieRadiusmoin1();
				//anomalie orteil
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomOrteil ='Oui'")
							Long countanomOrteilOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomOrteil ='Non'")
							Long countanomOrteilNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomOrteil ='NP'")
							Long countanomOrteilNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomOrteil ='moin1'")
							Long countanomOrteilmoin1();
				//spina bifida			
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.bifide ='Oui'")
							Long countbifideOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.bifide ='Non'")
							Long countbifideNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.bifide ='NP'")
							Long countbifideNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.bifide ='moin1'")
							Long countbifidemoin1();
//Luxation congénitale de la hanche :
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.luxCongHanche ='Oui'")
							Long countluxCongHancheOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.luxCongHanche ='Non'")
							Long countluxCongHancheNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.luxCongHanche ='NP'")
							Long countluxCongHancheNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.luxCongHanche ='moin1'")
							Long countluxCongHanchemoin1();
			//anomalie neurologique
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomNeuro ='Oui'")
							Long countanomNeuroOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomNeuro ='Non'")
							Long countanomNeuroNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomNeuro ='NP'")
							Long countanomNeuroNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomNeuro ='moin1'")
							Long countanomNeuromoin1();
				//retard mental
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardMent ='Oui'")
							Long countretardMentOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardMent ='Non'")
							Long countretardMentNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardMent ='NP'")
							Long countretardMentNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.retardMent ='moin1'")
							Long countretardMentmoin1();
//hypoacousie
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypoacousie ='Oui'")
							Long counthypoacousieOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypoacousie ='Non'")
							Long counthypoacousieNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypoacousie ='NP'")
							Long counthypoacousieNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.hypoacousie ='moin1'")
							Long counthypoacousiemoin1();
//strabisme
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.strabisme ='Oui'")
							Long countstrabismeOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.strabisme ='Non'")
							Long countstrabismeNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.strabisme ='NP'")
							Long countstrabismeNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.strabisme ='moin1'")
							Long countstrabismemoin1();
//anomalie Cardio Vasculaire
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomCardVas ='Oui'")
							Long countanomCardVasOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomCardVas ='Non'")
							Long countanomCardVasNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomCardVas ='NP'")
							Long countanomCardVasNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.anomCardVas ='moin1'")
							Long countanomCardVasmoin1();
	//echo coeur
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echoCoeur ='Oui'")
							Long countechoCoeurOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echoCoeur ='Non'")
							Long countechoCoeurNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echoCoeur ='NP'")
							Long countechoCoeurNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.echoCoeur ='moin1'")
							Long countechoCoeurmoin1();
//endocrinopathie
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.endocrinopathie ='Oui'")
							Long countendocrinopathieOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.endocrinopathie ='Non'")
							Long countendocrinopathieNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.endocrinopathie ='NP'")
							Long countendocrinopathieNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.endocrinopathie ='moin1'")
							Long countendocrinopathiemoin1();
//congelation Cellule
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.congelationCellule ='Faite'")
							Long countcongelationcelluleFaite();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.congelationCellule ='Nonfaite'")
							Long countcongelationcelluleNonfaite();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.congelationCellule ='Moin1'")
							Long countcongelationcelluleMoin1();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.congelationCellule ='NP'")
							Long countcongelationcelluleNP();
	//trasfusion
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.transfusion ='Oui'")
							Long counttransfusionOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.transfusion ='Non'")
							Long counttransfusionNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.transfusion ='NP'")
							Long counttransfusionNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.transfusion ='moin1'")
							Long counttransfusionmoin1();
 //nbCG							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCG ='Moin1'")
							Long countnbcgMoin1();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCG ='Inf10'")
							Long countnbcgInf10();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCG ='Between10Et20'")
							Long countnbcgBetween10Et20();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCG ='Sup20'")
							Long countnbcgSup20();
	//chelationFer
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.chelationFer ='Oui'")
							Long countchelationferOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.chelationFer ='Non'")
							Long countchelationferNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.chelationFer ='NP'")
							Long countchelationferNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.chelationFer ='moin1'")
							Long countchelationfermoin1();
   //nbCP							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCP ='Moin1'")
							Long countnbcpMoin1();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCP ='Inf10'")
							Long countnbcpInf10();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCP ='Between10Et20'")
							Long countnbcpBetween10Et20();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nbCP ='Sup20'")
							Long countnbcpSup20();
		//nilevar
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nilevar ='Oui'")
							Long countnilevarOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nilevar ='Non'")
							Long countnilevarNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nilevar ='NP'")
							Long countnilevarNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.nilevar ='moin1'")
							Long countnilevarmoin1();
		//oxymetholone
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.oxymetholone ='Oui'")
							Long countoxymetholoneOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.oxymetholone ='Non'")
							Long countoxymetholoneNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.oxymetholone ='NP'")
							Long countoxymetholoneNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.oxymetholone ='moin1'")
							Long countoxymetholonemoin1();
		//androtordyl
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.androtordyl ='Oui'")
							Long countandrotordylOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.androtordyl ='Non'")
							Long countandrotordylNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.androtordyl ='NP'")
							Long countandrotordylNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.androtordyl ='moin1'")
							Long countandrotordylmoin1();
			//toxicite
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.toxicite ='Virilisation'")
							Long counttoxiciteVirilisation();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.toxicite ='Hepatique'")
							Long counttoxiciteHepatique();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.toxicite ='Autre'")
							Long counttoxiciteAutre();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.toxicite ='Moin1'")
							Long counttoxiciteMoin1();
	//enqueteHLA
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteHLA ='Oui'")
							Long countenqueteHLAOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteHLA ='Non'")
							Long countenqueteHLANon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteHLA ='NP'")
							Long countenqueteHLANP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.enqueteHLA ='moin1'")
							Long countenqueteHLAmoin1();
 //greffeFaite
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.greffeFaite ='Oui'")
							Long countgreffeFaiteOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.greffeFaite ='Non'")
							Long countgreffeFaiteNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.greffeFaite ='NP'")
							Long countgreffeFaiteNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.greffeFaite ='moin1'")
							Long countgreffeFaitemoin1();
	//cyclophosphamide
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cyclophosphamide ='Oui'")
							Long countcyclophosphamideOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cyclophosphamide ='Non'")
							Long countcyclophosphamideNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cyclophosphamide ='NP'")
							Long countcyclophosphamideNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.cyclophosphamide ='moin1'")
							Long countcyclophosphamidemoin1();
	//fludarabine
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.fludarabine ='Oui'")
							Long countfludarabineOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.fludarabine ='Non'")
							Long countfludarabineNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.fludarabine ='NP'")
							Long countfludarabineNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.fludarabine ='moin1'")
							Long countfludarabinemoin1();
		//busulfan
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.busulfan ='Oui'")
							Long countbusulfanOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.busulfan ='Non'")
							Long countbusulfanNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.busulfan ='NP'")
							Long countbusulfanNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.busulfan ='moin1'")
							Long countbusulfanmoin1();
		//serotherapie
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.serotherapie ='Faite'")
							Long countserotherapieFaite();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.serotherapie ='Nonfaite'")
							Long countserotherapieNonfaite();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.serotherapie ='Moin1'")
							Long countserotherapieMoin1();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.serotherapie ='NP'")
							Long countserotherapieNP();
		//smd
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.smd ='Oui'")
							Long countsmdOui();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.smd ='Non'")
							Long countsmdNon();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.smd ='NP'")
							Long countsmdNP();
							
							@Query("select count(f) FROM com.getaf.tfar.domain.entity.Fiche f where f.smd ='moin1'")
							Long countsmdmoin1();
//	@Query("select count(?), ? FROM com.getaf.tfar.domain.entity.Fiche f where ? in (select distinct(sexe) from patient) group by sexe;
							//String[] get//
}
