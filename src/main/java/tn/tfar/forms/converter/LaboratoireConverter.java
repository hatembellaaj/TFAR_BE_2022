package tn.tfar.forms.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tn.tfar.forms.domain.dto.LaboratoireDto;
import tn.tfar.forms.domain.entity.Laboratoire;
@Component
public class LaboratoireConverter {
	public LaboratoireDto entityToDto(Laboratoire laboratoire) {
		LaboratoireDto map = new LaboratoireDto(laboratoire.getId(),laboratoire.getNom());
		return map;
	}

	public List<LaboratoireDto> entityToDto(List<Laboratoire> laboratoire) {

		return laboratoire.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Laboratoire dtoToEntity(LaboratoireDto laboratoireDto) {

		Laboratoire map = new Laboratoire(laboratoireDto.getId(),laboratoireDto.getNom());

		return map;
	}

	public List<Laboratoire> dtoToEntity(List<LaboratoireDto> laboratoireDto) {

		return laboratoireDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
