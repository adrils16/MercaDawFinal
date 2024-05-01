package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.enumeracion.CategoriaEmpleado;

public class EmpleadoFactory {
    
    public Empleado crear(CategoriaEmpleado tipo, String nombre, String apellidos, int id) {

        Empleado e = null;

        switch (tipo) {
            
            case EMPLEADO:
                e = new Empleado(nombre, apellidos, id);
                break;
        
            case REPONEDOR:
                e = new Reponedor(nombre, apellidos, id);
                break;

            case CAJERO: 
                e = new Cajero(nombre, apellidos, id);
                break;

            case ENCARGADO:
                e = new Encargado(nombre, apellidos, id);
                break;

        }

        return e;
    }
}
