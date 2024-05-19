package es.tiernoparla.daw.mercadaw.utils.export.enums;

/**
 * TODO Documentar Enum
 */
public enum Ruta {
    PRODUCTOS("backup/productos.csv"),
    EMPLEADOS("backup/empleados.csv"),
    CLIENTES("backup/clientes.csv"),
    COMPRA("backup/compras.csv"),
    PRODUCTO_SEDE("backup/producto_sede.csv"),
    SEDE("backup/sede.csv"),
    COMPRA_PRODUCTOS("backup/compra_productos.csv");

    private String ruta;

    Ruta(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

}
