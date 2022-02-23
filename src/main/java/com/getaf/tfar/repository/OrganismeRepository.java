package com.getaf.tfar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.Organisme;

@Repository
public interface OrganismeRepository extends JpaRepository<Organisme, Long>{

}
