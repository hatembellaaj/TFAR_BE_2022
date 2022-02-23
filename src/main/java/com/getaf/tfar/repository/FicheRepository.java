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
}
