package org.rhuamani.archivos.ejemplos;

import org.rhuamani.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploDivideArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\rhuamani\\escritorio\\archivo.txt";
        ArchivoServicio servicio = new ArchivoServicio();

        System.out.println(servicio.divideArchivo(nombreArchivo));
    }
}