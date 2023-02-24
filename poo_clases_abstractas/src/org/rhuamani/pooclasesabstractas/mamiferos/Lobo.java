package org.rhuamani.pooclasesabstractas.mamiferos;

public class Lobo extends Canino{

    private int numCamada;
    private String especieLobo;

    public Lobo(String habitat, float altura, float largo, float peso, String color, float tamanoColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, color, tamanoColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    public int getNumCamada() {
        return numCamada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    @Override
    public String comer() {
        return "El Lobo "+especieLobo+" caza junto a su grupo de "+numCamada+ " individuos en los bosques de "+habitat;
    }

    @Override
    public String dormir() {
        return "El Lobo "+color+ " duerme en las cabernas de "+habitat;
    }

    @Override
    public String correr() {
        return "EL Lobo "+especieLobo+" corre en las llanuras aledañas a los bosques de "+habitat;
    }

    @Override
    public String comunicarse() {
        return "El Lobo "+especieLobo+" "+color+" aulla en luna llena";
    }
}
