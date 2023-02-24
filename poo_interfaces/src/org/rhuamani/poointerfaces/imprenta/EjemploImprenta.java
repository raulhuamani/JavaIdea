package org.rhuamani.poointerfaces.imprenta;

import org.rhuamani.poointerfaces.imprenta.modelo.*;
import static org.rhuamani.poointerfaces.imprenta.modelo.Genero.*;
import static  org.rhuamani.poointerfaces.imprenta.modelo.Imprimible.*;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Resumen Laboral...", new Persona("Raul", "Huamani"), "Ingeniero de Sistemas");
        cv.addExperiencias("Java")
                .addExperiencias("Oracle DBA")
                .addExperiencias("Spring Framework")
                .addExperiencias("Desarrollador fullstack")
                .addExperiencias("Angular");

        Libro libro = new Libro(new Persona("Erich", "Gamma"),
                "Patrones de diseño: Elem. Reusables POO",
                PROGRAMACION);
        libro.addPagina(new Pagina("Patrón Singleton"))
                .addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Factory"))
                .addPagina(new Pagina("Patrón Composite"))
                .addPagina(new Pagina("Patrón Facade"));

        Informe informe = new Informe("Estudio sobre microservicios",
                new Persona("Martin", "Fowler"),
                new Persona("James", "Gosling"));
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "Hola que tal, imprimiendo un objeto genérico de una clase anónima";
            }
        });

        System.out.println(TEXTO_DEFECTO);
    }

    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
