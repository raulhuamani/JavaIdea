package org.rhuamani.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        //Map<String, Object> persona = new TreeMap<>((a, b) -> b.compareTo(a));
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());   // por el largo de caracteres

        persona.put("nombre", "Jhon");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "jhon.doe@gmail.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);

    }

}
