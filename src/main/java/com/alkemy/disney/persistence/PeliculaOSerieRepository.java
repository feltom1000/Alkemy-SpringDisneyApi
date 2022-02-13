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
        return null;
    }

    @Override
    public Optional<List<MovieOrSerie>> getByGenre(int genreId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<MovieOrSerie>> getByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<List<MovieOrSerie>> getByCalification(int calification) {
        return Optional.empty();
    }

    @Override
    public Optional<List<MovieOrSerie>> getByCreationDate(Date creationDate) {
        return Optional.empty();
    }

    @Override
    public Optional<MovieOrSerie> getMovieOrSeriesById(int Id) {
        return Optional.empty();
    }

    @Override
    public MovieOrSerie save(MovieOrSerie movieOrSerie) {
        return null;
    }

    @Override
    public MovieOrSerie edit(MovieOrSerie movieOrSerie) {
        return null;
    }

    @Override
    public void delete(int movieOrSeriesId) {

    }
}
