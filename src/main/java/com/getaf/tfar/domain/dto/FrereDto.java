package com.getaf.tfar.domain.dto;
import com.getaf.tfar.enumeration.Atteint;
import com.getaf.tfar.enumeration.Decedes;
import com.getaf.tfar.enumeration.PlaceFraterie;
import com.getaf.tfar.enumeration.Sexe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FrereDto {
	private Long frereId;

	private String nom;

	private String prenom;

	private Atteint atteint;

	private PlaceFraterie placeFratrie;

	private Sexe sexe;

	private Decedes decedes;

	private Long age;
	
	private Long idFiche;
}
