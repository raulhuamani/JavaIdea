package org.rhuamani.ejemplo;

import org.rhuamani.pooherencia.Alumno;
import org.rhuamani.pooherencia.AlumnoInternacional;
import org.rhuamani.pooherencia.Persona;
import org.rhuamani.pooherencia.Profesor;

public class EjemploHerenciaToString {
    public static void main(String[] args) {

        System.out.println("========= Creando la instancia de la clase Alumno =========");
        Alumno alumno = new Alumno("Raul", "Huamani", 15, "Nuestro Salvador Carmelitas");
        alumno.setNotaLenguaje(14.5);
        alumno.setNotaHistoria(14.3);
        alumno.setNotaMatematica(19.8);
        alumno.setEmail("raul.huamani@gmail.com");

        System.out.println("========= Creando la instancia de la clase AlumnoInternacional =========");
        AlumnoInternacional alumnoInt = new AlumnoInternacional("Peter", "Parker", "Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdioma(16.5);
        alumnoInt.setNotaLenguaje(12.5);
        alumnoInt.setNotaHistoria(13.8);
        alumnoInt.setNotaMatematica(14.6);
        alumnoInt.setEmail("Peter.parker@gmail.com");

        System.out.println("========= Creando la instancia de la clase Profesor =========");
        Profesor profesor = new Profesor("Enrique", "Diaz", "Matematicas");
        profesor.setEdad(50);
        profesor.setEmail("Enrique.diaz@colegio.com");

        System.out.println("========= - =========");

        imprimir(alumno);
        imprimir(alumnoInt);
        imprimir(profesor);
    }

    public static void imprimir(Persona persona){
        System.out.println(persona);
    }
}
