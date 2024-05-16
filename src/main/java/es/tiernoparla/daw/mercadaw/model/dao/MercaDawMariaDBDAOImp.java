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

    private final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    private final String DATABASE_NAME = "mercadaw";
    private final String DATABASE_USER = "usuario";
    private final String DATABASE_PASS = "usuario";

    private Connection conexion;

    public MercaDawMariaDBDAOImp() throws Exception{
        conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
    }

    // public MercaDawMariaDBDAOImp(Connection conexion, Connection conexion2) throws SQLException{
    //     super(conexion);
    //     conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
    // }



    /**
     * Crea la tabla PRODUCTOS.
     */
    @Override
    public void crearTablaProductos() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS PRODUCTOS (" +
                    "ID_PRODUCTO INT AUTO_INCREMENT PRIMARY KEY," +
                    "NOMBRE VARCHAR(50) NOT NULL," +
                    "MARCA VARCHAR(25) NOT NULL," +
                    "PRECIO NUMBER NOT NULL," +
                    "ALTURA NUMBER NOT NULL," +
                    "ANCHURA NUMBER NOT NULL," +
                    "PESO NUMBER NOT NULL," +
                    "NUM_ELEMENTOS INT NOT NULL," +
                    "DESCRIPCION VARCHAR(100) NOT NULL)";

        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    /**
     * Crea la tabla EMPLEADOS.
     */
    @Override
    public void crearTablaEmpleados() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS EMPLEADOS (" +
                            "ID_EMPLEADO INT AUTO_INCREMENT PRIMARY KEY," +
                            "NOMBRE VARCHAR(25) NOT NULL," +
                            "APELLIDOS VARCHAR(25) NOT NULL," +
                            "SALARIO NUMBER NOT NULL)";

        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }

    /**
     * Crea la tabla COMPRA.
     */
    @Override
    public void crearTablaCompras() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS COMPRA (" +
                        "ID_COMPRA INT AUTO_INCREMENT PRIMARY KEY," +
                        "HORA NUMBER NOT NULL," +
                        "FECHA DATE NOT NULL," +
                        "DNI VARCHAR(9) NOT NULL," +
                        "FOREIGN KEY (DNI) REFERENCES CLIENTE(DNI))";
        PreparedStatement st = conexion.prepareStatement(sql);

        st.execute();
        st.close();
    }
    
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
