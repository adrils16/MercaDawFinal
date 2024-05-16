package es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.persona.Persona;

public class Empleado extends Persona implements Imprimible{

    protected int id;
    protected String categoria;
    protected int sueldo;

    public Empleado(String nombre, String apellidos, int id, String categoria, int sueldo) {
        
        super(nombre, apellidos);
        this.id = id;
        this.categoria = categoria;
        this.sueldo = sueldo;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String imprimir() {
        
        final String TEXTO = "* Identificador: %s\n"
                            +"* Nombre: %s\n"
                            +"* Apellidos: %s\n"
                            +"* Categoría: %s\n";

        String cadena = String.format(TEXTO, id, nombre, apellidos, categoria);

        return cadena;

    }

}
