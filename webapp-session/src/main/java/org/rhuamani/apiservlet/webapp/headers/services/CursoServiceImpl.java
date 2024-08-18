package org.rhuamani.apiservlet.webapp.headers.services;

import org.rhuamani.apiservlet.webapp.headers.models.Curso;
import org.rhuamani.apiservlet.webapp.headers.repositories.CursoRepositorioImpl;
import org.rhuamani.apiservlet.webapp.headers.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoServiceImpl implements CursoService {

    private Repository<Curso> repository;

    public CursoServiceImpl(Connection connection) {
        this.repository = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {
        try {
            return Optional.ofNullable(repository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            repository.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}