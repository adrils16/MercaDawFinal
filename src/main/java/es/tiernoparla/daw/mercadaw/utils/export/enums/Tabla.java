package es.tiernoparla.daw.mercadaw.utils.export.enums;

/**
 * Clase de tipo enum que contiene las consultas de las tablas de la base de datos
 */
public enum Tabla {
    PRODUCTOS("SELECT EAN, NOMBRE, MARCA, PRECIO, ALTURA, ANCHURA, PESO, NUM_ELEMENTOS, DESCRIPCION, CATEGORIA FROM VISTA_PRODUCTOS"),
    EMPLEADOS("SELECT ID_EMPLEADO, NOMBRE, APELLIDOS, SALARIO, CATEGORIA FROM VISTA_EMPLEADOS"),
    CLIENTES("SELECT ID_CLIENTE, NOMBRE, APELLIDOS, COD_POSTAL FROM VISTA_CLIENTES"),
    SEDE("SELECT UBICACION FROM VISTA_SEDE"),
    COMPRA("SELECT ID_COMPRA, FECHA_COMPRA, ID_CLIENTE FROM VISTA_COMPRA"),
    COMPRA_PRODUCTOS("SELECT EAN, ID_COMPRA, CANTIDAD FROM VISTA_COMPRA_PRODUCTOS"),
    PRODUCTO_SEDE("SELECT EAN, UBICACION, STOCK FROM VISTA_PRODUCTO_SEDE");

    private String query;

    private Tabla(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
