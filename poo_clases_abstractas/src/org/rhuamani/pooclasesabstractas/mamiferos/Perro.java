package org.rhuamani.pooclasesabstractas.mamiferos;

public class Perro extends Canino {
    private int fuerzaMordida;

    public Perro(String habitat, float altura, float largo, float peso, String color, float tamanoColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El Perro africano caza en manada con una fuerte mordida de "+fuerzaMordida+" PSI, posee fuertes mandíbulas y grandes orejas redondeadas";
    }

    @Override
    public String dormir() {
        return "El Perro africano duerme en la sabana africana";
    }

    @Override
    public String correr() {
        return "El Perro africano corre en las llanuras aledañas a la sabana!";
    }

    @Override
    public String comunicarse() {
        return "Los Perros ladran de noche durante las cacerias nocturnas";
    }
}
