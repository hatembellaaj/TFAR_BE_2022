package tn.tfar.forms.domain.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.tfar.forms.enumeration.AgentPortant;
import tn.tfar.forms.enumeration.IR;
import tn.tfar.forms.enumeration.Instabilite;
import tn.tfar.forms.enumeration.Lymphocytes;

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
