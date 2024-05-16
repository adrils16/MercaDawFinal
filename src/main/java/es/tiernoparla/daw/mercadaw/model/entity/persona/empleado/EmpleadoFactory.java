package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class EmpleadoFactory {
    
    public static Empleado crear(CategoriaEmpleado tipo, String nombre, String apellidos, int id) {

        final String C_EMPLEADO  = "Empleado";
        final String C_REPONEDOR = "Reponedor";
        final String C_CAJERO = "Cajero";
        final String C_ENCARGADO = "Encargado";

        Empleado e = null;
        String categoria;
        int sueldo = tipo.getSueldo();

        switch (tipo) {
            
            case EMPLEADO:
                categoria = C_EMPLEADO;
                e = new Empleado(nombre, apellidos, id, categoria, sueldo);
                break;
        
            case REPONEDOR:
                categoria = C_REPONEDOR;
                e = new Reponedor(nombre, apellidos, id, categoria, sueldo);
                break;

            case CAJERO: 
                categoria = C_CAJERO;
                e = new Cajero(nombre, apellidos, id, categoria, sueldo);
                break;

            case ENCARGADO:
                categoria = C_ENCARGADO;
                e = new Encargado(nombre, apellidos, id, categoria, sueldo);
                break;

        }

        return e;
    }
}
