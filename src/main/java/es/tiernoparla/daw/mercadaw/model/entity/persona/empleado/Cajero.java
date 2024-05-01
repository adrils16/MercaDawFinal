package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.enumeracion.CategoriaEmpleado;

public class Cajero extends Empleado {
    
    public final static CategoriaEmpleado CATEGORIA = CategoriaEmpleado.CAJERO;
    public final static int SUELDO = CATEGORIA.getSueldo();

    public Cajero(String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
        //TODO Auto-generated constructor stub
    }

}
