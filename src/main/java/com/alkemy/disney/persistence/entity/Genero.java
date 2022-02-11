package com.alkemy.disney.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String imagen;

    @OneToMany(mappedBy = "genero")
    private List<PeliculaOSerie> peliculaOSeries;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<PeliculaOSerie> getPeliculaOSeries() {
        return peliculaOSeries;
    }

    public void setPeliculaOSeries(List<PeliculaOSerie> peliculaOSeries) {
        this.peliculaOSeries = peliculaOSeries;
    }
}
