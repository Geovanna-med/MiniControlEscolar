/**
 * App
 */
public class App {

    public static void main(String[] args) {

        // Sistema sistema = new Sistema();
        Sistema sistema = new Sistema();

        if (sistema.verificarArchivoUsuario() == true) {
            sistema.cargarUsuarios();
            sistema.mostrarInterfazUsuario();
        } else {
            sistema.alertaArchivoUsuariosNoExiste();
        }

    }
}
