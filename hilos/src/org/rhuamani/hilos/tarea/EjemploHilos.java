package org.rhuamani.hilos.tarea;

public class EjemploHilos {
    public static void main(String[] args) {

        AlfaNumericoTarea h1 = new AlfaNumericoTarea(Tipo.LETRA);
        AlfaNumericoTarea h2 = new AlfaNumericoTarea(Tipo.NUMERO);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();

    }
}
