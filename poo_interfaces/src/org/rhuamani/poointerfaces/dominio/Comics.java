package org.rhuamani.poointerfaces.dominio;

public class Comics extends Libro {
    private String personaje;

    public Comics(int precio, String autor, String titulo, String editorial, String personaje) {
        super(precio, autor, titulo, editorial);
        this.personaje = personaje;
    }

    public String getPersonaje() {
        return personaje;
    }

    @Override
    public double getPrecioVenta() {
        return super.getPrecioVenta() * 0.85f;
    }
}
