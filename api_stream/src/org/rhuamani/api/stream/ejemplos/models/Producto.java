package org.rhuamani.api.stream.ejemplos.models;

public class Producto {
    private double precio;
    private double cantidad;

    public Producto(double precio, double cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCantidad() {
        return cantidad;
    }
}
