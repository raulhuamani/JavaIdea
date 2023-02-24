import java.util.Scanner;

public class EjemploArreglosBuscarNumero {
    public static void main(String[] args) {

        int[] a = new int[10];

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < a.length; i++){
            System.out.print("Ingrese un numero: ");
            a[i] = s.nextInt();
        }

        System.out.println("\r\nIngrese un numero a Buscar:");
        int num = s.nextInt();
        int i = 0;
        while (i < a.length && a[i] != num){
            i++;
        }
        if (i == a.length){
            System.out.println("Numero no encontrado");
        } else if (a[i] == num){
            System.out.println("Encontrado en la posicion: "+ i);
        }

    }
}
