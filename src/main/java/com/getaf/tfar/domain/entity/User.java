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

import com.getaf.tfar.enumeration.Gouvernorat;
import com.getaf.tfar.enumeration.RoleType;
import com.getaf.tfar.enumeration.TypeUser;

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
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private RoleType role;

	@Column(name = "type", length = 17)
	@Enumerated(EnumType.STRING)
	private TypeUser type;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "grade")
	private String grade;

	@Column(name = "gouvernorat", length = 20)
	@Enumerated(EnumType.STRING)
	private Gouvernorat gouvernorat;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "tel")
	private String tel;

	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;

	@Column(name = "poste")
	private String poste;

	@Column(name = "fax")
	private String fax;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "url")
	private String url;

	@ManyToOne(optional = false)
	@JoinColumn(name = "code_organisme", referencedColumnName = "code")
	private Organisme organisme;

	@ManyToOne(optional = false)
	@JoinColumn(name = "code_departement", referencedColumnName = "code")
	private Departement departement;


	public User(Long code) {
		this.code = code;
	}

}
