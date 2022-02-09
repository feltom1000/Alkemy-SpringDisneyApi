package com.alkemy.disney.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "asociaciones")
public class Asociaciones {

    @Embedded
    private AsociacionesPK id;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private PeliculaOSerie peliculaOSerie;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Personaje personaje;
}
