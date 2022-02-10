package tn.tfar.forms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.tfar.forms.domain.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	@Query("DELETE FROM tn.tfar.forms.domain.entity.Patient p WHERE p.fiche.idFiche= :idOfFiche ")
	@Modifying
	void DeletePatientByIdFiche(@Param("idOfFiche") Long idOfFiche);
	
	@Query("SELECT p tn.tfar.forms.domain.entity.Patient p WHERE p.fiche.idFiche = :idOfFiche") 
	Patient findPatientByIdFiche(@Param("idOfFiche") Long idOfFiche);
	
	
	@Query ("select count(p) FROM tn.tfar.forms.domain.entity.Patient p where p.sexe ='M'")
    Long countMale();
	
	@Query ("select count(p) FROM tn.tfar.forms.domain.entity.Patient p where p.sexe ='F'")
    Long countFemale();
}
