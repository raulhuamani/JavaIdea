package org.rhuamani.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia: " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("Mes: " + mes);
        System.out.println("Numero del mes: " + mes.getValue());
        System.out.println("Mes español: " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero del día: " + diaSemana.getValue());
        System.out.println("Nombre del dia: " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));

        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Dia del año: " + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());


        fechaActual = LocalDate.of(2018, 2, 3);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2020, Month.NOVEMBER, 11);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-02-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diademaniana = LocalDate.now().plusDays(1);
        System.out.println("diademaniana = " + diademaniana);

        LocalDate mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS); // minusMonths(1);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        DayOfWeek viernes = LocalDate.parse("2022-06-03").getDayOfWeek();
        System.out.println("viernes = " + viernes);

        int once = LocalDate.of(2020, 11, 11 ).getDayOfMonth();
        System.out.println("once = " + once);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);
        
        boolean esAntes = LocalDate.of(2022, 6, 4).isBefore(LocalDate.of(2022, 6, 3));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.of(2022, 6, 4).isAfter(LocalDate.of(2022, 6, 3));;
        System.out.println("esDespues = " + esDespues);
        
        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);

    }
}
