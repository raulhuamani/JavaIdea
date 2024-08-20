package org.rhuamani.apiservlet.webapp.headers.services;

import org.rhuamani.apiservlet.webapp.headers.models.Categoria;
import org.rhuamani.apiservlet.webapp.headers.repositories.CategoriaRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceImpl implements CategoriaService {
    private CategoriaRepositoryImpl categoriaRepository;

    public CategoriaServiceImpl(Connection conn) {
        this.categoriaRepository = new CategoriaRepositoryImpl(conn);
    }

    @Override
    public List<Categoria> listar() {
        try {
            return categoriaRepository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> porNombre(String nombre) {
        try {
            return categoriaRepository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> porId(Long id) {
        try {
            return Optional.ofNullable(categoriaRepository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Categoria categoria) {
        try {
            categoriaRepository.guardar(categoria);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            categoriaRepository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}