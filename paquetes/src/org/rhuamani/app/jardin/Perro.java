package org.rhuamani.app.jardin;

import org.rhuamani.app.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    String jugar(Persona persona){
        return persona.lanzarPelota();
    }
}
