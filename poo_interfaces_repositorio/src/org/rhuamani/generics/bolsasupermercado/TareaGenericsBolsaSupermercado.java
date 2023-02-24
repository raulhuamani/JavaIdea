package org.rhuamani.generics.bolsasupermercado;

import org.rhuamani.generics.bolsasupermercado.dominio.*;

public class TareaGenericsBolsaSupermercado {
    public static void main(String[] args) {
        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<>();
        BolsaSupermercado<Limpieza> bolsaLimpiezas = new BolsaSupermercado<>();
        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<>();
        BolsaSupermercado<NoPerecible> bolsaNoPerecibles = new BolsaSupermercado<>();

        bolsaFrutas.addProducto(new Fruta(1200.00, "roja", "manzana fuji", 2500d));
        bolsaFrutas.addProducto(new Fruta(800.00, "roja", "duraznos", 1800d));
        bolsaFrutas.addProducto(new Fruta(1000.00, "verdes", "uvas", 3500d));
        bolsaFrutas.addProducto(new Fruta(1200.00, "amarillos", "limones", 1500d));
        bolsaFrutas.addProducto(new Fruta(1200.00, "sandia", "sandia", 4000d));

        bolsaLimpiezas.addProducto(new Limpieza("antibacterial", 0.75, "cif", 1690d));
        bolsaLimpiezas.addProducto(new Limpieza("lavaloza", 1.2, "Sapolio", 2290d));
        bolsaLimpiezas.addProducto(new Limpieza("cloro", 0.95, "liguria", 1200d));
        bolsaLimpiezas.addProducto(new Limpieza("Gel con Lavandica", 0.45, "Gorilla", 1690d));
        bolsaLimpiezas.addProducto(new Limpieza("Desinfectante", 0.9, "clorox", 3300d));

        bolsaLacteos.addProducto(new Lacteo(1000, 32, "Leche con sabor chocolate Semidescremada", 1150d));
        bolsaLacteos.addProducto(new Lacteo(200, 4, "Crema de Leche caja", 800d));
        bolsaLacteos.addProducto(new Lacteo(1000, 31, "Leche blanca descremada caja", 720d));
        bolsaLacteos.addProducto(new Lacteo(1000, 37, "Yogurt Batido sabor Frutilla Bolsa", 1190d));
        bolsaLacteos.addProducto(new Lacteo(1000, 2, "Mantequilla con Sal Soprole", 1750d));

        bolsaNoPerecibles.addProducto(new NoPerecible(170, 95, "Atun Lomitos en agua Angelmo", 960d));
        bolsaNoPerecibles.addProducto(new NoPerecible(425, 560, "Jurel Natural Lata", 1120d));
        bolsaNoPerecibles.addProducto(new NoPerecible(380, 234, "Porotos Negros Listos para servir caja", 1030d));
        bolsaNoPerecibles.addProducto(new NoPerecible(100, 3340, "Arroz grano Largo ancho grado 1", 1320d));
        bolsaNoPerecibles.addProducto(new NoPerecible(100, 3536, "Porotos Hallado Bolsa", 1990d));

        System.out.println("------------------------- Frutas -------------------");
        for (Fruta prod: bolsaFrutas.getProductos()){
            System.out.println("-------------------" + prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Peso (gr): " + prod.getPeso());
            System.out.println("Color: " + prod.getColor());
        }

        System.out.println("------------------------- Limpieza -------------------");
        for (Limpieza prod: bolsaLimpiezas.getProductos()){
            System.out.println("-------------------" + prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Componentes: " + prod.getComponentes());
            System.out.println("Litros: " + prod.getLitros());
        }

        System.out.println("------------------------- Lacteo -------------------");
        for (Lacteo prod: bolsaLacteos.getProductos()){
            System.out.println("-------------------" + prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Cantidad (gr/cc): " + prod.getCantidad());
            System.out.println("Proteinas: " + prod.getProteinas());
        }

        System.out.println("------------------------- NoPerecible -------------------");
        for (NoPerecible prod: bolsaNoPerecibles.getProductos()){
            System.out.println("-------------------" + prod.getNombre());
            System.out.println("Precio: " + prod.getPrecio());
            System.out.println("Calorias (kcal): " + prod.getCalorias());
            System.out.println("Contenido neto (gr): " + prod.getContenido());
        }
    }
}
