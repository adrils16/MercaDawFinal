package es.tiernoparla.daw.mercadaw;

import es.tiernoparla.daw.mercadaw.utils.export.ExportarCSV;
import es.tiernoparla.daw.mercadaw.utils.export.enums.Ruta;
import es.tiernoparla.daw.mercadaw.utils.export.enums.Tabla;

public class CopiaSeguridad {

    public static void main(String[] args) {
        ExportarCSV exportarCSV = new ExportarCSV();
        exportarCSV.exportarCSV(Tabla.CLIENTES.getQuery(), Ruta.CLIENTES.getRuta());
        exportarCSV.exportarCSV(Tabla.COMPRA.getQuery(), Ruta.COMPRA.getRuta());
        exportarCSV.exportarCSV(Tabla.EMPLEADOS.getQuery(), Ruta.EMPLEADOS.getRuta());
        exportarCSV.exportarCSV(Tabla.PRODUCTO_SEDE.getQuery(), Ruta.PRODUCTO_SEDE.getRuta());
        exportarCSV.exportarCSV(Tabla.PRODUCTOS.getQuery(), Ruta.PRODUCTOS.getRuta());
        exportarCSV.exportarCSV(Tabla.SEDE.getQuery(), Ruta.SEDE.getRuta());
        exportarCSV.exportarCSV(Tabla.COMPRA_PRODUCTOS.getQuery(), Ruta.COMPRA_PRODUCTOS.getRuta());
    }
}
