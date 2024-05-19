package es.tiernoparla.daw.mercadaw.utils.export.enums;

/**
 * TODO Documentar Enum, revisar si funciona con las nuevas tablas. Si no funciona también hay que revisar la clase CopiaSeguridad al cambiar este ENUM.
 */
public enum Tabla {
    PRODUCTOS("SELECT EAN, NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION FROM VISTA_PRODUCTOS"),
    EMPLEADOS("SELECT ID_EMPLEADO, NOMBRE, APELLIDOS, SALARIO, CATEGORIA FROM VISTA_EMPLEADOS"),
    CLIENTES("SELECT ID_CLIENTE, NOMBRE, APELLIDOS, COD_POSTAL FROM VISTA_CLIENTES"),
    COMPRA("SELECT ID_COMPRA, FECHA_COMPRA, ID_CLIENTE FROM VISTA_COMPRA"),
    PRODUCTO_SEDE("SELECT EAN, UBICACION, STOCK FROM VISTA_PRODUCTO_SEDE"),
    SEDE("SELECT UBICACION FROM VISTA_SEDE"),
    COMPRA_PRODUCTOS("SELECT EAN, ID_COMPRA, CANTIDAD FROM VISTA_COMPRA_PRODUCTOS");

    private String query;

    private Tabla(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
