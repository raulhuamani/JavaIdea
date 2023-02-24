package org.rhuamani.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Tarea1 {
    public static void main(String[] args) {
        int[] arreglo = new int[100];
        for (int i = 0; i< arreglo.length; i++ ){
            arreglo[i] = i+1;
        }
        double tot = Arrays.stream(arreglo)
                .filter(e -> e%10 != 0)
                .mapToDouble(e -> (double) e / 2)
                .reduce(0, (a, b) -> a + b);
        System.out.println(tot);
        
        // Otra Forma reducida:
        double total = IntStream.rangeClosed(1, 100)
                .filter(n -> (n%10) != 0)
                .mapToDouble(n -> (double) n/2)
                .peek(System.out::println)
                .reduce(0, Double::sum);
        System.out.println("total = " + total);
    }
}
