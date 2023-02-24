package org.rhuamani.colecciones.proyectovuelos;

import org.rhuamani.colecciones.proyectovuelos.dominio.Vuelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProyectoVuelos {

    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        List<Vuelo> llegadas = new ArrayList<>();

        llegadas.add(new Vuelo("AAL 933", "New York", "Santiago", df.parse("2021-05-29 05:39"), 62));
        llegadas.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", df.parse("2021-08-31 04:45"), 47));
        llegadas.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", df.parse("2021-08-30 16:00"), 52));
        llegadas.add(new Vuelo("DAL 147", "Atlanta", "Santiago", df.parse("2021-08-29 13:22"), 59));

        llegadas.sort((v1, v2) -> v2.getFechayHoraLlegada().compareTo(v1.getFechayHoraLlegada()));

        llegadas.forEach(System.out::println);
        Vuelo ultimoVuelo = llegadas.get(0);
        System.out.println("El último vuelo en llegar es " + ultimoVuelo.getNombre() + ": " + ultimoVuelo.getOrigen() + ", aterriza el "+ ultimoVuelo.getFechayHoraLlegada());

        llegadas.sort((v1, v2) -> Integer.valueOf(v2.getNumeroPasajeros()).compareTo(v1.getNumeroPasajeros()));
        Vuelo vueloMenorNumero = new LinkedList<>(llegadas).peekLast();
        System.out.println("El vuelo con menor numero de pasajeros es " + vueloMenorNumero.getNombre() + ": " + vueloMenorNumero.getOrigen() + ", con "+ vueloMenorNumero.getNumeroPasajeros() + " pasajeros. ");
    }
}
