package com.alkemy.disney.persistence.mapper;

import com.alkemy.disney.domain.Relations;
import com.alkemy.disney.persistence.entity.Relaciones;
import org.mapstruct.*;

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
    Relaciones toRelaciones(Relations relations);
}
