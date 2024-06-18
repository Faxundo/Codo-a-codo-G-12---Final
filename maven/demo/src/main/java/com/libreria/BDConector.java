package com.libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDConector {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/trabajo_final";
	public static String USER = "root";
	public static String PASS = "milProgramadores2022";

    public static void main(String[] args) {

        // Conexión a la base de datos
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", "milProgramadores2022");

            // Creación de un statement para ejecutar consultas
            Statement statement = connection.createStatement();

            // Ejecución de la consulta
            // en resultset tengo todas las películas traidas desde mysql
            ResultSet resultSet = statement.executeQuery("SELECT * FROM category");

            // Procesamiento de los resultados
            while (resultSet.next()) {
                System.out.println("id:" +  resultSet.getString("id") + " titulo: " + resultSet.getString("title"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
