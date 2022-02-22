package com.alkemy.disney.domain;

public class Relations {
    private int characterId;
    private int movieOrSerieId;
    private Character character;
    private MovieOrSerie movieOrSerie;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getMovieOrSerieId() {
        return movieOrSerieId;
    }

    public void setMovieOrSerieId(int movieOrSerieId) {
        this.movieOrSerieId = movieOrSerieId;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public MovieOrSerie getMovieOrSerie() {
        return movieOrSerie;
    }

    public void setMovieOrSerie(MovieOrSerie movieOrSerie) {
        this.movieOrSerie = movieOrSerie;
    }
}
