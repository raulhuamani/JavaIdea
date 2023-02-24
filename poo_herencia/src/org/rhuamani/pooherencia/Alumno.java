package org.rhuamani.pooherencia;

public class Alumno extends Persona {

    private String institucion;
    private double notaMatematica;
    private double notaLenguaje;
    private double notaHistoria;

    public Alumno(){
        System.out.println("Alumno: Inicializando constructor...");
    }

    public Alumno(String nombre, String apellido){
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad){
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre, String apellido, int edad, String institucion){
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno (String nombre, String apellido, int edad, String institucion,
                   double notaMatematica, double notaLenguaje, double notaHistoria){
        this(nombre, apellido, edad, institucion);
        this.notaMatematica = notaMatematica;
        this.notaLenguaje = notaLenguaje;
        this.notaHistoria = notaHistoria;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaLenguaje() {
        return notaLenguaje;
    }

    public void setNotaLenguaje(double notaLenguaje) {
        this.notaLenguaje = notaLenguaje;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String saludar() {
        String saludar = super.saludar();
        return saludar + " soy un alumno y mi nombre es " + this.getNombre() ;
    }

    public double calcularPromedio(){
        //System.out.println("calcularPromedio " + Alumno.class.getCanonicalName());
        return (notaMatematica + notaLenguaje + notaHistoria)/3;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ninstitucion='" + institucion + '\'' +
                ", notaMatematica=" + notaMatematica +
                ", notaLenguaje=" + notaLenguaje +
                ", notaHistoria=" + notaHistoria +
                ", promedio= " + this.calcularPromedio();
    }
}
