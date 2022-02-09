package com.alkemy.disney.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AsociacionesPK implements Serializable {

    @Column(name = "id_pelicula_serie")
    private Integer peliculaOSeriesId;

    @Column(name = "id_genero")
    private Integer generoId;

    @Column(name = "id_personaje")
    private Integer personajeId;


    public Integer getPeliculaOSeriesId() {
        return peliculaOSeriesId;
    }

    public void setPeliculaOSeriesId(Integer peliculaOSeriesId) {
        this.peliculaOSeriesId = peliculaOSeriesId;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public Integer getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(Integer personajeId) {
        this.personajeId = personajeId;
    }
}
