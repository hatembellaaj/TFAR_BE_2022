package com.getaf.tfar.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.getaf.tfar.domain.dto.OrganismeDto;
import com.getaf.tfar.domain.entity.Organisme;

@Component
public class OrganismeConverter {
	public OrganismeDto entityToDto(Organisme organisme) {

		/*OrganismeDto map = new OrganismeDto(organisme.getCode(),organisme.getNom(),organisme.getAdresse(),organisme.getTel(),
				organisme.getContact(),organisme.getEmail(),organisme.getType().name());*/
		
		
		OrganismeDto map = new OrganismeDto(organisme.getCode(),organisme.getNom(),organisme.getAdresse(),organisme.getTel(),
				organisme.getContact(),organisme.getEmail(),organisme.getType());
		
		

		return map;
	}

	public List<OrganismeDto> entityToDto(List<Organisme> organisme) {

		return organisme.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Organisme dtoToEntity(OrganismeDto organismeDto) {

		

		/*Organisme map = new Organisme(organismeDto.getCode(),organismeDto.getNom(),organismeDto.getAdresse(),organismeDto.getTel(),
				organismeDto.getContact(),organismeDto.getEmail(),OrganismeType.valueOf(organismeDto.getType()));*/
		
		Organisme map = new Organisme(organismeDto.getCode(),organismeDto.getNom(),organismeDto.getAdresse(),organismeDto.getTel(),
				organismeDto.getContact(),organismeDto.getEmail(),organismeDto.getType());

		return map;
	}

	public List<Organisme> dtoToEntity(List<OrganismeDto> organismeDto) {

		return organismeDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}


}
