package es.tiernoparla.daw.mercadaw;

import es.tiernoparla.daw.mercadaw.utils.export.ExportarCSV;
import es.tiernoparla.daw.mercadaw.utils.export.enums.Tabla;

public class CopiaSeguridad {

    public static void main(String[] args) {
        ExportarCSV exportarCSV = new ExportarCSV();
        exportarCSV.exportarCSV(Tabla.CLIENTES.getQuery(), "backup/clientes.csv");
        exportarCSV.exportarCSV(Tabla.COMPRA.getQuery(), "backup/compras.csv");
        exportarCSV.exportarCSV(Tabla.EMPLEADOS.getQuery(), "backup/empleados.csv");
        exportarCSV.exportarCSV(Tabla.PRODUCTO_SEDE.getQuery(), "backup/producto_sede.csv");
        exportarCSV.exportarCSV(Tabla.PRODUCTOS.getQuery(), "backup/productos.csv");
        exportarCSV.exportarCSV(Tabla.SEDE.getQuery(), "backup/sede.csv");
        exportarCSV.exportarCSV(Tabla.COMPRA_PRODUCTOS.getQuery(), "backup/compra_productos.csv");
    }
}
