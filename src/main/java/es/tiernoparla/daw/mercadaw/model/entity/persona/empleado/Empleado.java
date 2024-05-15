package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.persona.Persona;
import es.tiernoparla.daw.mercadaw.model.enums.CategoriaEmpleado;

public class Empleado extends Persona implements Gestionable{

    public final static CategoriaEmpleado CATEGORIA = CategoriaEmpleado.EMPLEADO;
    public final static int SUELDO = CATEGORIA.getSueldo();

    protected int id;

    public Empleado(String nombre, String apellidos, int id) {
        super(nombre, apellidos);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
