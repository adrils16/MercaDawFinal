package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class Cajero extends Empleado {

    public Cajero(String nombre, String apellidos, int id, String categoria, int sueldo) {
        
        super(nombre, apellidos, id, categoria, sueldo);
        
    }
    
}
