package org.rhuamani.api.stream.ejemplos;

import org.rhuamani.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {

        Stream<String> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia", "Paco Gonzales", "Paco Gonzales", "Paco Gonzales")
                .distinct();

        nombres.forEach(System.out::println);


    }
}
