package org.rhuamani.java.jdbc;

import org.rhuamani.java.jdbc.model.Categoria;
import org.rhuamani.java.jdbc.model.Producto;
import org.rhuamani.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rhuamani.java.jdbc.repositorio.Repositorio;
import org.rhuamani.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getInstance()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
                System.out.println("=========== Listar ===========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("=========== Obtener por Id ===========");
                System.out.println(repositorio.porId(1L));

                System.out.println("=========== Insertar nuevo producto ===========");
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM mecanico");
                producto.setPrecio(1550);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                producto.setSku("abcde12345");
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");
                repositorio.listar().forEach(System.out::println);

                System.out.println("=========== editar producto ===========");
                producto = new Producto();
                producto.setId(5L);
                producto.setNombre("Teclado Corsair k95 mecanico");
                producto.setPrecio(1000);
                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);
                producto.setSku("abcdef1234");
                repositorio.guardar(producto);
                System.out.println("Producto editado con exito");

                repositorio.listar().forEach(System.out::println);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}