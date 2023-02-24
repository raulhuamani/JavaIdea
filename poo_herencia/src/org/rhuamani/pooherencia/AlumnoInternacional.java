package org.rhuamani.pooherencia;

public class AlumnoInternacional extends Alumno {
    private String pais;
    private double notaIdioma;

    public AlumnoInternacional(){
        System.out.println("Alumno Internacional: Inicializando constructor...");
    }

    public AlumnoInternacional(String nombre, String apellido){
        super(nombre, apellido);
    }

    public AlumnoInternacional(String nombre, String apellido, String pais){
        super(nombre, apellido);
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getNotaIdioma() {
        return notaIdioma;
    }

    public void setNotaIdioma(double notaIdioma) {
        this.notaIdioma = notaIdioma;
    }

    @Override
    public String saludar() {
        return super.saludar() + " soy extranjero del pais " + getPais();
    }

    @Override
    public double calcularPromedio() {
        //System.out.println("calcularPromedio " + AlumnoInternacional.class.getCanonicalName());
        return ((super.calcularPromedio()*3) + notaIdioma)/4;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\npais='" + pais + '\'' +
                ", notaIdioma=" + notaIdioma;
    }
}
