package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class Encargado extends Empleado {
    
    public final static CategoriaEmpleado CATEGORIA = CategoriaEmpleado.ENCARGADO;
    public final static int SUELDO = CATEGORIA.getSueldo();

    public Encargado(String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
        //TODO Auto-generated constructor stub
    }
}
