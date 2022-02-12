package com.alkemy.disney.domain.repository;

import com.alkemy.disney.domain.MovieOrSerie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MoviesOrSeriesRepository {
    List<MovieOrSerie> getAll();
    Optional<List<MovieOrSerie>> getByGenre(int genreId);
    Optional<List<MovieOrSerie>> getByTitle(String title);
    Optional<List<MovieOrSerie>> getByCalification(int calification);
    Optional<List<MovieOrSerie>> getByCreationDate(Date creationDate);
    Optional<MovieOrSerie> getMovieOrSeriesById(int Id);
    MovieOrSerie save(MovieOrSerie movieOrSerie);
    MovieOrSerie edit(MovieOrSerie movieOrSerie);
    void delete(int movieOrSeriesId);
}
