package tn.tfar.forms.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.tfar.forms.enumeration.Atteint;
import tn.tfar.forms.enumeration.Decedes;
import tn.tfar.forms.enumeration.PlaceFraterie;
import tn.tfar.forms.enumeration.Sexe;

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
