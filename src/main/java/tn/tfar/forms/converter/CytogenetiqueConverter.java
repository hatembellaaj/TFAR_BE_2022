package tn.tfar.forms.converter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import tn.tfar.forms.domain.dto.CytogenetiqueDto;
import tn.tfar.forms.domain.entity.Cytogenetique;
import tn.tfar.forms.domain.entity.Fiche;
import tn.tfar.forms.domain.entity.Laboratoire;

@Component
public class CytogenetiqueConverter {
	public CytogenetiqueDto entityToDto(Cytogenetique cytogenetique) {

		CytogenetiqueDto map = new CytogenetiqueDto(cytogenetique.getNetudeCyto(),cytogenetique.getLymphocytes(),
				cytogenetique.getDateSang(),cytogenetique.getAgentPortant(),cytogenetique.getInstabilite(),cytogenetique.getInstabilitePourcentage(),
				cytogenetique.getIr(),cytogenetique.getIrPourcentage(),cytogenetique.getMoelle(),cytogenetique.getDateMoelle(),cytogenetique.getResultatMoelle(),
				cytogenetique.getLaboratoire().getId(),cytogenetique.getFiche().getIdFiche());

		return map;
	}

	public List<CytogenetiqueDto> entityToDto(List<Cytogenetique> cytogenetique) {

		return cytogenetique.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Cytogenetique dtoToEntity(CytogenetiqueDto cytogenetiqueDto) {

		

		Cytogenetique map = new Cytogenetique(cytogenetiqueDto.getNetudeCyto(),cytogenetiqueDto.getLymphocytes(),
				cytogenetiqueDto.getDateSang(),cytogenetiqueDto.getAgentPortant(),cytogenetiqueDto.getInstabilite(),cytogenetiqueDto.getInstabilitePourcentage(),
				cytogenetiqueDto.getIr(),cytogenetiqueDto.getIrPourcentage(),cytogenetiqueDto.getMoelle(),cytogenetiqueDto.getDateMoelle(),cytogenetiqueDto.getResultatMoelle(),
				new Laboratoire(cytogenetiqueDto.getIdLaboratoire()), new Fiche(cytogenetiqueDto.getIdFiche()));

		return map;
	}

	public List<Cytogenetique> dtoToEntity(List<CytogenetiqueDto> cytogenetiqueDto) {

		return cytogenetiqueDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
