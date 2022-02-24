package com.alkemy.disney.persistence;

import com.alkemy.disney.domain.Character;
import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.repository.CharacterRepository;
import com.alkemy.disney.persistence.crud.PersonajeCrudRepository;
import com.alkemy.disney.persistence.entity.Personaje;
import com.alkemy.disney.persistence.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonajeRepository implements CharacterRepository {
    @Autowired
    private PersonajeCrudRepository personajeCrudRepository;
    @Autowired
    private CharacterMapper mapper;


    @Override
    public List<Character> getAll() {
        return mapper.toCharacters((List<Personaje>) personajeCrudRepository.findAll());
    }


    @Override
    public Optional<List<Character>> getByName(String nombre) {
        return personajeCrudRepository.findByNombre(nombre)
                .map(personajes -> mapper.toCharacters(personajes));
    }

    @Override
    public Optional<List<Character>> getByAge(int edad) {
        return personajeCrudRepository.findByEdad(edad)
                .map(personajes -> mapper.toCharacters(personajes));
    }

    @Override
    public Optional<List<Character>> getByMovieOrSeries(String movieOrSerie) {
        return personajeCrudRepository.findByPeliculasOSeriesAsociadas(movieOrSerie)
                .map(personajes -> mapper.toCharacters(personajes));
    }

    @Override
    public Optional<Character> getCharacterById(int id) {
        Optional<Personaje> personajes = personajeCrudRepository.findById(id);
        return personajes.map(personaje -> mapper.toCharacter(personaje));

    }

    @Override
    public Character save(Character character) {
        Personaje personaje = mapper.toPersonaje(character);
        return mapper.toCharacter(personajeCrudRepository.save(personaje));
    }

    @Override
    public Character edit(Character character) {
    personajeCrudRepository.editImagenById(character.getImg(), character.getId());
    personajeCrudRepository.editNombreById(character.getName(), character.getId());
    personajeCrudRepository.editPesoById(character.getWeight(), character.getId());
    personajeCrudRepository.editEdadById(character.getAge(), character.getId());
    personajeCrudRepository.editHistoriaById(character.getStory(), character.getId());

    return character;
    }

    @Override
    public void delete(int characterId) {
        personajeCrudRepository.deleteById(characterId);
    }
}
