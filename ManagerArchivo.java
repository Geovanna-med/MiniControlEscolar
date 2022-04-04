import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManagerArchivo { // checar que hago lo que se supone debe hacer

    public boolean validarEstructuraArchivo(String ruta, int elementos, String separador) {
        BufferedReader lector = null;

        try {
            // Abrir el .csv
            lector = new BufferedReader(new FileReader(ruta));

            // Definir el string de la línea leída
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] tokens = linea.split(separador);
                if (tokens.length != elementos) {
                    lector.close();
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
            validarEstructuraArchivo(ruta, 3, ",");
            return true;
        } else {
            System.out.println("El archivo no existe");
            return false;
        }
    }

    public String[][] leerArchivoUsuarios(String ruta, int elementos, String separador)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String st;

        long fileLength = countFileLines(ruta);
        String[][] users = new String[(int) fileLength][];

        int currentLine = 0;
        while ((st = br.readLine()) != null) {
            String[] userInfo = st.split(separador);
            users[currentLine] = userInfo;
            currentLine++;
        }

        br.close();
        return users;
    }

    public void updateLine(String ruta, int line, String info) throws FileNotFoundException {

        String filePath = ruta;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();

        int index = 0;
        String oldLine = "";
        while (sc.hasNextLine()) {

            String nextLine = sc.nextLine();
            buffer.append(nextLine + System.lineSeparator());

            if (index == line) {
                oldLine = nextLine;
            }
            index++;
        }

        String fileContents = buffer.toString();

        sc.close();

        fileContents = fileContents.replace(oldLine, info);

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.append(fileContents);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private long countFileLines(String ruta) {
        Path filePath = Paths.get(ruta);
        long lines = 0;
        try {
            lines = Files.lines(filePath).count();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
