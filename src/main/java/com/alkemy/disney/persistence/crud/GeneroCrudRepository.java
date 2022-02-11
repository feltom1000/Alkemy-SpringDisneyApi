package com.alkemy.disney.persistence.crud;

import com.alkemy.disney.persistence.entity.Genero;
import org.springframework.data.repository.CrudRepository;

public interface GeneroCrudRepository extends CrudRepository<Genero, Integer> {
}
