package org.rhuamani.optional.ejemplo;

import org.rhuamani.optional.ejemplo.models.Computador;
import org.rhuamani.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.rhuamani.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("rog").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontró"));

        /*Optional<Computador> pc = repositorio.filtrar("Asus ROG");

        if (pc.isPresent()){
            System.out.println(pc.get().toString());
        } else {
            System.out.println("No se encontro");
        }*/

    }
}
