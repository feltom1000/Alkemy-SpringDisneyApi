package com.alkemy.disney.domain.service;

import com.alkemy.disney.domain.Genre;
import com.alkemy.disney.domain.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public List<Genre> getAll(){
        return genreRepository.getAll();
    }

    public Optional<Genre> getGenre(int genreId){
        return genreRepository.getGenre(genreId);
    }

    public Genre save(Genre genre){
        return genreRepository.save(genre);
    }

    public boolean delete(int genreId){
        if (getGenre(genreId).isPresent()){
            genreRepository.delete(genreId);
            return true;
        } else {
            return false;
        }
    }

}
