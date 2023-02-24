package org.rhuamani.api.stream.ejemplos;

import org.rhuamani.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingleOptional {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("PepeX"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        //System.out.println(usuario.orElse(new Usuario("Jhon", "Doe")).getNombre());
        //System.out.println(usuario.orElseGet(() -> new Usuario("Jhon", "Doe")).getNombre());
        //System.out.println(usuario.orElseThrow());
        if (usuario.isPresent()){
            System.out.println(usuario.get().getNombre());
        } else {
            System.out.println("No se encontró el objeto!");
        }
        //nombres.forEach(System.out::println);

    }
}
