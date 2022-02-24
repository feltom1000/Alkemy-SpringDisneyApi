package com.alkemy.disney.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "asociaciones")
public class Relaciones {
    @EmbeddedId
    private RelacionesPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("peliculaOrSerieId")
    @JoinColumn(name = "id_pelicula_serie", insertable = false, updatable = false)
    private PeliculaOSerie peliculaOSerie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personajeId")
    @JoinColumn(name = "id_personaje", insertable = false, updatable = false)
    private Personaje personaje;

    public Relaciones() {
        super();
    }

    public Relaciones(RelacionesPK id, PeliculaOSerie peliculaOSerie, Personaje personaje) {
        this.id = id;
        this.peliculaOSerie = peliculaOSerie;
        this.personaje = personaje;
    }

    public RelacionesPK getId() {
        return id;
    }

    public void setId(RelacionesPK id) {
        this.id = id;
    }

    public PeliculaOSerie getPeliculaOSerie() {
        return peliculaOSerie;
    }

    public void setPeliculaOSerie(PeliculaOSerie peliculaOSerie) {
        this.peliculaOSerie = peliculaOSerie;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
