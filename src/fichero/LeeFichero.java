package fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeeFichero {

    public static void main(String[] args) {

        File f = new File("/home/lauracglez/Desktop/nuevoFichero");

        try {

            FileReader fileReader = new FileReader(f);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            bufferedReader.close();

            fileReader.close();

        } catch (IOException e){
            System.out.println("Excepcion" + e.getMessage());
        }

    }

}
