public class Usuario {

    private String login;
    private String contrasenia;
    private int numLoginFallados;

    public Usuario(String login, String contrasenia, int numLoginFallados) {
        this.login = login;
        this.contrasenia = contrasenia;
        this.numLoginFallados = numLoginFallados;
    }

    int loginfallido() {

        return 0;
    }

}