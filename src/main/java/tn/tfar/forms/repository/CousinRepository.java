package tn.tfar.forms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.tfar.forms.domain.entity.Cousin;
@Repository
public interface CousinRepository extends JpaRepository<Cousin, Long>{

}
