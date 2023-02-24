package org.rhuamani.poointerfaces.imprenta.modelo;

public interface Imprimible {

    //final static String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";    // quitamos final static xq redunda
    String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";

    default String imprimir(){
        return TEXTO_DEFECTO;
    };

    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
