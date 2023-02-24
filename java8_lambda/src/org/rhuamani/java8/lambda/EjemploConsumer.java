package org.rhuamani.java8.lambda;

import org.rhuamani.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " años!");

        consumidorBi.accept("Pepe", 20);

        Consumer<String> consumir2 = System.out::println;
        consumir2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
        nombres.forEach(consumir2);

        Supplier<Usuario> crearUsuario = Usuario::new;
        Usuario usuario = crearUsuario.get();
        //BiConsumer<Usuario, String> asignarNombre = (persona, nombre) -> persona.setNombre(nombre);
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;     // forma por referencia
        asignarNombre.accept(usuario, "andres");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () ->  "Hola mundo lambda supplier";

        System.out.println(proveedor.get());
    }
}
