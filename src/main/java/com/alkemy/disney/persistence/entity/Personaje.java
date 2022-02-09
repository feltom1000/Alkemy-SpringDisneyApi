package com.alkemy.disney.persistence.entity;

import javax.persistence.*;

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


}
