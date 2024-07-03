package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que permite hacer consultas a la base de datos
 * 
 * @author Santos Sanchez
 */
public class ConnectorDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/libreria";
    private static Connection conn;
    private static Statement st;

    static {
         // Conexión a la base de datos
         try {
            conn=DriverManager.getConnection(DB_URL, "root", "milProgramadores2022");

            
            // Creación de un statement para ejecutar consultas
            st= conn.createStatement();

        } catch (SQLException e) {
            System.out.print(e);
        }

    }

    public static Connection getConn() {
        return conn;
    }



    public static Statement getSt() {
        return st;
    }


}
