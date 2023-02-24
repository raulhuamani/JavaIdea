package org.rhuamani.poointerfaces.dominio;

public class TvLcd extends Electronico {
    private int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    @Override
    public double getPrecioVenta() {
        return getPrecio() * 0.8f;
    }

    public int getPulgada() {
        return pulgada;
    }
}
