package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class Reponedor extends Empleado{
    
    public final static CategoriaEmpleado CATEGORIA = CategoriaEmpleado.REPONEDOR;
    public final static int SUELDO = CATEGORIA.getSueldo();

    public Reponedor(String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
        //TODO Auto-generated constructor stub
    }
}
