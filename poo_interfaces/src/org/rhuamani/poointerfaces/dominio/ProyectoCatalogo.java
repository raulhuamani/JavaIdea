package org.rhuamani.poointerfaces.dominio;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos = new Producto[6];

        productos[0] = new IPhone(4500, "Apple", "12", "gris");
        productos[1] = new IPhone(5000, "Apple", "13", "Blue");
        productos[2] = new TvLcd(4500,"LG", 65 );
        productos[3] = new Libro(100, "Eric Gamma", "Elementos Reusables POO", "Alguna...");
        productos[4] = new Libro(150, "Martin Fowler", "UML gota a gota", "Alguna...");
        productos[5] = new Comics(50, "pepo", "Condorito", "Alguno...","Condorito");

        for (IProducto producto: productos) {
            System.out.println("Tipo de Producto: " + producto.getClass().getSimpleName());
            System.out.println("  -  ");
            System.out.println("Precio: "+ producto.getPrecio());
            System.out.println("  -  ");
            System.out.println("Precio Final: "+ producto.getPrecioVenta());

            // Para los electrónicos
            if (producto instanceof IElectronico){
                System.out.println("  -  ");
                System.out.println("Fabricante: "+ ((IElectronico) producto).getFabricante());

                // Para los Iphone
                if (producto instanceof IPhone){
                    System.out.println("  -  ");
                    System.out.println("Modelo: " + ((IPhone) producto).getModelo());
                    System.out.println("  -  ");
                    System.out.println("Color: " + ((IPhone) producto).getColor());
                }

                // Para los LCD
                if (producto instanceof TvLcd){
                    System.out.println("  -  ");
                    System.out.println("Pulgadas: " + ((TvLcd) producto).getPulgada());
                }
            }

            // Para los libros
            if (producto instanceof ILibro){
                System.out.println("  -  ");
                System.out.println("Titulo: " + ((ILibro) producto).getTitulo());
                System.out.println("  -  ");
                System.out.println("Autor: " + ((ILibro) producto).getAutor());

                // Para los comics
                if (producto instanceof Comics){
                    System.out.println("  -  ");
                    System.out.println("Personaje: " + ((Comics) producto).getPersonaje());
                }
            }
            System.out.println();
        }
    }
}
