package org.rhuamani.java.jdbc;

import org.rhuamani.java.jdbc.model.Categoria;
import org.rhuamani.java.jdbc.model.Producto;
import org.rhuamani.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.rhuamani.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rhuamani.java.jdbc.repositorio.Repositorio;
import org.rhuamani.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                System.out.println("=========== Insertar nueva categoria ===========");
                Categoria categoria = new Categoria();
                categoria.setNombre("Electrodomesticos");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardada con exito: " + nuevaCategoria.getId());

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                System.out.println("=========== Listar ===========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("=========== Obtener por Id ===========");
                System.out.println(repositorio.porId(1L));

                System.out.println("=========== Insertar nuevo producto ===========");
                Producto producto = new Producto();
                producto.setNombre("Refrigerador Samsung");
                producto.setPrecio(9900);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcdefg123");
                producto.setCategoria(nuevaCategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito: " + producto.getId());
                repositorio.listar().forEach(System.out::println);

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}