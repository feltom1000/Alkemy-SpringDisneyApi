package com.alkemy.disney.domain.repository;

import com.alkemy.disney.domain.Character;
import com.alkemy.disney.domain.MoviesOrSeries;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {
    List<Character> getAll();
    Optional<List<Character>> getByGenre(int genreId);
    Optional<List<Character>> getByName(String name);
    Optional<List<Character>> getByAge(int age);
    Optional<List<Character>> getByMovieOrSeries(MoviesOrSeries moviesOrSeries);
    Optional<Character> getCharacterById(int id);
    Character save(Character character);
    Character edit(int id);
    void delete(int characterId);

}