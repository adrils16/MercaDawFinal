package es.tiernoparla.daw.mercadaw.model.entity.persona;

/**
 * Clase que define los atributos de los clientes.
 */
public class Cliente extends Persona{

    private int codPostal;
    private String email;

    public Cliente(String nombre, String apellidos, int codPostal, String email) {
        super(nombre, apellidos);
        this.codPostal = codPostal;
        this.email = email;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
