package com.alkemy.disney.domain;

import java.util.List;

public class Character {
    private int id;
    private String img;
    private String name;
    private int age;
    private int weight;
    private String story;

    private List<MovieOrSerie> movieOrSerieList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<MovieOrSerie> getMoviesOrSeriesList() {
        return movieOrSerieList;
    }

    public void setMoviesOrSeriesList(List<MovieOrSerie> movieOrSerieList) {
        this.movieOrSerieList = movieOrSerieList;
    }
}
