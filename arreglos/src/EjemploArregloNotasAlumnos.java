import java.util.Scanner;

public class EjemploArregloNotasAlumnos {
    public static void main(String[] args) {

        double[] claseMatematicas, claseHistoria, claseLenguaje;
        double sumNotasMatematicas = 0, sumNotasHistoria = 0, sumNotasLenguaje = 0;
        claseMatematicas = new double[7];
        claseHistoria = new double[7];
        claseLenguaje =  new double[7];

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese 7 notas de estudiantes para matematicas");
        for (int i = 0; i < claseMatematicas.length; i++){
            claseMatematicas[i] = s.nextDouble();
        }

        System.out.println("Ingrese 7 notas de estudiantes para Historia");
        for (int i = 0; i < claseHistoria.length; i++){
            claseHistoria[i] = s.nextDouble();
        }

        System.out.println("Ingrese 7 notas de estudiantes para Lenguaje");
        for (int i = 0; i < claseLenguaje.length; i++){
            claseLenguaje[i] = s.nextDouble();
        }

        for (int i = 0; i < 7; i++){
            sumNotasMatematicas += claseMatematicas[i];
            sumNotasLenguaje += claseLenguaje[i];
            sumNotasHistoria += claseHistoria[i];
        }

        double promedioMatematica =  (sumNotasMatematicas/claseMatematicas.length);
        double promedioLenguaje =  (sumNotasLenguaje/claseLenguaje.length);
        double promedioHistoria =  (sumNotasHistoria/claseHistoria.length);

        System.out.println("Promedio clase Matematicas: "+promedioMatematica);
        System.out.println("Promedio clase Lenguaje: "+ promedioLenguaje);
        System.out.println("Promedio clase Historia: "+ promedioHistoria);
        System.out.println("Promedio total del curso" + (promedioMatematica + promedioLenguaje + promedioHistoria)/3);

        System.out.println("Ingrese el identificador del alumno (de 0 - 6):");
        int id = s.nextInt();
        double promedioAlumno = (claseHistoria[id]+claseLenguaje[id]+claseMatematicas[id])/3;
        System.out.println("Promedio Alumno N° = " + id + " : " + promedioAlumno);
    }
}
