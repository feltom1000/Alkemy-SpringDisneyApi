package com.alkemy.disney.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imagen;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private String historia;

    @OneToMany(mappedBy = "personaje", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Set<Relaciones> peliculasOSeriesAsociadas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<Relaciones> getPeliculasOSeriesAsociadas() {
        return peliculasOSeriesAsociadas;
    }

    public void setPeliculasOSeriesAsociadas(Set<Relaciones> peliculasOSeriesAsociadas) {
        this.peliculasOSeriesAsociadas = peliculasOSeriesAsociadas;
    }

//    @Override
//    public String toString() {
//        return "Personaje{" +
//                "imagen='" + imagen + '\'' +
//                ", nombre='" + nombre + '\'' +
//                '}';
//    }
}
