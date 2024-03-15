package org.rhuamani.archivos.ejemplos.servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {

    public void crearArchivo(String nombre){
        File archivo = new File(nombre);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))){

            buffer.append("Hola que tal amigos!\n")
                    .append("Todo bien? yo acá escribiendo un archivo...\n")
                    .append("Hasta luego Lucas!\n");
            // buffer.close();
            System.out.println("El archivo se ha creado con éxito!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo2(String nombre){
        File archivo = new File(nombre);
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))){

            buffer.println("Hola que tal amigos!");
            buffer.println("Todo bien? yo acá escribiendo un archivo...");
            buffer.printf("Hasta luego %s!", "Lucas");
            // buffer.close();
            System.out.println("El archivo se ha creado con éxito!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            String linea;
            while ( (linea = reader.readLine()) != null){
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try (Scanner s = new Scanner(archivo)){

            s.useDelimiter("\n");
            while (s.hasNext()){
                sb.append(s.next()).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String divideArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        int registrosPorArchivo = 1000;
        int conta = 1;
        int numArchivo = 1;
        String rutaArchivo = "";
        String linea;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            while ( (linea = reader.readLine()) != null){

                rutaArchivo = "C:\\rhuamani\\insert_" + numArchivo + ".sql";
                BufferedWriter buffer = new BufferedWriter(new FileWriter(rutaArchivo, true));
                //System.out.println(numArchivo + " - " + conta + " - " + linea);
                if (conta == 1) buffer.append("BEGIN\n");
                buffer.append(linea).append("\n");
                if (conta == registrosPorArchivo) buffer.append("COMMIT;\n").append("END;\n").append("/");
                buffer.close();
                if (++conta > registrosPorArchivo) {
                    conta = 1;
                    numArchivo++;
                    sb.append('@').append(rutaArchivo).append("\n");
                }
            }
            sb.append('@').append(rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}