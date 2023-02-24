public class EjemploStringExtensionArchivo {
    public static void main(String[] args) {

        String archivo = "alguna_imagen.jpeg";
        //int i = archivo.indexOf(".");
        int i = archivo.lastIndexOf(".");       // para extensione recomemdable utilizar lastindexof()
        System.out.println("archivo.length() = " + archivo.length());
        System.out.println("archivo.substring(archivo.length() -4) = " + archivo.substring(i + 1));
    }
}
