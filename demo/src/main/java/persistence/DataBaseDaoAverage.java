package persistence;

import logic.Activity;
import logic.Average;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseDaoAverage {



    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private final String URL = "jdbc:mysql://127.0.0.1:3306/sistema_notas?allowPublicKeyRetrieval=true&useSSL=false";


    private final String USER = "root";

    private final String PASSWORD = "password";



    public ArrayList<Average> getAverage() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT m.materiaNombre, ROUND(AVG(a.calificacionAct), 1) AS promedio_calificaciones\n" +
                    "FROM sistema_notas.materia m\n" +
                    "LEFT JOIN sistema_notas.actividades a ON m.materia_id = a.materia_id\n" +
                    "GROUP BY m.materiaNombre\n" +
                    "HAVING promedio_calificaciones IS NOT NULL;";
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<Average> list = new ArrayList<>();
            while (resultSet.next()) {

                String materiaNombre = resultSet.getString("materiaNombre");
                String promedio_calificaciones = String.valueOf((resultSet.getDouble("promedio_calificaciones")));

                list.add(new Average(materiaNombre,promedio_calificaciones));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }







}
