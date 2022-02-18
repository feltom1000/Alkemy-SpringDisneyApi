package com.alkemy.disney.web.controller;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.service.MovieOrSerieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieOrSerieController {
    @Autowired
    MovieOrSerieService movieOrSerieService;

    @GetMapping("/all")
    @ApiOperation("Get all movies or series")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<MovieOrSerie>> getAll(){
        return new ResponseEntity<>(movieOrSerieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/genre")
    @ApiOperation("Filter the movies or series for genre")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie or Serie not found"),
    })
    public ResponseEntity<List<MovieOrSerie>> getByGenre(@RequestParam("genreId") int genreId){
        return movieOrSerieService.getByGenre(genreId)
                .map(movieOrSeries -> new ResponseEntity<>(movieOrSeries, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/title")
    @ApiOperation("Search a movie or serie with the title")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie or Serie not found"),
    })
    public ResponseEntity<List<MovieOrSerie>> getByTitle(@RequestParam("title") String title){
        return movieOrSerieService.getByTitle(title)
                .map(movieOrSeries -> new ResponseEntity<>(movieOrSeries, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/calification")
    @ApiOperation("Filter the movies or series with its calification")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie or Serie not found"),
    })
    public ResponseEntity<List<MovieOrSerie>> getByCalification(@RequestParam("calification") int calification){
        return movieOrSerieService.getByCalification(calification)
                .map(movieOrSeries -> new ResponseEntity<>(movieOrSeries, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Search a movie or serie with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie or Serie not found"),
    })
    public ResponseEntity<MovieOrSerie> getById(@PathVariable("id") int id){
        return movieOrSerieService.getMovieOrSeriesById(id)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a new Movie or Serie")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<MovieOrSerie> save(@RequestBody MovieOrSerie movieOrSerie){
        return new ResponseEntity<>(movieOrSerieService.save(movieOrSerie), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Edit all parameters of a Movie or Serie")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<MovieOrSerie> edit(@PathVariable("id") int id, MovieOrSerie movieOrSerie){
        return new ResponseEntity<>(movieOrSerieService.edit(id,movieOrSerie), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a Movie or Serie with its ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie or Serie not found"),
    })
    public ResponseEntity delete(@PathVariable("id") int id){
        if (movieOrSerieService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
