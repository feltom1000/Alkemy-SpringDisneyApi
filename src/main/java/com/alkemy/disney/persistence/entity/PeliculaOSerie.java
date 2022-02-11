package com.alkemy.disney.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pelicula_serie")
public class PeliculaOSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String imagen;

    @Column(name = "id_genero")
    private Integer generoId;

    @ManyToOne
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;

    @ManyToMany(mappedBy = "peliculasOSeriesAsociadas")
    private List<Personaje> personajes;


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

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
}
