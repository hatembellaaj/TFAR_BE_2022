package tn.tfar.forms.converter;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tn.tfar.forms.domain.dto.FicheDto;
import tn.tfar.forms.domain.entity.Fiche;


@Mapper(componentModel = "spring")
public interface FicheConverter extends IEntityMapper<FicheDto, Fiche>{
	@Mapping(source="user.code", target="codeUser")
	FicheDto toDto(final Fiche fiche);

    List<FicheDto> toDto(final List<Fiche> fiche);

    @Mapping(source="codeUser", target="user.code")
    Fiche toEntity(final FicheDto ficheDto);

    List<Fiche> toEntity(final List <FicheDto> fichedtos);

    default Fiche fromId(final Long idFiche) {
        if (idFiche == null) {
            return null;
        }
        final Fiche fiche=new Fiche();
        fiche.setIdFiche(idFiche);
        return fiche;
    }
	
}
