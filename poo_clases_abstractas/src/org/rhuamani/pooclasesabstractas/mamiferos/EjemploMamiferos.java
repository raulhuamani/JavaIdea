package org.rhuamani.pooclasesabstractas.mamiferos;

public class EjemploMamiferos {

    public static void main(String[] args) {

        Mamifero[] mamiferos = new Mamifero[6];

        Mamifero leon = new Leon("Sur Africa",120,220,190,7.5f,58,5,120f);
        Mamifero tigre = new Tigre("Rusia",130,330,300,7.9f,72,"Siberiano");
        Mamifero lobo = new Lobo("Europa",80,120,70,"Gris, marron y negro",2.5f,9,"Ibérico");
        Mamifero perro = new Perro("Africa", 43,92,35,"Tricolor de manchas negras, blancas y oxido",2.5f,317);
        Mamifero tigreBengala = new Tigre("India e Indonesia", 110, 270, 220,7.9f, 72, "Bengala");
        Mamifero guepardo = new Guepardo("Africa", 94, 140, 72,4.9f, 130);

        mamiferos[0] = leon;
        mamiferos[1] = tigre;
        mamiferos[2] = lobo;
        mamiferos[3] = perro;
        mamiferos[4] = tigreBengala;
        mamiferos[5] = guepardo;

        for (Mamifero animal: mamiferos) {

            System.out.println("=========== ["+animal.getClass().getSimpleName()+"] ===========");
            System.out.println("Habitat: "+animal.getHabitat());
            System.out.println("Altura: "+animal.getAltura());
            System.out.println("Largo: "+animal.getLargo());
            System.out.println("Peso: "+animal.getPeso());

            if(animal instanceof Canino){
                System.out.println("Colmillos: "+ ((Canino) animal).getTamanoColmillos());
                System.out.println("Color: "+ ((Canino) animal).getColor());

                if(animal instanceof Lobo){
                    System.out.println("Especie Lobo:"+ ((Lobo) animal).getEspecieLobo());
                    System.out.println("Numero Integrantes: " + ((Lobo) animal).getNumCamada());
                }
                if (animal instanceof Perro){
                    System.out.println("Fuerza mordida Kg: " + ((Perro) animal).getFuerzaMordida());
                }
            }

            if (animal instanceof Felino){
                System.out.println("Tamaño Garras: " + ((Felino) animal).getTamanoGarras());
                System.out.println("Velocidad: " + ((Felino) animal).getVelocidad());
            }

            if (animal instanceof Leon){
                System.out.println("Potencia Rugido: " + ((Leon) animal).getPotenciaRugidoDecibel());
                System.out.println("Número Integrantes " + ((Leon) animal).getNumManada());
            }
            if (animal instanceof Tigre){
                System.out.println("Especie Tigre " + ((Tigre) animal).getEspecieTigre());
            }

            System.out.println(animal.comer());
            System.out.println(animal.dormir());
            System.out.println(animal.correr());
            System.out.println(animal.comunicarse());

        }


    }
}
