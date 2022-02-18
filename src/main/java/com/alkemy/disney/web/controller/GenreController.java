package com.alkemy.disney.web.controller;

import com.alkemy.disney.domain.Genre;
import com.alkemy.disney.domain.service.GenreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("/all")
    @ApiOperation("Get all genres at once")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Genre>> getAll(){
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/genre/{id}")
    @ApiOperation("Search a genre with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Genre not found"),
    })
    public ResponseEntity<Genre> getGenre(@PathVariable("id") int id){
        return genreService.getGenre(id)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a new genre")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<Genre> save(@RequestBody Genre genre){
        return new ResponseEntity<>(genreService.save(genre), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a genre with its ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Genre not found"),
    })
    public ResponseEntity delete(@PathVariable("id") int id){
        if (genreService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
