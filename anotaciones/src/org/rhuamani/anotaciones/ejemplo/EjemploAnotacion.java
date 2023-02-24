package org.rhuamani.anotaciones.ejemplo;

import org.rhuamani.anotaciones.ejemplo.models.Producto;
import org.rhuamani.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;


public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa de centro roBle");
        p.setPrecio(1000L);


        System.out.println("json = " + JsonSerializador.convertirJson(p));
        
    }
}
