package org.rhuamani.java.jdbc;

import org.rhuamani.java.jdbc.model.Categoria;
import org.rhuamani.java.jdbc.model.Producto;
import org.rhuamani.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rhuamani.java.jdbc.repositorio.Repositorio;
import org.rhuamani.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getConnection()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== Listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== Obtener por Id ===========");
            System.out.println(repositorio.porId(1L));

            System.out.println("=========== editar producto ===========");
            Producto producto = new Producto();
            producto.setId(6L);
            producto.setNombre("Notebook Azus ROG");
            producto.setPrecio(2550);
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto editado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}