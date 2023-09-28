package fichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribeFichero {

    public static void main(String[] args) {

        String ruta = "/home/lauracglez/Desktop/nuevoFichero";

        try {
            File f = new File(ruta);

            if (f.createNewFile()){

                System.out.println("Archivo creado");

                FileWriter fileWriter = new FileWriter(f, true);

                fileWriter.write("Ejemplo de texto");

                fileWriter.close();

            } else {
                System.out.println("El archivo ya existe");
            }


        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}
