package com.alkemy.disney.persistence.crud;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.persistence.entity.PeliculaOSerie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PeliculaOSerieCrudRepository extends CrudRepository<PeliculaOSerie, Integer> {
    Optional<List<MovieOrSerie>> getByGeneroId(int genreId);
    Optional<List<MovieOrSerie>> getBy
}

//    List<MovieOrSerie> getAll();
//    Optional<List<MovieOrSerie>> getByGenre(int genreId);
//    Optional<List<MovieOrSerie>> getByTitle(String title);
//    Optional<List<MovieOrSerie>> getByCalification(int calification);
//    Optional<List<MovieOrSerie>> getByCreationDate(Date creationDate);
//    Optional<MovieOrSerie> getMovieOrSeriesById(int Id);
//    MovieOrSerie save(MovieOrSerie movieOrSerie);
//    MovieOrSerie edit(MovieOrSerie movieOrSerie);
//    void delete(int movieOrSeriesId);

//Optional<List<Personaje>> findByNombre(String nombre);
//    Optional<List<Personaje>> findByEdad(int edad);
//    Optional<List<Personaje>> findByPeliculasOSeriesAsociadas(MovieOrSerie movieOrSerie);
//
//    @Modifying
//    @Query(value = "UPDATE personaje u SET u.imagen = ?1 WHERE u.id = ?2", nativeQuery = true)
//    Personaje editImagenById(String img, int id);
//
//    @Modifying
//    @Query(value = "UPDATE personaje u SET u.nombre = ?1 WHERE u.id = ?2", nativeQuery = true)
//    Personaje editNombreById(String nombre, int id);
//
//    @Modifying
//    @Query(value = "UPDATE personaje u SET u.edad = ?1 WHERE u.id = ?2", nativeQuery = true)
//    Personaje editEdadById(Integer edad, int id);
//
//    @Modifying
//    @Query(value = "UPDATE personaje u SET u.peso = ?1 WHERE u.id = ?2", nativeQuery = true)
//    Personaje editPesoById(Integer peso, int id);
//
//    @Modifying
//    @Query(value = "UPDATE personaje u SET u.historia = ?1 WHERE u.id = ?2", nativeQuery = true)
//    Personaje editHistoriaById(String historia, int id);