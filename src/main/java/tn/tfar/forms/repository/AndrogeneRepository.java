package tn.tfar.forms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.tfar.forms.domain.entity.Androgene;

@Repository
public interface AndrogeneRepository extends JpaRepository<Androgene, Long> {
	@Query("DELETE FROM tn.tfar.forms.domain.entity.Androgene a WHERE a.fiche.idFiche= :idOfFiche ")
	@Modifying
	void DeleteAndrogeneByIdFiche(@Param("idOfFiche") Long idOfFiche);
	
	@Query("SELECT a tn.tfar.forms.domain.entity.Androgene a WHERE a.fiche.idFiche = :idOfFiche") 
	List<Androgene> findAndrogeneByIdFiche(@Param("idOfFiche") Long idOfFiche);
}
