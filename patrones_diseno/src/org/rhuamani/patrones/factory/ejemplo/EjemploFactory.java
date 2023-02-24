package org.rhuamani.patrones.factory.ejemplo;

import org.rhuamani.patrones.factory.PizzaProducto;
import org.rhuamani.patrones.factory.PizzeriaCaliforniaFactory;
import org.rhuamani.patrones.factory.PizzeriaNewYorkFactory;
import org.rhuamani.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andres ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena " + pizza.getNombre());

        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("Linus ordena pizza " + pizza.getNombre());

        pizza = california.ordenarPizza("pepperoni");
        System.out.println("Jhon ordena la pizza" + pizza.getNombre());

        System.out.println("pizza = " + pizza);

    }
}
