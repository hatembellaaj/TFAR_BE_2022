package tn.tfar.forms.domain.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.tfar.forms.enumeration.Gouvernorat;
import tn.tfar.forms.enumeration.Sexe;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString()
@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_patient")
	private Long idPatient;

	@Column(name = "n_dossier_patient", length = 10)
	private String ndPatient;

	@Column(name = "nom", length = 50)
	private String nom;

	@Column(name = "prenom", length = 50)
	private String prenom;

	@Column(name = "sexe", length = 4)
	@Enumerated(EnumType.STRING)
	private Sexe sexe;

	@Column(name = "date_naissance")
	private String dateNaissance;

	@Column(name = "lieu_naissance")
	private String lieuNaissance;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "reperes")
	private String reperes;

	@Column(name = "gouvernorat")
	@Enumerated(EnumType.STRING)
	private Gouvernorat gouvernorat;

	@Column(name = "tel")
	private String tel;

	@Column(name = "prenom_pere")
	private String prenomPere;

	@Column(name = "nom_mere")
	private String nomMere;

	@Column(name = "prenom_mere")
	private String prenomMere;

	@Column(name = "nom_gmp")
	private String nomGmp;

	@Column(name = "nom_gmm")
	private String nomGmm;

	/*
	 * @Column(name = "age") private int age;
	 */

	@OneToOne(optional = false)
	@JoinColumn(name = "id_fiche", referencedColumnName = "id_fiche")
	private Fiche fiche;

	public Patient(String ndPatient, String nom, String prenom, Sexe sexe, String dateNaissance, String lieuNaissance,
			String adresse, String reperes, Gouvernorat gouvernorat, String tel, String prenomPere, String nomMere,
			String prenomMere, String nomGmp, String nomGmm, Fiche fiche) {
		this.ndPatient = ndPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.adresse = adresse;
		this.reperes = reperes;
		this.gouvernorat = gouvernorat;
		this.tel = tel;
		this.prenomPere = prenomPere;
		this.nomMere = nomMere;
		this.prenomMere = prenomMere;
		this.nomGmp = nomGmp;
		this.nomGmm = nomGmm;
		this.fiche = fiche;
	}
}
