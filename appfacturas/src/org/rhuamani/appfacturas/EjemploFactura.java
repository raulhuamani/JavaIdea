package org.rhuamani.appfacturas;

import org.rhuamani.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setRuc("12345678901");
        cliente.setNombre("Raul Huamani");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una descripcion de la factura");
        Factura factura = new Factura(s.nextLine(), cliente);

        Producto producto;

        System.out.println();

        for (int i=0; i < 2; i++){
            producto = new Producto();
            System.out.print("Ingrese producto N° "+producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new Detalle(s.nextInt(), producto));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
        //System.out.println(factura.generarDetalle());
    }

}
