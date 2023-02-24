package org.rhuamani.patrones.factory.producto;

import org.rhuamani.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {
    public PizzaNewYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana New York";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceituna");
        ingredientes.add("Espinaca");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min. a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadras.");
    }
}
