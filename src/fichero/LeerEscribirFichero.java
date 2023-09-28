package fichero;

import java.io.*;
import java.util.Scanner;

//ESTA ES UNA CLASE ESPECIAL QUE GENERA UN FICHERO DENTRO DEL PROYECTO CON EL
//TEXTO QUE LE INDIQUEMOS, O LEE UN FICHERO SEGUN EL NOMBRE QUE LE PROPORCIONEMOS
public class LeerEscribirFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Escribir en el archivo");
        System.out.println("2. Leer desde el archivo");
        System.out.print("Selecciona una opción (1/2): ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            escribirEnArchivo();
        } else if (opcion == 2) {
            leerDesdeArchivo();
        } else {
            System.out.println("Opción no válida");
        }

        scanner.close();
    }

    public static void escribirEnArchivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(nombreArchivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Ingresa los datos para escribir en el archivo (escribe '#' para detener la escritura):");
            while (true) {
                String linea = scanner.nextLine();
                if (linea.equals("#")) {
                    break;
                }
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

            System.out.println("Escritura en el archivo completada.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerDesdeArchivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        try (FileReader fileReader = new FileReader(nombreArchivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
