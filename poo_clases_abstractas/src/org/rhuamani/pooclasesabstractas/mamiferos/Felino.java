package org.rhuamani.pooclasesabstractas.mamiferos;

public abstract class Felino extends Mamifero {

    protected float tamanoGarras;
    protected int velocidad;

    public Felino(String habitat, float altura, float largo, float peso, float tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    public float getTamanoGarras() {
        return tamanoGarras;
    }

    public int getVelocidad() {
        return velocidad;
    }

}
