package tn.tfar.forms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.tfar.forms.domain.entity.Cytogenetique;

@Repository
public interface CytogenetiqueRepository extends JpaRepository<Cytogenetique, Long>{
	@Query("DELETE FROM tn.tfar.forms.domain.entity.Cytogenetique c WHERE c.fiche.idFiche= :idOfFiche ")
	@Modifying
	void DeleteCytogenetiqueByIdFiche(@Param("idOfFiche") Long idOfFiche);
	
	@Query("SELECT c FROM tn.tfar.forms.domain.entity.Cytogenetique c WHERE c.fiche.idFiche = :idOfFiche") 
	List<Cytogenetique> findCytogenetiqueByIdFiche(@Param("idOfFiche") Long idOfFiche);
	
}
