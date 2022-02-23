package com.getaf.tfar.domain.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.getaf.tfar.enumeration.OrganismeType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString()
@Entity
@Table(name = "organisme")

public class Organisme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@NotNull
	@Column(name = "adresse")
	private String adresse;

	@NotNull
	@Column(name = "tel")
	private String tel;

	@NotNull
	@Column(name = "contact")
	private String contact;

	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private OrganismeType type;

	public Organisme(Long code, @NotNull String nom) {
		this.code = code;
		this.nom = nom;
	}

}
