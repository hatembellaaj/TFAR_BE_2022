package com.getaf.tfar.domain.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.getaf.tfar.enumeration.PlaceCousin;
import com.getaf.tfar.enumeration.Sexe;

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
@Table(name = "cousin")
public class Cousin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cousin_id")
	private Long cousinId;

	@Column(name = "nom", length = 50)
	private String nom;

	@Column(name = "prenom", length = 50)
	private String prenom;

	@Column(name = "place_cousin", length = 10)
	@Enumerated(EnumType.STRING)
	private PlaceCousin placeCousin;

	@Column(name = "sexe", length = 4)
	@Enumerated(EnumType.STRING)
	private Sexe sexe;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_fiche", referencedColumnName = "id_fiche")
	private Fiche fiche;
}
