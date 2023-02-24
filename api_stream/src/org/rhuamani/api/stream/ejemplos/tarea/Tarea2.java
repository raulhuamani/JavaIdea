package org.rhuamani.api.stream.ejemplos.tarea;

import java.util.Arrays;
import java.util.function.Function;

public class Tarea2 {
    public static void main(String[] args) {
        
        // La función lambda que obtiene el numero mayor del arreglo usando api Stream en su implementación
        Function<Integer[], Integer> max = arr -> Arrays.stream(arr).reduce(0, (a, b) -> a > b? a: b);
        //Function<Integer[], Integer> max = arr -> Arrays.stream(arr).reduce(0, Integer::max);
        
        int resultado = max.apply(new Integer[]{1, 78, -1700, 2500, 0, 2000, 54, 2});
        System.out.println("resultado = " + resultado);
    }
}
