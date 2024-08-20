package org.rhuamani.apiservlet.webapp.headers.services;

import org.rhuamani.apiservlet.webapp.headers.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> listar();

    List<Categoria> porNombre(String nombre);

    Optional<Categoria> porId(Long id);

    void guardar(Categoria categoria);

    void eliminar(Long id);
}