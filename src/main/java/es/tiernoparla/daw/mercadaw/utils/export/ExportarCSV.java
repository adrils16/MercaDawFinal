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

/**
 * TODO Documentar Clase
 */
public class ExportarCSV {

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

    /**
     * TODO Documentar método
     * @param tabla
     * @param ruta
     * @return
     */
    public boolean exportarCSV(String tabla, String ruta) {
        boolean exito = true;

        try {
            PreparedStatement ps = conexion.prepareStatement(tabla);

            ResultSet rs = ps.executeQuery();

            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));

            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.builder().setHeader(rs).build());
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
