package com.getaf.tfar.domain.dto;
import com.getaf.tfar.enumeration.Reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AndrogeneDto {
	private Long id;

	//private Mois mois;
	
	private Long mois;

	private Reponse reponse;
	
	private Long idFiche;

}
