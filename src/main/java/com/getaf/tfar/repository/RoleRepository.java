package com.getaf.tfar.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.getaf.tfar.domain.entity.Role;
import com.getaf.tfar.domain.entity.ERole;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	Optional<Role> findByTitre(ERole name);

}
