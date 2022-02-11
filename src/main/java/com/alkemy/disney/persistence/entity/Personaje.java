package com.alkemy.disney.persistence.entity;

import javax.persistence.*;
import java.util.List;

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

    @JoinTable(
            name = "asociaciones",
            joinColumns = @JoinColumn(name = "id_personaje", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_pelicula_serie", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PeliculaOSerie> peliculasOSeriesAsociadas;


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

    public List<PeliculaOSerie> getPeliculasOSeriesAsociadas() {
        return peliculasOSeriesAsociadas;
    }

    public void setPeliculasOSeriesAsociadas(List<PeliculaOSerie> peliculasOSeriesAsociadas) {
        this.peliculasOSeriesAsociadas = peliculasOSeriesAsociadas;
    }
}
