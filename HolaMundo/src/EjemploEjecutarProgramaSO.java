import java.io.IOException;

public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        Process proceso;

        try {
            System.out.println(System.getProperty("os.name"));
            if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
                proceso = rt.exec("notepad");
            } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
                proceso = rt.exec("TextEdit.app");
            } else if (System.getProperty("os.name").toLowerCase().contains("nux") ||
                       System.getProperty("os.name").toLowerCase().contains("nix") ) {
                //proceso = rt.exec("xfce4-terminal");
                proceso = rt.exec("thunar");
            } else {
                proceso = rt.exec("nvim");
            }
            proceso.waitFor();
        }catch (IOException e) {
            System.err.println("El comando es desconocido: " + e.getMessage());
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println("Llegooo");
            e.printStackTrace();
        }
        System.out.println("Se ha cerrado el editor");
        System.exit(0);
    }
}
