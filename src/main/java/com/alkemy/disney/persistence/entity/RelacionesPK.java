package com.alkemy.disney.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelacionesPK implements Serializable {

    @Column(name = "id_pelicula_serie")
    private Integer peliculaOrSerieId;

    @Column(name = "id_personaje")
    private Integer personajeId;

    public RelacionesPK() {
        super();
    }

    public RelacionesPK(Integer peliculaOrSerieId, Integer personajeId) {
        this.peliculaOrSerieId = peliculaOrSerieId;
        this.personajeId = personajeId;
    }

    public Integer getPeliculaOrSerieId() {
        return peliculaOrSerieId;
    }

    public void setPeliculaOrSerieId(Integer peliculaOrSerieId) {
        this.peliculaOrSerieId = peliculaOrSerieId;
    }

    public Integer getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(Integer personajeId) {
        this.personajeId = personajeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelacionesPK that = (RelacionesPK) o;
        return Objects.equals(peliculaOrSerieId, that.peliculaOrSerieId) && Objects.equals(personajeId, that.personajeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peliculaOrSerieId, personajeId);
    }
}
