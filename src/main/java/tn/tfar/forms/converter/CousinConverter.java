package tn.tfar.forms.converter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import tn.tfar.forms.domain.dto.CousinDto;
import tn.tfar.forms.domain.entity.Cousin;
import tn.tfar.forms.domain.entity.Fiche;

@Component
public class CousinConverter {
	public CousinDto entityToDto(Cousin cousin) {

		CousinDto map = new CousinDto(cousin.getCousinId(), cousin.getNom(), cousin.getPrenom(),
				cousin.getPlaceCousin(), cousin.getSexe(), cousin.getFiche().getIdFiche());
		return map;
	}

	public List<CousinDto> entityToDto(List<Cousin> cousin) {

		return cousin.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Cousin dtoToEntity(CousinDto cousinDto) {

		Cousin map = new Cousin(cousinDto.getCousinId(), cousinDto.getNom(), cousinDto.getPrenom(),
				cousinDto.getPlaceCousin(), cousinDto.getSexe(), new Fiche(cousinDto.getIdFiche()));

		return map;
	}

	public List<Cousin> dtoToEntity(List<CousinDto> cousinDto) {

		return cousinDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
