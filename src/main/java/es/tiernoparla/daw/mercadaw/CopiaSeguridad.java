package es.tiernoparla.daw.mercadaw;

import es.tiernoparla.daw.mercadaw.utils.export.ExportarCSV;

public class CopiaSeguridad {

    public static void main(String[] args) {
        ExportarCSV exportarCSV = new ExportarCSV();
        exportarCSV.exportarCSV(exportarCSV.CLIENTES, "backup/clientes.csv");
        exportarCSV.exportarCSV(exportarCSV.COMPRAS, "backup/compras.csv");
        exportarCSV.exportarCSV(exportarCSV.EMPLEADOS, "backup/empleados.csv");
        exportarCSV.exportarCSV(exportarCSV.PRODUCTO_SEDE, "backup/producto_sede.csv");
        exportarCSV.exportarCSV(exportarCSV.PRODUCTOS, "backup/productos.csv");
        exportarCSV.exportarCSV(exportarCSV.SEDE, "backup/sede.csv");
        exportarCSV.exportarCSV(exportarCSV.COMPRA_PRODUCTOS, "backup/compra_productos.csv");
    }
}
