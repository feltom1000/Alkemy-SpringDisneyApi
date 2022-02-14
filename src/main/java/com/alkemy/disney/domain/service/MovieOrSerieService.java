package com.alkemy.disney.domain.service;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.repository.MoviesOrSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieOrSerieService {
    @Autowired
    MoviesOrSeriesRepository moviesOrSeriesRepository;

    public List<MovieOrSerie> getAll(){
        return moviesOrSeriesRepository.getAll();
    }

    public Optional<List<MovieOrSerie>> getByGenre(int genreId){
        return moviesOrSeriesRepository.getByGenre(genreId);
    }

    public Optional<List<MovieOrSerie>> getByTitle(String title){
        return moviesOrSeriesRepository.getByTitle(title);
    }

    public Optional<List<MovieOrSerie>> getByCalification(int calification){
        return moviesOrSeriesRepository.getByCalification(calification);
    }

    public Optional<List<MovieOrSerie>> getByCreationDate(Date creationDate){
        return moviesOrSeriesRepository.getByCreationDate(creationDate);
    }

    public Optional<MovieOrSerie> getMovieOrSeriesById(int id){
        return moviesOrSeriesRepository.getMovieOrSeriesById(id);
    }

    public MovieOrSerie save(MovieOrSerie movieOrSerie){
        return moviesOrSeriesRepository.save(movieOrSerie);
    }

    public MovieOrSerie edit(MovieOrSerie movieOrSerie){
        return moviesOrSeriesRepository.edit(movieOrSerie);
    }

    public boolean delete(int movieOrSeriesId){
        if(getMovieOrSeriesById(movieOrSeriesId).isPresent()){
            moviesOrSeriesRepository.delete(movieOrSeriesId);
            return true;
        } else {
            return false;
        }
    }

}
