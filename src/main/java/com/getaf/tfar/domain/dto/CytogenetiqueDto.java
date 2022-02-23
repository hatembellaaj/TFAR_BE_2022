package com.getaf.tfar.domain.dto;
import java.util.Date;

import com.getaf.tfar.enumeration.AgentPortant;
import com.getaf.tfar.enumeration.IR;
import com.getaf.tfar.enumeration.Instabilite;
import com.getaf.tfar.enumeration.Lymphocytes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CytogenetiqueDto {
	private Long netudeCyto;

	private Lymphocytes lymphocytes;

	private Date dateSang;

	private AgentPortant agentPortant;

	private Instabilite instabilite;

	private Double instabilitePourcentage;

	private IR ir;

	private Double irPourcentage;

	private String moelle;

	private Date dateMoelle;

	private String resultatMoelle;
	
	private Long idLaboratoire;
	
	private Long idFiche;

}
