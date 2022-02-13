package com.alkemy.disney.domain.repository;

import com.alkemy.disney.domain.Character;
import com.alkemy.disney.domain.MovieOrSerie;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {
    List<Character> getAll();
    Optional<List<Character>> getByName(String name);
    Optional<List<Character>> getByAge(int age);
    Optional<List<Character>> getByMovieOrSeries(MovieOrSerie movieOrSerie);
    Optional<Character> getCharacterById(int id);
    Character save(Character character);
    Character edit(Character character);
    void delete(int characterId);

}
