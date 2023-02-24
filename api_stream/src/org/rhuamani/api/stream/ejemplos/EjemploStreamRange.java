package org.rhuamani.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        //IntStream numero = IntStream.range(5, 20).peek(System.out::println);          // desde el 5 al 19 ... excluye ultimo elemento
        IntStream numero = IntStream.rangeClosed(5, 20).peek(System.out::println);      // desde el 5 al 20 ... incluye ultimo elemento

        //int resultado = nombres.reduce(0, (a, b) -> a + b);
        //int resultado = numero.reduce(0, Integer::sum);
        //int resultado = numero.sum();
        IntSummaryStatistics stats = numero.summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("sum: " + stats.getSum());
        System.out.println("promedio: " + stats.getAverage());
        System.out.println("total: " + stats.getCount());


    }
}
