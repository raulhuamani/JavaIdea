package org.rhuamani.api.stream.ejemplos.tarea;

import org.rhuamani.api.stream.ejemplos.models.Producto;

import java.util.Arrays;
import java.util.List;

public class Tarea4 {
    public static void main(String[] args) {

        List<Producto> facturas = Arrays.asList(new Producto(9.99, 1 ),
                new Producto(19.99, 1.5d ),
                new Producto(4.99, 2 ));
        // Forma 1:
        double sum = facturas.stream()
                .map( p -> p.getPrecio() * p.getCantidad())
                .reduce(0d, Double::sum);
        System.out.println("sum = " + sum);

        // Forma 2:
        double sum2 = facturas.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
        System.out.println("sum2 = " + sum2);
    }
}
