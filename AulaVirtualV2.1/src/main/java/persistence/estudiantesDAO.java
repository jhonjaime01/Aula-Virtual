package persistence;

import Logic.Login;
import Logic.NombreMateria;
import Logic.Student;
import config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class estudiantesDAO {

    Conexion cn = new Conexion();
    Connection con;

    PreparedStatement ps;

    ResultSet rs;



    public ArrayList<Student> listadoMaterias(){
        ArrayList<Student> listado=new ArrayList<>();

        // String query = "SELECT * FROM Login WHERE usuario = ? AND contrasena = ?";
        String query = "select student_id, apellido, nombre from Estudiantes;";
        ;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");

                listado.add(new Student(studentId, apellido, nombre));
            }
        } catch (Exception e) {
        }
        return listado;
    }
}