package org.rhuamani.api.stream.ejemplos;

import org.rhuamani.api.stream.ejemplos.models.*;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Jhon", "Doe");
        Usuario u2 = new Usuario("Pepe", "Perez");

        u1.addFactura(new Factura("Compras Tecnologicas"));
        u1.addFactura(new Factura("compras nuebles"));

        u2.addFactura(new Factura("bicicletas"));
        u2.addFactura(new Factura("notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(u1, u2);
        usuarios.stream()
                //.map(u -> u.getFacturas()).flatMap(lf -> lf.stream())     // Forma basica
                //.map(Usuario::getFacturas).flatMap(List::stream)          // por referencia
                .flatMap( u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : cliente ")
                        .concat(f.getUsuario().toString())));

    }

}
