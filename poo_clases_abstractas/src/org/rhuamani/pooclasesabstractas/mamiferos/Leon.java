package org.rhuamani.pooclasesabstractas.mamiferos;

public class Leon extends Felino {
    private int numManada;
    private float potenciaRugidoDecibel;

    public Leon(String habitat, float altura, float largo, float peso, float tamanoGarras, int velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, tamanoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public int getNumManada() {
        return numManada;
    }

    public float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }

    @Override
    public String comer() {
        return "El Leon caza junto a su grupo de " + numManada + " individuos en las llanuras africanas" ;
    }

    @Override
    public String dormir() {
        return "El Leon duerme en las estepas africanas";
    }

    @Override
    public String correr() {
        return "El Leon corre a "+ velocidad +" km/h";
    }

    @Override
    public String comunicarse() {
        return "El Leon ruge fuerte a "+ potenciaRugidoDecibel+ " decibeles";
    }
}