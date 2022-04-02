import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class ManagerArchivo { // checar que hago lo que se supone debe hacer

    public boolean validarEstructuraArchivo(String ruta, int elementos, char separador) {
        CSVReader lector = null;

        try {
            // Abrir el .csv
            lector = new CSVReader(new FileReader("archivo.csv"), separador);

            // Definir el string de la línea leída
            String[] linea = null;

            while ((linea = lector.readNext()) != null) {
                if (elementos == 2) {
                    return true;
                } else {
                    System.out.println("El archivo no cuenta con la cantidad de elementos esperados");
                    return false;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    public boolean verificarExistenciaArchivo(String ruta) {
        File file = new File(ruta);

        // Checks if file1 exists
        if (file.exists() && !file.isDirectory()) {
            validarEstructuraArchivo(ruta, 2, ',');
            return true;
        } else {
            return false;
        }
    }

    public String[][] leerArchivoUsuarios() {
        String SEPARADOR = ",";
        String[][] usersArray;
        int index = 0;

        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(
                    new FileReader("C://Users//Geovanna Medina//Downloads//Diseno//Diseno//database.csv"));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();

            while (linea != null) {
                // Separar la linea leída con el separador definido previamente
                String[] user = linea.split(SEPARADOR);
                // guarda el primer user en el array
                usersArray[index] = user; // guarda el user en el arreglo de
                index = index + 1;

                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return usersArray;
    }

    public void updateLine(String str) {

    }

}
