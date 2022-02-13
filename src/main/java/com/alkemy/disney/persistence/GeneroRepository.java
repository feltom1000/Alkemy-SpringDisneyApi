package com.alkemy.disney.persistence;

import com.alkemy.disney.domain.Genre;
import com.alkemy.disney.domain.repository.GenreRepository;
import com.alkemy.disney.persistence.crud.GeneroCrudRepository;
import com.alkemy.disney.persistence.entity.Genero;
import com.alkemy.disney.persistence.entity.Personaje;
import com.alkemy.disney.persistence.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GeneroRepository implements GenreRepository {
    @Autowired
    GeneroCrudRepository generoCrudRepository;
    @Autowired
    GenreMapper mapper;

    @Override
    public List<Genre> getAll() {
        return mapper.toGenres((List<Genero>) generoCrudRepository.findAll());
    }

    @Override
    public Optional<Genre> getGenre(int genreId) {
        Optional<Genero> generos = generoCrudRepository.findById(genreId);
        return generos.map(genero -> mapper.toGenre(genero));
    }

    @Override
    public Genre save(Genre genre) {
        Genero genero = mapper.toGenero(genre);
        return mapper.toGenre(generoCrudRepository.save(genero));
    }

    @Override
    public void delete(int genreId) {
        generoCrudRepository.deleteById(genreId);
    }
}