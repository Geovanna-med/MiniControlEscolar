import java.io.IOException;
import java.util.Scanner;

public class Sistema {
    private AdministradorUsuarios administradorUsuarios;

    private ManagerArchivo managerArchivo = new ManagerArchivo();

    public boolean verificarArchivoUsuario() {
        if (managerArchivo.verificarExistenciaArchivo("./database.csv") == true) {
            return true;
        }
        return false;

    }

    public void mostrarInterfazUsuario() {
        boolean usuarioCorrecto;
        do {
            usuarioCorrecto = ingresarUsuarioContra();
        } while (!usuarioCorrecto);

        mostrarMenu();

    }

    public boolean ingresarUsuarioContra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuario: ");
        String user = sc.nextLine();

        System.out.println("Contrasenia: ");
        String contrasenia = sc.nextLine();

        if (verificarUsuarioContra(user, contrasenia) == true) {
            return true;
        } else {
            alertaUsuarioContraIncorrecta();
        }
        sc.close();
        return false;
    }

    public boolean verificarUsuarioContra(String usuario, String contrasenia) {
        Usuario currentUsuario;
        String[][] users = null;
        try {
            users = managerArchivo.leerArchivoUsuarios("./database.csv", 4, ",");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < users.length; i++) {

            currentUsuario = new Usuario(users[i][0], users[i][1]);
            if (currentUsuario.getLogin().equals(usuario)) {
                return true;
            }

        }
        return false;

    }

    public void mostrarMenu() {
        String menu = ("|-------------------Menú---------------|\n" +
                "| 0. Salir                             |\n" +
                "| 1. Capturar calificaciones           |\n" +
                "| 2. Generar un archivo de tipo .csv   |\n" +
                "| 3. Generar un archivo de tipo .pdf   |\n" +
                "|--------------------------------------|");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(menu);
            int seleccion = sc.nextInt();
            sc.nextLine();
            switch (seleccion) {
                case 0:
                    return;
                case 1:
                    System.out.println("Capturando calificaciones");
                    break;
                case 2:
                    System.out.println("Generando .csv");
                    break;
                case 3:
                    System.out.println("Generando .pdf");
                    break;
            }
        }
    }

    public void alertaArchivoUsuariosNoExiste() {
        System.out.println("El archivo no existe");

    }

    public void cargarUsuarios() {
        String separador = ",";
        String[][] usuariosInfo;
        try {
            usuariosInfo = managerArchivo.leerArchivoUsuarios("./database.csv", 4, separador);
            administradorUsuarios = new AdministradorUsuarios(usuariosInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void alertaUsuarioContraIncorrecta() {
        System.out.println("Contrasenia o usuario incorrecto");

    }

    void registrarLoginIncorrecto() {

    }

    public void alertaUsuarioBloqueado() {
        System.out.println("Usted ha alcanzado el maximo de intentos. Intentelo de nuevo en 10 minutos");

    }

}
