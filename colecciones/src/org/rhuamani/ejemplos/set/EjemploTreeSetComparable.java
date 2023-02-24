package org.rhuamani.ejemplos.set;

import org.rhuamani.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {

        //Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNota().compareTo(a.getNota()));
        Set<Alumno> sa = new TreeSet<>(comparing((Alumno::getNota)).reversed());
        sa.add(new Alumno("Raul", 20));
        sa.add(new Alumno("Cata", 12));
        sa.add(new Alumno("Luci", 18));
        sa.add(new Alumno("Jano", 14));
        sa.add(new Alumno("Andres", 6));
        sa.add(new Alumno("Zeus", 4));
        sa.add(new Alumno("Lucas", 8));

        System.out.println("sa = " + sa);
    }
}
