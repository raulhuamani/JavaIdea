package org.rhuamani.app.jardin;

import org.rhuamani.app.hogar.*;
import static org.rhuamani.app.hogar.Persona.*;
import static org.rhuamani.app.hogar.ColorPelo.*;

public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p = new Persona();
        p.setNombre("Raul");
        p.setApellido("Huamani");
        p.setColorPelo(CAFE);
        System.out.println(p.getNombre());

        //Gato g = new Gato();
        Perro perro = new Perro();
        perro.nombre = "Tobby";
        perro.raza = "Bulldog";
        
        String jugando = perro.jugar(p);
        System.out.println("jugando = " + jugando);
        String saludo = saludar();
        System.out.println("saludo = " + saludo);
        String generoMujer = GENERO_FEMENINO;
        String generoHombre = GENERO_MASCULINO;
    }
}
