package org.rhuamani.pooclasesabstractas.mamiferos;

public class Guepardo extends Felino {

    public Guepardo(String habitat, float altura, float largo, float peso, float tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, tamanoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El Guepardo caza junto a su grupo en las llanuras africanas, con una mordida mucho inferior a los demas felinos grandes";
    }

    @Override
    public String dormir() {
        return "El Guepardo duerme en las estepas africanas";
    }

    @Override
    public String correr() {
        return "El Guepardo es el felino mas rápido del mundo, corre a "+velocidad+" km/h";
    }

    @Override
    public String comunicarse() {
        return "El Guepardo ruge no tan fuerte como el Leon";
    }
}
