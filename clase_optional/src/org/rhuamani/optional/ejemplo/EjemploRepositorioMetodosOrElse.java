package org.rhuamani.optional.ejemplo;

import org.rhuamani.optional.ejemplo.models.Computador;
import org.rhuamani.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.rhuamani.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("HP Omen", "LA0001");
        
        Computador pc = repositorio.filtrar("asus").orElse(valorDefecto());
        System.out.println("pc = " + pc);

        pc = repositorio.filtrar("macbook").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println("pc = " + pc);

    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!!");
        return new Computador("HP Omen", "LA0001");
    }
}
