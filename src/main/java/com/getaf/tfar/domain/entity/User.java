package com.getaf.tfar.domain.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.getaf.tfar.enumeration.Gouvernorat;

import com.getaf.tfar.enumeration.TypeUser;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString()
@Entity
@Table(	name = "user", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "login"),
	@UniqueConstraint(columnNames = "email") 
})


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Long code;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<Role> roles = new HashSet<>();
	
	
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

	@NotBlank
	@Size(max = 50)
	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;

	@Column(name = "poste")
	private String poste;

	@Column(name = "fax")
	private String fax;

	@NotBlank
	@Size(max = 20)
	@Column(name = "login")
	private String login;

	@NotBlank
	@Size(max = 120)
	@Column(name = "password")
	private String password;

	@Column(name = "url")
	private String url;

	@ManyToOne(optional = false)
	@JoinColumn(name = "code_organisme", referencedColumnName = "code", nullable=true)
	private Organisme organisme;

	@ManyToOne(optional = false)
	@JoinColumn(name = "code_departement", referencedColumnName = "code", nullable=true)
	private Departement departement;


	public User() {
	}

	public User(String username, String email, String password) {
		this.login = username;
		this.email = email;
		this.password = password;
	}

}
