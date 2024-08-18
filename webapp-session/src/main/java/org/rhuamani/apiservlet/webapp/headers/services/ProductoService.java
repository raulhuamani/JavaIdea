package org.rhuamani.apiservlet.webapp.headers.services;

import org.rhuamani.apiservlet.webapp.headers.models.Categoria;
import org.rhuamani.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
    List<Producto> porNombre(String nombre);

    void guardar(Producto producto);
    void eliminar(Long id);

    List<Categoria> listarCategoria();
    Optional<Categoria> porIdCategoria(Long id);
}