package com.alkemy.disney.domain.service;

import com.alkemy.disney.domain.repository.UsuarioRepository;
import com.alkemy.disney.persistence.crud.UsuarioCrudRespository;
import com.alkemy.disney.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioRepository {
    @Autowired
    UsuarioCrudRespository usuarioCrudRespository;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioCrudRespository.findByUsername(username);
    }
}
