package es.tiernoparla.daw.mercadaw.model.enums;

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
