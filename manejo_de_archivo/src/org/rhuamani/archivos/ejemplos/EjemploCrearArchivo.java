package org.rhuamani.archivos.ejemplos;

import org.rhuamani.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "c:\\rhuamani\\Cursos\\Java\\javaidea\\manejo_de_archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo2(nombreArchivo);
    }
}