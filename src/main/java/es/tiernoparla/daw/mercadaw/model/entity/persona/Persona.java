package es.tiernoparla.daw.mercadaw.model.entity.persona;

/**
 * Clase que definite los atributos comunes de las personas.
 */
public abstract class Persona {

    public static final String ATT_NOMBRE = "nombre";
    public static final String ATT_APELLIDOS = "apellidos";
    
    protected String nombre;
    protected String apellidos;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
}
