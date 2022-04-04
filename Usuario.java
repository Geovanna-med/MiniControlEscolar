import java.util.Date;
import java.util.Calendar;

public class Usuario {

    private String login;
    private String contrasenia;
    private int numLoginFallidos;
    private Date tiempoBloqueo;

    public int getNumLoginFallidos() {
        return numLoginFallidos;
    }

    public void setNumLoginFallidos(int numLoginFallidos) {
        this.numLoginFallidos = numLoginFallidos;
    }

    public Date getTiempoBloqueo() {
        return tiempoBloqueo;
    }

    public void setTiempoBloqueo(Date tiempoBloqueo) {
        this.tiempoBloqueo = tiempoBloqueo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    public Usuario(String login, String contrasenia, int numLoginFallados, Date tiempoBloqueo) {
        this.login = login;
        this.contrasenia = contrasenia;
        this.numLoginFallidos = numLoginFallados;
        this.tiempoBloqueo = tiempoBloqueo;
    }

    public Usuario(String login, String contrasenia) {
        this.login = login;
        this.contrasenia = contrasenia;
    }

    int loginfallido() {

        return 0;
    }

}