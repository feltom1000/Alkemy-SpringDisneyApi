package com.alkemy.disney.persistence.mapper;

import com.alkemy.disney.domain.Relations;
import com.alkemy.disney.persistence.entity.Relaciones;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {MoviesOrSeriesMapper.class, CharacterMapper.class})
public interface RelationsMapper {

    @Mappings({
            @Mapping(source = "id.peliculaOrSerieId", target = "characterId"),
            @Mapping(source = "id.personajeId", target = "movieOrSerieId"),
            @Mapping(source = "peliculaOSerie", target = "movieOrSerie"),
            @Mapping(source = "personaje", target = "character")

    })
    Relations toRelations(Relaciones relaciones);

    @InheritInverseConfiguration
//    @Mappings({
//            @Mapping(target = "peliculaOSerie", ignore = true),
//            @Mapping(target = "personaje", ignore = true)
//    })
    Relaciones toRelaciones(Relations relations);
}
