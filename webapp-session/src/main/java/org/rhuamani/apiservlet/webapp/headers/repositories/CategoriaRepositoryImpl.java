package org.rhuamani.apiservlet.webapp.headers.repositories;

import org.rhuamani.apiservlet.webapp.headers.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImpl implements Repository<Categoria> {
    private Connection conn;

    public CategoriaRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categorias c")) {
            while (rs.next()) {
                Categoria categoria = getCategoria(rs);
                categorias.add(categoria);
            }

        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement stmst = conn.prepareStatement("SELECT * FROM categorias c WHERE c.id = ? ")) {
            stmst.setLong(1, id);
            try (ResultSet rs = stmst.executeQuery()) {
                if (rs.next()) {
                    categoria = getCategoria(rs);
                }
            }
        return categoria;
        }
    }

    @Override
    public List<Categoria> porNombre(String nombre) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        try ( PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias c WHERE c.nombre like ? ")) {
            stmt.setString(1, "%" + nombre + "%");

            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    categorias.add(getCategoria(rs));
                }
            }
        }

        return categorias;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        String sql;
        if (categoria.getId() != null && categoria.getId() > 0) {
            sql = "update categorias set nombre=? where id=?";
        } else {
            sql = "insert into categorias (nombre) values (?)";
        }
        try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());

            if (categoria.getId() != null && categoria.getId() > 0) {
                stmt.setLong(2, categoria.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from categorias where id=?";
        try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNombre(rs.getString("nombre"));
        categoria.setId(rs.getLong("id"));
        return categoria;
    }
}