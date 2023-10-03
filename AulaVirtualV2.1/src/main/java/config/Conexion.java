package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    private String url = "jdbc:mysql://127.0.0.1:3306/uptc?allowPublicKeyRetrieval=true&useSSL=false";
    private String user = "PR3";

    private String pass="@27Sep2022";

    public Connection Conexion(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            System.out.println("No hubo conexion");
        }
        return con;
    }
}
