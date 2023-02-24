public class EjemploAutomovilEnum {
    public static void main(String[] args) {


        Automovil.setCapacidadEstanqueEstatico(45);
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque(45));
        mazda.setTipo(TipoAutomovil.PICKUP);
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());

        TipoAutomovil tipo = subaru.getTipo();
        System.out.println("tipo subaru: "+ tipo.getNombre());
        System.out.println("tipo desc. subaru: "+ tipo.getDescripcion());

        tipo = mazda.getTipo();
        switch (tipo){
            case CONVERTIBLE ->
                System.out.println("El automovil es descriptivo y descapotable de dos puertas");
            case COUPE ->
                System.out.println("Es un automovil pequeño de dos puertas y tipicamente deportivo");
            case FURGON ->
                System.out.println("Es un automovil utilitario de transporte, de empresas");
            case HATCHBACK ->
                System.out.println("Es un automovil mediano compacto, aspecto deportivo");
            case PICKUP ->
                System.out.println("Es un automovil de doble cabina o camioneta");
            case SEDAN ->
                System.out.println("Es un automovil mediano");
            case STATION_WAGON ->
                System.out.println("Es un automovil mas grande, con maleta grande..");
        }

        TipoAutomovil[] tipos = TipoAutomovil.values();
        for (TipoAutomovil ta: tipos){
            System.out.print(ta + " => " + ta.name() + ", " +
                    ta.getNombre() + ", " +
                    ta.getDescripcion() + ", " +
                    ta.getNumeroPuerta());
            System.out.println();
        }

    }
}
