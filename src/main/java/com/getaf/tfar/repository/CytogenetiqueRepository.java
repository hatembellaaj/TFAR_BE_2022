package com.getaf.tfar.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.Cytogenetique;
@Repository
public interface CytogenetiqueRepository extends JpaRepository<Cytogenetique, Long>{
	@Query("DELETE FROM com.getaf.tfar.domain.entity.Cytogenetique c WHERE c.fiche.idFiche= :idOfFiche ")
	@Modifying
	void DeleteCytogenetiqueByIdFiche(@Param("idOfFiche") Long idOfFiche);
	
	@Query("SELECT c FROM com.getaf.tfar.domain.entity.Cytogenetique c WHERE c.fiche.idFiche = :idOfFiche") 
	List<Cytogenetique> findCytogenetiqueByIdFiche(@Param("idOfFiche") Long idOfFiche);
}
