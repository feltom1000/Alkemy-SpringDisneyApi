package com.alkemy.disney.domain.service;

import com.alkemy.disney.domain.Character;
import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    public List<Character> getAll(){
        return characterRepository.getAll();
    }

    public Optional<List<Character>> getByName(String name){
        return characterRepository.getByName(name);
    }

    public Optional<List<Character>> getByAge(int age){
        return characterRepository.getByAge(age);
    }

    public Optional<List<Character>> getByMovieOrSeries(String movieOrSerie){
        return characterRepository.getByMovieOrSeries(movieOrSerie);
    }

    public Optional<Character> getCharacterById(int id){
        return characterRepository.getCharacterById(id);
    }

    public Character save(Character character){
        return characterRepository.save(character);
    }

    public Character edit(int id, Character character){
        return characterRepository.edit(character);
    }

    public boolean delete(int characterId){
        if (getCharacterById(characterId).isPresent()){
            characterRepository.delete(characterId);
            return true;
        } else {
            return false;
        }
    }

}
