package com.alkemy.disney.domain;

import java.util.List;

public class Genre {
    private int id;
    private String name;
    private String img;

    private List<MovieOrSerie> movieOrSerieList;


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

    public List<MovieOrSerie> getMoviesOrSeriesList() {
        return movieOrSerieList;
    }

    public void setMoviesOrSeriesList(List<MovieOrSerie> movieOrSerieList) {
        this.movieOrSerieList = movieOrSerieList;
    }
}
