package persistence;

import Logic.Login;
import config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    Conexion cn = new Conexion();
    Connection con;

    PreparedStatement ps;

    ResultSet rs;

    public Login validar(String user, String password){
        Login lg = new Login();
        String query = "SELECT * FROM Login WHERE usuario = ? AND contrasena = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()){
                lg.setLogin_id(rs.getInt("login_id"));
                lg.setUsuario(rs.getString("usuario"));
                lg.setContrasena(rs.getString("contrasena"));
                lg.setTipo_Persona(rs.getString("tipo_usuario"));
            }
        } catch (Exception e) {
        }
        return lg;
    }
}