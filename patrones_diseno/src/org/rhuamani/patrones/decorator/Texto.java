package org.rhuamani.patrones.decorator;

public class Texto implements Formateable {
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String darFormato() {
        return getTexto();
    }
}
