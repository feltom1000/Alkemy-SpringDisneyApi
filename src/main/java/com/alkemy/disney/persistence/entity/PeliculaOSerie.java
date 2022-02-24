package com.alkemy.disney.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pelicula_serie")
public class PeliculaOSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String imagen;
    private String titulo;

    @Column(name = "fecha_creacion")
    private Date fechaDeCreacion;

    private Integer calificacion;

    @Column(name = "id_genero")
    private Integer generoId;


    @ManyToOne
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "peliculaOSerie", cascade = {CascadeType.ALL})
    private Set<Relaciones> personajes = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return titulo;
    }

    public void setNombre(String nombre) {
        this.titulo = nombre;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Set<Relaciones> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Set<Relaciones> personajes) {
        this.personajes = personajes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaOSerie that = (PeliculaOSerie) o;
        return Objects.equals(id, that.id) && Objects.equals(imagen, that.imagen) && Objects.equals(titulo, that.titulo) && Objects.equals(fechaDeCreacion, that.fechaDeCreacion) && Objects.equals(calificacion, that.calificacion) && Objects.equals(generoId, that.generoId) && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imagen, titulo, fechaDeCreacion, calificacion, generoId, genero);
    }

//    @Override
//    public String toString() {
//        return "PeliculaOSerie{" +
//                "imagen='" + imagen + '\'' +
//                ", titulo='" + titulo + '\'' +
//                ", fechaDeCreacion=" + fechaDeCreacion +
//                '}';
//    }
}
