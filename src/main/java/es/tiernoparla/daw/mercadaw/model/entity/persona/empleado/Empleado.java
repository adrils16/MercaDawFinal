package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.persona.Persona;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class Empleado extends Persona implements Imprimible{

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

    @Override
    public String imprimir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimir'");
    }

}
