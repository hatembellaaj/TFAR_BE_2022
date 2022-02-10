package tn.tfar.forms.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.tfar.forms.enumeration.OrganismeType;

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
