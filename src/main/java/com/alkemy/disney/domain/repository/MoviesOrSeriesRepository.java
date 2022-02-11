package com.alkemy.disney.domain.repository;

import com.alkemy.disney.domain.MoviesOrSeries;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MoviesOrSeriesRepository {
    List<MoviesOrSeries> getAll();
    Optional<List<MoviesOrSeries>> getByGenre(int genreId);
    Optional<List<MoviesOrSeries>> getByTitle(String title);
    Optional<List<MoviesOrSeries>> getByCalification(int calification);
    Optional<List<MoviesOrSeries>> getByCreationDate(Date creationDate);
    Optional<MoviesOrSeries> getMovieOrSeriesById(int Id);
    MoviesOrSeries save(MoviesOrSeries moviesOrSeries);
    MoviesOrSeries edit(MoviesOrSeries moviesOrSeries);
    void delete(int movieOrSeriesId);
}
