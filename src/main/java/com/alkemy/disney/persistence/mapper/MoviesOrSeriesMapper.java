package com.alkemy.disney.persistence.mapper;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.persistence.entity.PeliculaOSerie;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, RelationsMapper.class})
public interface MoviesOrSeriesMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "imagen", target = "img"),
            @Mapping(source = "titulo", target = "name"),
            @Mapping(source = "fechaDeCreacion", target = "creationDate"),
            @Mapping(source = "calificacion", target = "calification"),
            @Mapping(source = "generoId", target = "genreId"),
            @Mapping(source = "genero", target = "genre"),
            @Mapping(source = "personajes", target = "characters"),
    })
    MovieOrSerie toMovieOrSerie(PeliculaOSerie peliculaOSerie);
    List<MovieOrSerie> toMoviesOrSeries(List<PeliculaOSerie> peliculaOSeries);

    @InheritInverseConfiguration
    PeliculaOSerie toPeliculaOSerie(MovieOrSerie movieOrSerie);
}
