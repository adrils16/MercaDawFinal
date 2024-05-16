package es.tiernoparla.daw.mercadaw.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase realiza todas las operaciones relacionadas con la Base de Datos
 */
public class MercaDawMariaDBDAOImp extends MercaDawDAOImp {

    // private final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    // private final String DATABASE_NAME = "mercadaw";
    // private final String DATABASE_USER = "usuario";
    // private final String DATABASE_PASS = "usuario";

    private Connection conexion;

    // public MercaDawMariaDBDAOImp() {
    //     try {
    //         conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         //TODO Excepcion personalizada
    //     }
    // }
    
    private String leerScriptSQL(String rutaScript) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaScript))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        }
        return sb.toString();
    }

    private void ejecutarScriptSQL(String script) throws SQLException {
        try (Statement statment = conexion.createStatement()) {
            statment.executeUpdate(script);
        }
    }
}
