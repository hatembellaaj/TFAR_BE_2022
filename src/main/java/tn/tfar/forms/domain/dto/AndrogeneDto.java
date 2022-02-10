package tn.tfar.forms.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.tfar.forms.enumeration.Reponse;

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
