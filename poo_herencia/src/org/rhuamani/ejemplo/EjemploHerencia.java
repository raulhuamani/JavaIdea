package org.rhuamani.ejemplo;

import org.rhuamani.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {

        System.out.println("========= Creando la instancia de la clase Alumno =========");
        Alumno alumno = new Alumno();
        alumno.setNombre("Raul");
        alumno.setApellido("Huamani");
        alumno.setInstitucion("Nuestro Salvador Carmelitas");
        alumno.setNotaLenguaje(14.5);
        alumno.setNotaHistoria(14.3);
        alumno.setNotaMatematica(19.8);

        System.out.println("========= Creando la instancia de la clase AlumnoInternacional =========");
        AlumnoInternacional alumnoInt = new AlumnoInternacional();
        alumnoInt.setNombre("Peter");
        alumnoInt.setApellido("Parker");
        alumnoInt.setPais("Australia");
        alumnoInt.setEdad(15);
        alumnoInt.setInstitucion("Instituto Nacional");
        alumnoInt.setNotaIdioma(16.5);
        alumnoInt.setNotaLenguaje(12.5);
        alumnoInt.setNotaHistoria(13.8);
        alumnoInt.setNotaMatematica(14.6);

        System.out.println("========= Creando la instancia de la clase Profesor =========");
        Profesor profesor = new Profesor();
        profesor.setNombre("Enrique");
        profesor.setApellido("Diaz");
        profesor.setAsignatura("Matematicas");

        System.out.println("========= - =========");
        System.out.println(alumno.getNombre()
                + " " + alumno.getApellido()
                + " " + alumno.getInstitucion());
        System.out.println(alumnoInt.getNombre()
                + " " + alumnoInt.getApellido()
                + " " + alumnoInt.getInstitucion()
                + " " + alumnoInt.getPais());

        System.out.println("Profesor de " + profesor.getAsignatura()
                + " : " + profesor.getNombre()
                + " " + profesor.getApellido());

        Class clase = alumnoInt.getClass();
        while (clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();
        }

    }
}
