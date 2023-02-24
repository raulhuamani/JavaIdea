package org.rhuamani.app.hogar;

import org.rhuamani.app.jardin.Perro;

import static org.rhuamani.app.hogar.Persona.saludar;

public class EjemploHogar {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();
        String saludo = saludar();
    }
}
