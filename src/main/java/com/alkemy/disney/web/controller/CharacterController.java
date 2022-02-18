package com.alkemy.disney.web.controller;

import com.alkemy.disney.domain.Character;
import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.service.CharacterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping("/all")
    @ApiOperation("Get all characters")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Character>> getAll(){
        return new ResponseEntity<>(characterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/name")
    @ApiOperation("Search a character with the name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Character not found"),
    })
    public ResponseEntity<List<Character>> getByName(@RequestParam("name") String name){
        return characterService.getByName(name)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/age")
    @ApiOperation("Search a character with an age")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Character not found"),
    })
    public ResponseEntity<List<Character>> getByAge(@RequestParam("age") int age){
        return characterService.getByAge(age)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/movies")
    @ApiOperation("Search a character with the movies or series asociated")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Character not found"),
    })
    public ResponseEntity<List<Character>> getByMovieOrSeries(@RequestParam("movieOrSerie") String movieOrSerie){
        return characterService.getByMovieOrSeries(movieOrSerie)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Search a character with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Character not found"),
    })
    public ResponseEntity<Character> getCharacterById(@PathVariable("id") int id){
        return characterService.getCharacterById(id)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a new character")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<Character> save(@RequestBody Character character){
        return new ResponseEntity<>(characterService.save(character), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Edit all parameters of a character")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Character> edit(@PathVariable int id, @RequestBody Character character){
        return new ResponseEntity<>(characterService.edit(id, character), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a character with its ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Character not found"),
    })
    public ResponseEntity delete(@PathVariable("id") int characterId){
        if (characterService.delete(characterId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
