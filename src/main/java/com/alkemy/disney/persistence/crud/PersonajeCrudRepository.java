package com.alkemy.disney.persistence.crud;

import com.alkemy.disney.persistence.entity.Personaje;
import org.springframework.data.repository.CrudRepository;

public interface PersonajeCrudRepository extends CrudRepository<Personaje, Integer> {
}
