package org.rhuamani.genericsclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T> camion){
        for (T a: camion) {
            if (a instanceof Animal){
                System.out.println(((Animal)a).getNombre() + " Tipo: "+ ((Animal) a).getTipo());
            } else if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());
            }
        }
    }

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        //Camion transporteCaballos = new Camion(5);        // Sin utilizar genericos
        transporteCaballos.add(new Animal("peregrino", "Caballo"));
        transporteCaballos.add(new Animal("grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));
        transporteCaballos.add(new Animal("prueba", "Caballo"));

        /*
        for (Animal a: transporteCaballos) {
            //Animal a = (Animal) o;    //ya no es necesario castear por utilizar genericos
            System.out.println(a.getNombre() + " Tipo: "+ a.getTipo());
        }
        */

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Hyundai"));
        transAuto.add(new Automovil("Honda"));

        imprimirCamion(transAuto);
    }
}
