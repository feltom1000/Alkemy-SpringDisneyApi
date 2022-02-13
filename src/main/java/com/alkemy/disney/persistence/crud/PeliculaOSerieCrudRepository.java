package com.alkemy.disney.persistence.crud;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.persistence.entity.PeliculaOSerie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PeliculaOSerieCrudRepository extends CrudRepository<PeliculaOSerie, Integer> {
    Optional<List<PeliculaOSerie>> findByGeneroId(int genreId);
    Optional<List<PeliculaOSerie>> findByTitulo(String titulo);
    Optional<List<PeliculaOSerie>> findByCalificacion(int calificacion);
    Optional<List<PeliculaOSerie>> findByFechaDeCreacion(Date fecha);

    @Modifying
    @Query(value = "UPDATE pelicula_serie u SET u.imagen = ?1 WHERE u.id = ?2", nativeQuery = true)
    PeliculaOSerie editImagenById(String img, int id);

    @Modifying
    @Query(value = "UPDATE pelicula_serie u SET u.titulo = ?1 WHERE u.id = ?2", nativeQuery = true)
    PeliculaOSerie editTituloById(String titulo, int id);

    @Modifying
    @Query(value = "UPDATE pelicula_serie u SET u.fecha_creacion = ?1 WHERE u.id = ?2", nativeQuery = true)
    PeliculaOSerie editFechaDeCreacionById(Date fecha, int id);

    @Modifying
    @Query(value = "UPDATE pelicula_serie u SET u.calificacion = ?1 WHERE u.id = ?2", nativeQuery = true)
    PeliculaOSerie editCalificacionById(int calificacion, int id);

    @Modifying
    @Query(value = "UPDATE pelicula_serie u SET u.id_genero = ?1 WHERE u.id = ?2", nativeQuery = true)
    PeliculaOSerie editIdGeneroById(int idGenero, int id);
}