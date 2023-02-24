package org.rhuamani.patrones.factory.producto;

import org.rhuamani.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {
    public PizzaCaliforniaPepperoni() {
        super();
        nombre = "Pizza California Pepperoni";
        masa = "Masa a la piedra gruesa";
        ingredientes.add("Pepperoni");
        ingredientes.add("Extra queso Mozzarella");
        ingredientes.add("Aceituna");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 50 min a 55°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectangulos");
    }
}
