package tn.tfar.forms.converter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tn.tfar.forms.domain.dto.AndrogeneDto;
import tn.tfar.forms.domain.entity.Androgene;
import tn.tfar.forms.domain.entity.Fiche;

@Component
public class AndrogeneConverter {
	public AndrogeneDto entityToDto(Androgene androgene) {

		AndrogeneDto map = new AndrogeneDto(androgene.getId(), androgene.getMois(), androgene.getReponse(),
				androgene.getFiche().getIdFiche());
		return map;
	}

	public List<AndrogeneDto> entityToDto(List<Androgene> androgene) {
		return androgene.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Androgene dtoToEntity(AndrogeneDto androgeneDto) {
		Androgene map = new Androgene(androgeneDto.getId(), androgeneDto.getMois(), androgeneDto.getReponse(),
				new Fiche(androgeneDto.getIdFiche()));

		return map;
	}

	public List<Androgene> dtoToEntity(List<AndrogeneDto> androgeneDto) {
		return androgeneDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
