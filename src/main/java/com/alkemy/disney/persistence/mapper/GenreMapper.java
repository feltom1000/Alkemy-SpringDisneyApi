package com.alkemy.disney.persistence.mapper;

import com.alkemy.disney.domain.Genre;
import com.alkemy.disney.persistence.entity.Genero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "img", target = "imagen"),
            @Mapping(source = "peliculaOSeries", target = "moviesOrSeriesList")
    })
    Genre toGenre(Genero genero);
    List<Genre> toGenres(Genero genero);

    @InheritInverseConfiguration
    Genero toGenero(Genre genre);
}