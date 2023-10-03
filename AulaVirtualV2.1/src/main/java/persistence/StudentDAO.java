package persistence;

import Logic.Login;
import Logic.NombreMateria;
import config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {

    Conexion cn = new Conexion();
    Connection con;

    PreparedStatement ps;

    ResultSet rs;


    public ArrayList<NombreMateria> listadoMaterias(String user){
        ArrayList<NombreMateria> listado=new ArrayList<>();

       // String query = "SELECT * FROM Login WHERE usuario = ? AND contrasena = ?";
        String query = "SELECT C.nombre AS NombreMateria FROM Login L INNER JOIN Estudiantes E ON L.student_ids = E.student_id INNER JOIN EstudiantesCursos EC ON E.student_id = EC.student_id INNER JOIN Cursos C ON EC.course_id = C.course_id WHERE L.usuario = ?";
        ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()){
                listado.add(new NombreMateria(rs.getString("NombreMateria")));
            }
        } catch (Exception e) {
        }
        return listado;
    }
}