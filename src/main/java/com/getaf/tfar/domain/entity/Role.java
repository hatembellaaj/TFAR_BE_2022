package com.getaf.tfar.domain.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;



@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString()
@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_role")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name="titre",length = 20)
	private ERole titre;
	
	@Column(name="description")
	private String description;
	
	@Column(name="deleted")
	private Boolean deleted;


	public Role() {

	}
	
	
	
}
