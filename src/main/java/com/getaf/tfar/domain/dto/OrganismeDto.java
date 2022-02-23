package com.getaf.tfar.domain.dto;

import com.getaf.tfar.enumeration.OrganismeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrganismeDto {
	private Long code;

	private String nom;

	private String adresse;

	private String tel;

	private String contact;

	private String email;
	
	//private String type;
	
	private OrganismeType type;

}
