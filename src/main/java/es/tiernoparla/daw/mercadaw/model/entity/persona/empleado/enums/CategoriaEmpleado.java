package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums;

/**
 * Enumeración que contiene las categorias de los empleados, junto al sueldo asociado a cada categoria como atributo.
 */
public enum CategoriaEmpleado {
    EMPLEADO(1000),
    REPONEDOR(1200),
    CAJERO(1300),
    ENCARGADO(1500);

    private int sueldo;

    private CategoriaEmpleado(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }
}
