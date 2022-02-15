package com.alkemy.disney.domain.repository;

import com.alkemy.disney.persistence.entity.Usuario;

public interface UsuarioRepository {
    public Usuario findByUsername(String username);
}
