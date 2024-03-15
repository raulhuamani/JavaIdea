package org.rhuamani.archivos.ejemplos;

import org.rhuamani.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "c:\\rhuamani\\Cursos\\Java\\javaidea\\manejo_de_archivo\\java.txt";
        ArchivoServicio servicio = new ArchivoServicio();

        System.out.println(servicio.leerArchivo(nombreArchivo));
    }
}