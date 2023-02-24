package org.rhuamani.pooclasesabstractas.mamiferos;

public class Tigre extends Felino {
    private String especieTigre;

    public Tigre(String habitat, float altura, float largo, float peso, float tamanoGarras, int velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String comer() {
        return "El Tigre "+ especieTigre+" caza solitario en los manglares y bosques monzonicos de " + habitat;
    }

    @Override
    public String dormir() {
        return "El Tigre "+especieTigre+" duerme en las selvas de "+habitat;
    }

    @Override
    public String correr() {
        return "El Tigre "+especieTigre+" corre a "+velocidad+ " km/h";
    }

    @Override
    public String comunicarse() {
        return "El Tigre Ruge y agacha sus orejas";
    }
}
