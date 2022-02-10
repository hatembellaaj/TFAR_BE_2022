package tn.tfar.forms.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.tfar.forms.enumeration.PlaceCousin;
import tn.tfar.forms.enumeration.Sexe;

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
