public class administradorUsuarios {

    private String[][] usuarios;

    public administradorUsuarios(String[][] usuarios) {
        this.usuarios = usuarios;
    }

    boolean AutenticarUsuario(String usuario, String contrasenia) {

        return true;
    }

    void registrarLoginIncorrecto(String usuario) {

    }

    boolean usuarioBloqueado(String usuario) {

        return true;
    }
}
