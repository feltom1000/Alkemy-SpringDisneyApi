package com.alkemy.disney.web.controller;

import com.alkemy.disney.domain.Character;
import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.domain.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping("/all")
    public ResponseEntity<List<Character>> getAll(){
        return new ResponseEntity<>(characterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Character>> getByName(@PathVariable("name") String name){
        return characterService.getByName(name)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Character>> getByAge(@PathVariable("age") int age){
        return characterService.getByAge(age)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/movie-or-series/{movieOrSerie}")
    public ResponseEntity<List<Character>> getByMovieOrSeries(@PathVariable("movieOrSerie") String movieOrSerie){
        return characterService.getByMovieOrSeries(movieOrSerie)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable("id") int id){
        return characterService.getCharacterById(id)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Character> save(@RequestBody Character character){
        return new ResponseEntity<>(characterService.save(character), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Character> edit(@PathVariable int id, @RequestBody Character character){
        return new ResponseEntity<>(characterService.edit(id, character), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int characterId){
        if (characterService.delete(characterId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
