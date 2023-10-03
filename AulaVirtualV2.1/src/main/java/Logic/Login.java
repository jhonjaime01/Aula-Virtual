package Logic;

public class Login {
    private int login_id;
    private String usuario;
    private String contrasena;

    private String tipo_Persona;

    public Login() {
    }
    public Login(int login_id, String usuario, String contrasena, String tipo_Persona) {
        this.login_id = login_id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo_Persona=tipo_Persona;
    }


    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo_Persona() {
        return tipo_Persona;
    }

    public void setTipo_Persona(String tipo_Persona) {
        this.tipo_Persona = tipo_Persona;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login_id=" + login_id +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipo_Persona='" + tipo_Persona + '\'' +
                '}';
    }
}
