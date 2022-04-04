package com.getaf.tfar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaf.tfar.domain.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	Role findByTitre(String titre);

}
