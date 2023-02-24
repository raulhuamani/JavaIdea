package org.rhuamani.poointerfaces;

import org.rhuamani.poointerfaces.modelo.Cliente;
import org.rhuamani.poointerfaces.modelo.Producto;
import org.rhuamani.poointerfaces.repositorio.Direccion;
import org.rhuamani.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.rhuamani.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.rhuamani.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.rhuamani.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.rhuamani.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("mesa", 50.52));
            repo.crear(new Producto("silla", 18D));
            repo.crear(new Producto("lampara", 15.5));
            repo.crear(new Producto("notebook", 400.89));
            System.out.println("====== Listar ======");
            List<Producto> productos = repo.listar();
            productos.forEach(System.out::println);
            System.out.println("====== Paginable ======");
            List<Producto> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("====== Ordenar ======");
            List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.DESC);
            for (Producto p : productosOrdenAsc) {
                System.out.println(p);
            }

            System.out.println("====== Editar ======");
            Producto lamparaActualizar = new Producto("lampara escritorio", 23d);
            lamparaActualizar.setId(3);
            repo.editar(lamparaActualizar);
            Producto lampara = repo.porId(3);
            System.out.println("Actualizado : " + lampara);
            System.out.println("================================");
            //((OrdenableRepositorio) repo).listar("nombre", Direccion.ASC).forEach(System.out::println);
            repo.listar("precio", Direccion.ASC).forEach(System.out::println);

            System.out.println("====== Eliminar ======");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("====== Total ======");
            System.out.println("Total de Registros: " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
