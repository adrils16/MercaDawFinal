package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.Connection;


/**
 * Esta clase realiza todas las operaciones relacionadas con la Base de Datos
 */
public class MercaDawMariaDBDAOImp extends MercaDawDAOImp{



    // private final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    // private final String DATABASE_NAME = "mercadaw";
    // private final String DATABASE_USER = "usuario";
    // private final String DATABASE_PASS = "usuario";

    private Connection conexion;
    
    // private String leerScriptSQL(String rutaScript) throws IOException {
    //     StringBuilder sb = new StringBuilder();
    //     try (BufferedReader br = new BufferedReader(new FileReader(rutaScript))) {
    //         String linea;
    //         while ((linea = br.readLine()) != null) {
    //             sb.append(linea).append("\n");
    //         }
    //     }
    //     return sb.toString();
    // }

    // private void ejecutarScriptSQL(String script) throws SQLException {
    //     try (Statement statment = conexion.createStatement()) {
    //         statment.executeUpdate(script);
    //     }
    // }
}
