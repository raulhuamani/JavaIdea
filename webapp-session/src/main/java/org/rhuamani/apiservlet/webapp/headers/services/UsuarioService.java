package org.rhuamani.apiservlet.webapp.headers.services;

import org.rhuamani.apiservlet.webapp.headers.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}