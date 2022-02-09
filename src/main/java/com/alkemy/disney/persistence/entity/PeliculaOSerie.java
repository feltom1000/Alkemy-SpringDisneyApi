package com.alkemy.disney.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "pelicula_serie")
public class PeliculaOSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String imagen;
}
