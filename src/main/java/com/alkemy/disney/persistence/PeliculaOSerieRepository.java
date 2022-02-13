package com.alkemy.disney.persistence;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.repository.MoviesOrSeriesRepository;
import com.alkemy.disney.persistence.crud.PeliculaOSerieCrudRepository;
import com.alkemy.disney.persistence.entity.PeliculaOSerie;
import com.alkemy.disney.persistence.mapper.MoviesOrSeriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaOSerieRepository implements MoviesOrSeriesRepository {
    @Autowired
    PeliculaOSerieCrudRepository peliculaOSerieCrudRepository;
    @Autowired
    MoviesOrSeriesMapper mapper;


    @Override
    public List<MovieOrSerie> getAll() {
        return mapper.toMoviesOrSeries((List<PeliculaOSerie>) peliculaOSerieCrudRepository.findAll());
    }

    @Override
    public Optional<List<MovieOrSerie>> getByGenre(int genreId) {
        return peliculaOSerieCrudRepository.findByGeneroId(genreId)
                .map(peliculasOSeries -> mapper.toMoviesOrSeries(peliculasOSeries));
    }

    @Override
    public Optional<List<MovieOrSerie>> getByTitle(String title) {
        return peliculaOSerieCrudRepository.findByTitulo(title)
                .map(peliculasOSeries -> mapper.toMoviesOrSeries(peliculasOSeries));
    }

    @Override
    public Optional<List<MovieOrSerie>> getByCalification(int calification) {
        return peliculaOSerieCrudRepository.findByCalificacion(calification)
                .map(peliculaOSeries -> mapper.toMoviesOrSeries(peliculaOSeries));
    }

    @Override
    public Optional<List<MovieOrSerie>> getByCreationDate(Date creationDate) {
        return peliculaOSerieCrudRepository.findByFechaDeCreacion(creationDate)
                .map(peliculaOSeries -> mapper.toMoviesOrSeries(peliculaOSeries));
    }

    @Override
    public Optional<MovieOrSerie> getMovieOrSeriesById(int id) {
        Optional<PeliculaOSerie> peliculaOSerie = peliculaOSerieCrudRepository.findById(id);
        return peliculaOSerie.map(peliculaOSerie1 -> mapper.toMovieOrSerie(peliculaOSerie1));
    }

    @Override
    public MovieOrSerie save(MovieOrSerie movieOrSerie) {
        PeliculaOSerie peliculaOSerie = mapper.toPeliculaOSerie(movieOrSerie);
        return mapper.toMovieOrSerie(peliculaOSerieCrudRepository.save(peliculaOSerie));
    }

    @Override
    public MovieOrSerie edit(MovieOrSerie movieOrSerie) {
        peliculaOSerieCrudRepository.editTituloById(movieOrSerie.getTitle(), movieOrSerie.getId());
        peliculaOSerieCrudRepository.editCalificacionById(movieOrSerie.getCalification(), movieOrSerie.getId());
        peliculaOSerieCrudRepository.editFechaDeCreacionById(movieOrSerie.getCreationDate(), movieOrSerie.getId());
        peliculaOSerieCrudRepository.editImagenById(movieOrSerie.getImg(), movieOrSerie.getId());
        peliculaOSerieCrudRepository.editIdGeneroById(movieOrSerie.getGenreId(), movieOrSerie.getId());

        return movieOrSerie;
    }

    @Override
    public void delete(int movieOrSeriesId) {
    peliculaOSerieCrudRepository.deleteById(movieOrSeriesId);
    }
}
