package com.alkemy.disney.persistence.crud;

import com.alkemy.disney.domain.MovieOrSerie;
import com.alkemy.disney.persistence.entity.Personaje;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajeCrudRepository extends CrudRepository<Personaje, Integer> {
    Optional<List<Personaje>> findByIdGenero(int generoId);
    Optional<List<Personaje>> findByName(String name);
    Optional<List<Personaje>> findByAge(int age);
    Optional<List<Personaje>> findByPeliculasOSeriesAsociadas(MovieOrSerie movieOrSerie);

    @Modifying
    @Query(value = "UPDATE personaje u SET u.imagen = ?1 WHERE u.id = ?2")
    Personaje editImagenById(String img, int id);

    @Modifying
    @Query(value = "UPDATE personaje u SET u.nombre = ?1 WHERE u.id = ?2")
    Personaje editNombreById(String nombre, int id);

    @Modifying
    @Query(value = "UPDATE personaje u SET u.edad = ?1 WHERE u.id = ?2")
    Personaje editEdadById(int edad, int id);

    @Modifying
    @Query(value = "UPDATE personaje u SET u.peso = ?1 WHERE u.id = ?2")
    Personaje editPesoById(int peso, int id);

    @Modifying
    @Query(value = "UPDATE personaje u SET u.historia = ?1 WHERE u.id = ?2")
    Personaje editHistoriaById(String historia, int id);
}
