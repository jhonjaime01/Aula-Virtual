package persistence;



import logic.Activity;
import logic.Average;
import logic.averageTotal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseDaoAverageTotal {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private final String URL = "jdbc:mysql://127.0.0.1:3306/sistema_notas?allowPublicKeyRetrieval=true&useSSL=false";


    private final String USER = "root";

    private final String PASSWORD = "password";



    public ArrayList<averageTotal> getAverage() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT AVG(calificacionAct) AS PromedioNotas FROM sistema_notas.actividades";
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<averageTotal> list = new ArrayList<>();
            while (resultSet.next()) {


                String promedio_calificaciones = String.valueOf((resultSet.getDouble("PromedioNotas")));

                list.add(new averageTotal(promedio_calificaciones));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }







}
