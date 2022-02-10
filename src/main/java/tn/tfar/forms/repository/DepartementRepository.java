package tn.tfar.forms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.tfar.forms.domain.entity.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
