package com.getaf.tfar.converter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.getaf.tfar.domain.dto.DepartementDto;
import com.getaf.tfar.domain.entity.Departement;
@Component
public class DepartementConverter {
	public DepartementDto entityToDto(Departement departement) {

		DepartementDto map = new DepartementDto(departement.getCode(),departement.getNom());

		return map;
	}

	public List<DepartementDto> entityToDto(List<Departement> departement) {

		return departement.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Departement dtoToEntity(DepartementDto departementDto) {

		Departement map = new Departement(departementDto.getCode(),departementDto.getNom());

		return map;
	}

	public List<Departement> dtoToEntity(List<DepartementDto> departementDto) {

		return departementDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
