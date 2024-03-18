package org.rhuamani.java.jdbc.repositorio;

import org.rhuamani.java.jdbc.model.Usuario;
import org.rhuamani.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {
            while (rs.next()) {
                Usuario p = crearUsuario(rs);
                usuarios.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


    @Override
    public Usuario porId(Long id) {
        Usuario producto = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearUsuario(rs);
                }
                // rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Usuario usuario) {
        String sql;
        if (usuario.getId() != null && usuario.getId() > 0){
            sql = "UPDATE usuarios SET username = ?, password = ?, email= ? WHERE id = ?";
        } else {
            sql = "INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)";
        }
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());
            if (usuario.getId() != null && usuario.getId() > 0){
                stmt.setLong(4, usuario.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario p = new Usuario();
        p.setId(rs.getLong("id"));
        p.setUsername(rs.getString("username"));
        p.setPassword(rs.getString("password"));
        p.setEmail(rs.getString("email"));
        return p;
    }
}