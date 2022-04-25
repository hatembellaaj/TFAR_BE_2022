package com.getaf.tfar.converter;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.getaf.tfar.domain.dto.FicheDto;
import com.getaf.tfar.domain.entity.Fiche;
@Mapper(componentModel = "spring")
public interface FicheConverter extends IEntityMapper<FicheDto, Fiche>{

	FicheDto toDto(final Fiche fiche);

    List<FicheDto> toDto(final List<Fiche> fiche);


    Fiche toEntity(final FicheDto ficheDto);

    List<Fiche> toEntity(final List <FicheDto> fichedtos);


}
