package org.rhuamani.java.jdbc;

import org.rhuamani.java.jdbc.model.Categoria;
import org.rhuamani.java.jdbc.model.Producto;
import org.rhuamani.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.rhuamani.java.jdbc.repositorio.Repositorio;

import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        System.out.println("=========== Listar ===========");
        repositorio.listar().forEach(System.out::println);

        System.out.println("=========== Obtener por Id ===========");
        System.out.println(repositorio.porId(1L));

        System.out.println("=========== Insertar nuevo producto ===========");
        Producto producto = new Producto();
        producto.setNombre("Notebook Omen HP");
        producto.setPrecio(2900);
        producto.setFechaRegistro(new Date());
        Categoria categoria = new Categoria();
        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Producto guardado con exito");
        repositorio.listar().forEach(System.out::println);

    }
}