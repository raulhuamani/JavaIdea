package org.rhuamani.datetime.ejemplos.tarea;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculaEdad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una fecha de nacimiento con formato yyyy-MM-dd:");
        String fechaStr = scanner.next();

        LocalDate fechaNacimiento = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate actual = LocalDate.now();

        Period period = Period.between(fechaNacimiento, actual);
        System.out.printf("Tu edad es: %s años, %s meses y %s días", period.getYears(), period.getMonths(), period.getDays());
    }
}
