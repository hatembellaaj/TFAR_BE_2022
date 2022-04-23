package com.getaf.tfar.domain.dto;
import com.getaf.tfar.domain.entity.ERole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto {
	private Long idRole;
	
	private ERole titre;
	
	private String description;
	
	private Boolean deleted;
	
	private Long codeUser;
}
