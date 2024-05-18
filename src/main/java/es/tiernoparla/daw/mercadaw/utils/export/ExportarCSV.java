package es.tiernoparla.daw.mercadaw.utils.export;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ExportarCSV {

    public final String PRODUCTOS = "SELECT * FROM VISTA_PRODUCTOS";
    public final String EMPLEADOS = "SELECT * FROM VISTA_EMPLEADOS";
    public final String CLIENTES = "SELECT * FROM VISTA_CLIENTES";
    public final String COMPRAS = "SELECT * FROM VISTA_COMPRA";
    public final String PRODUCTO_SEDE = "SELECT * FROM VISTA_PRODUCTO_SEDE";
    public final String SEDE = "SELECT * FROM VISTA_SEDE";
    public final String COMPRA_PRODUCTOS = "SELECT * FROM VISTA_COMPRA_PRODUCTOS";
    
    private final String URL = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s";
    private final String DATABASE_NAME = "mercadaw";
    private final String DATABASE_USER = "root";
    private final String DATABASE_PASS = "secret";

    private Connection conexion;

    public ExportarCSV() {
        try {
            conexion = DriverManager.getConnection(String.format(URL, DATABASE_NAME, DATABASE_USER, DATABASE_PASS));
        } catch (SQLException e) {
        }
    }

    public boolean exportarCSV(String tabla, String ruta) {
        boolean exito = true;

        try {
            PreparedStatement ps = conexion.prepareStatement(tabla);

            ResultSet rs = ps.executeQuery();

            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));

            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL.withHeader(rs));
            printer.printRecords(rs);
            printer.close();

            writer.close();
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            System.err.print(e);
        } 

        return exito;
    }
}
