package org.rhuamani.java8.lambda.tarealambda;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class ExpresionesLambda {
    public static void main(String[] args) {

        ContadorPalabras contador = frase -> {

            // Limpiamos la frase eliminando los puntos, comas y dejamos todo en minusculas
            // luego con split convertimos la frase en un arreglo para iterarlo.
            String[] arreglo = frase.replace(".","")
                    .replace(",", "")
                    .toLowerCase()
                    .split(" ");
            // con un for doble iteramos cada palabre y la comparamos con cada una del arreglo.
            // asi podemos calcular el maximo que se repite una palabra
            // definimos dos variables importantes la palabra mas repetida y el max o cantidad de veces que se repite la palabra
            int max = 0;
            String palabra = null;
            for (int i = 0; i < arreglo.length; i++){
                int cantidad = 0;
                for (int j = 0; j < arreglo.length; j++){
                    if (arreglo[i].equalsIgnoreCase(arreglo[j])) {
                        cantidad++;
                    }
                }
                if (cantidad > max) {
                    max = cantidad;
                    palabra = arreglo[i];
                }
            }
            // finalmente devolvemos el resultado de la palabra mas repetida y el numero de veces que se repite en un Map
            // donde la llave es la palabra y max la cantidad
            return Collections.singletonMap(palabra, max);
        };

        // ejecutamos y probamos nuestr expresion lambda con alguna frase con la palabra ni que se repite varias veces
        // y finalmente el map que devuelve lo iteramos con una lambda forEach mostradon la llave o palabra y el valor cantidad
        contador.contarPalabras("Yo ni te conozco, ni te he visto, ni se tu nombre, ni te hablare, ni me interesas.")
                .forEach((k, v) -> System.out.println("la palabra " + k + " se repite " + v + " veces."));
    }
}
