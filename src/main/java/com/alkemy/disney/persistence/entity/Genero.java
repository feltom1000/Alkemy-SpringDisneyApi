package com.alkemy.disney.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String imagen;
}
