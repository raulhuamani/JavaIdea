package org.rhuamani.ejemplo;

import org.rhuamani.pooherencia.*;

public class EjemploHerenciaConstructores {
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
        System.out.println("Imprimiendo datos en comun de Persona");
        System.out.println("nombre: " + persona.getNombre()
                + ", apellido: " + persona.getApellido()
                + ", edad: " + persona.getEdad()
                + ", email: " + persona.getEmail());

        if (persona instanceof Alumno){
            System.out.println("Imprimiendo los datos del tipo Alumno:");
            System.out.println("Institucion: "+ ((Alumno) persona).getInstitucion());
            System.out.println("Nota Matematica: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("Nota Historia: " + ((Alumno) persona).getNotaHistoria());
            System.out.println("Nota Lenguaje: " + ((Alumno) persona).getNotaLenguaje());

            if (persona instanceof AlumnoInternacional){
                System.out.println("Imprimiendo los datos del tipo AlumnoInternacional:");
                System.out.println("Nota idiomas: = " + ((AlumnoInternacional) persona).getNotaIdioma());
                System.out.println("Pais: = " + ((AlumnoInternacional) persona).getPais());
            }
            System.out.println("=================== sobre escritura promedio  ====================");
            System.out.println("Promedio: " + ((Alumno) persona).calcularPromedio());
            System.out.println("=================== sobre escritura promedio  ====================");
        }

        if (persona instanceof Profesor){
            System.out.println("Imprimiendo los datos del tipo Profesor:");
            System.out.println("Asignatura: " + ((Profesor) persona).getAsignatura());
        }
        System.out.println("=================== sobre escritura saludar  ====================");
        System.out.println(persona.saludar());
        System.out.println("===================================================");
    }
}
