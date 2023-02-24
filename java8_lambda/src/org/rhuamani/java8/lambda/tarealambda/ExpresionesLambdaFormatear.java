package org.rhuamani.java8.lambda.tarealambda;

public class ExpresionesLambdaFormatear {
    public static void main(String[] args) {
        
        FormatearFrase format = frase -> {
            return frase.replace(".", "")
                    .replace(",", "")
                    .replace(" ", "")
                    .toUpperCase();
        };
        String resultado = format.limpiarYformatear("Pedro Pablo Perez Pereira, pobre pintor portugues, pinta paisajes por poca plata, para pasear por París.");
        System.out.println("resultado = " + resultado);
    }
}
