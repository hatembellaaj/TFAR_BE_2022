package com.getaf.tfar.domain.dto;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FicheListDto {
	private Long idFiche;

	private String ndossierFiche;
	
	private Date dateDiagnostique;

	private Date dateEnregistrement;
	
	private String nomOrgUserOfFiche;
	
	private String nomDepUserOfFiche;
	
	private String nomPatient;
	
	private String prenomPatient;
}
