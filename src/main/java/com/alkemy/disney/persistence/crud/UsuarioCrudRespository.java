package com.alkemy.disney.persistence.crud;

import com.alkemy.disney.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCrudRespository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
