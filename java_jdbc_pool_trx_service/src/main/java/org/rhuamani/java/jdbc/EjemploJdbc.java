package org.rhuamani.java.jdbc;

import org.rhuamani.java.jdbc.model.Categoria;
import org.rhuamani.java.jdbc.model.Producto;
import org.rhuamani.java.jdbc.servicio.CatalogoServicio;
import org.rhuamani.java.jdbc.servicio.Servicio;

import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("=========== Listar ===========");
        servicio.listar().forEach(System.out::println);

        System.out.println("=========== Insertar nueva categoria ===========");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        System.out.println("=========== Insertar nuevo producto ===========");
        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado con exito: " + producto.getId());
        System.out.println("=========== Listar ===========");
        servicio.listar().forEach(System.out::println);


    }
}