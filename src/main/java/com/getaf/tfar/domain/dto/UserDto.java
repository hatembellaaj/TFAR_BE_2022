package com.getaf.tfar.domain.dto;
import java.util.Set;

import com.getaf.tfar.domain.entity.Role;
import com.getaf.tfar.enumeration.Gouvernorat;
import com.getaf.tfar.enumeration.RoleType;
import com.getaf.tfar.enumeration.TypeUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	private Long code;

	// private String role;

	private Set<Role> roles;

	// private String type;

	private TypeUser type;

	private String nom;

	private String prenom;

	private String grade;

	private Gouvernorat gouvernorat;

	private String adresse;

	private String tel;

	private String email;

	private String photo;

	private String poste;

	private String fax;

	private String login;

	private String password;

	private String url;

	private Long codeOrganisme;
	
	private String nomOrganisme;

	private Long codeDepartement;

	private String nomDepartement;

}
