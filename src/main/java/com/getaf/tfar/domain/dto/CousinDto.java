package com.getaf.tfar.domain.dto;
import com.getaf.tfar.enumeration.PlaceCousin;
import com.getaf.tfar.enumeration.Sexe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CousinDto {
	private Long cousinId;

	private String nom;

	private String prenom;

	private PlaceCousin placeCousin;

	private Sexe sexe;
	
	private Long idFiche;
}
