package tn.tfar.forms.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.tfar.forms.enumeration.Gouvernorat;
import tn.tfar.forms.enumeration.Sexe;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDto {
	private Long idPatient;
	
	private String ndPatient;

	private String nom;

	private String prenom;

	private Sexe sexe;

	private String dateNaissance;

	private String lieuNaissance;

	private String adresse;

	private String reperes;

	private Gouvernorat gouvernorat;

	private String tel;

	private String prenomPere;

	private String nomMere;

	private String prenomMere;

	private String nomGmp;

	private String nomGmm;

	//private int age;
	
	private Long idFiche;
}
