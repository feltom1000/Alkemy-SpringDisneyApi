package com.alkemy.disney.domain.repository;

import com.alkemy.disney.domain.Genre;
import com.alkemy.disney.domain.MoviesOrSeries;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Optional<List<Genre>> getAll();
    Optional<Genre> getGenre(int genreId);
    Genre save(Genre genre);
    void delete(int genreId);

}
