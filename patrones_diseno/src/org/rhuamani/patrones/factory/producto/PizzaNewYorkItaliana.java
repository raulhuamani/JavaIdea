package org.rhuamani.patrones.factory.producto;

import org.rhuamani.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {
    public PizzaNewYorkItaliana() {
        super();
        nombre = "Pizza Italiana New York";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate italiano carne";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Jamon");
        ingredientes.add("Choricillo");
        ingredientes.add("Cjampiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30 min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos");
    }
}
