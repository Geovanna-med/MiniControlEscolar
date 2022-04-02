import javax.lang.model.util.ElementScanner14;

public class Sistema {

    String rutaArchivo = "C:/Users/Geovanna Medina/Downloads/Diseno/Diseno/database.csv";
    ManagerArchivo managerArchivo = new ManagerArchivo();

    public boolean verificarArchivoUsuario() {
        if (managerArchivo.verificarExistenciaArchivo(rutaArchivo) == true) {
            managerArchivo.validarEstructuraArchivo(rutaArchivo, 2, ',');

            return true;
        } else {
            System.out.println("El archivo no se pudo verificar correctamente");
            return false;
        }

    }

    private void mostrarInterfazUsuario() {

    }

    public void IngresarUsuarioContra() {

    }

    public boolean verificarUsuarioContra() {

        return true;
    }

    public void mostrarMenu() {

    }

    private void alertaArchivoUsuariosNoExiste() {

    }

    public void cargarUsuarios() {

    }

    public void alertaUsuarioContraIncorrecta() {

    }

    void registrarLoginIncorrecto() {

    }

    public void alertaUsuarioBloqueado() {

    }

}
