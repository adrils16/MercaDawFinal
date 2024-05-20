package es.tiernoparla.daw.mercadaw.model.entity.interfaces;

/**
 * Esta interfaz clasifica las clases Imprimibles y les obliga a implementar el método imprimir(), 
 * que devuelve información detallada del objeto en un String.
 */
public interface Imprimible {
    
    /**
     * Devuelve un String con información detallada del objeto
     * @return String con información detallada.
     */
    public String imprimir();

}
