package fichero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribeFichero {

    public static void main(String[] args) {

        //PARA PROBAR EL CODIGO SOLO SE NECESITA CAMBIAR LA RUTA DEL FICHERO
        String ruta = "/home/lauracglez/Desktop/nuevoFichero";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa los datos para escribir en el archivo (escribe '#' para detener la escritura):");

        try {
            // Crea un FileWriter para el archivo (se sobrescribirá si ya existe)
            FileWriter fileWriter = new FileWriter(ruta);

            // Crea un BufferedWriter para escribir de manera eficiente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            while (true) {
                // Lee una línea de datos del usuario
                String linea = scanner.nextLine();

                // Verifica si la línea contiene el símbolo "#" y detén la escritura si es así
                if (linea.contains("#")) {
                    break;
                }

                // Escribe la línea en el archivo
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

            // Cierra el Scanner, BufferedWriter y FileWriter
            scanner.close();
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Escritura en el archivo completada.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

