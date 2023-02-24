package org.rhuamani.api.stream.ejemplos;

import org.rhuamani.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        IntStream largonombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia", "Pato Guzman", "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                //.mapToInt(u -> u.getId())
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        //System.out.println(largonombres.sum());       // como largonombre es final no va a permitir ejecutar las siguientes lineas de codigo, por ello recomienda IntSummaryStatistics

        IntSummaryStatistics stats = largonombres.summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("sum: " + stats.getSum());
        System.out.println("promedio: " + stats.getAverage());
        System.out.println("total: " + stats.getCount());


    }
}
