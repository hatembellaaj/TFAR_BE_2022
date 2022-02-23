package com.getaf.tfar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.Laboratoire;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long>{

}
