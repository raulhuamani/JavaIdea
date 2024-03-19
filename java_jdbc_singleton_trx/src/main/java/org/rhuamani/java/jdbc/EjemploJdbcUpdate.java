package org.rhuamani.java.jdbc;

import org.rhuamani.java.jdbc.model.Categoria;
import org.rhuamani.java.jdbc.model.Producto;
import org.rhuamani.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rhuamani.java.jdbc.repositorio.Repositorio;
import org.rhuamani.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try (Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== Listar ===========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("=========== Obtener por Id ===========");
            System.out.println(repositorio.porId(1L));

            System.out.println("=========== editar producto ===========");
            Producto producto = new Producto();
            producto.setId(5L);
            producto.setNombre("Teclado Corsair k95 mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto editado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}