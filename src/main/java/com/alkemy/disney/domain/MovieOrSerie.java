package com.alkemy.disney.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class MovieOrSerie {
    private int id;
    private String img;
    private String name;
    private Date creationDate;
    private int calification;

    private int genreId;

    private Genre genre;
    private Set<Relations> characters;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Relations> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Relations> characters) {
        this.characters = characters;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }
}
