package es.tiernoparla.daw.mercadaw.utils.reader;

import es.tiernoparla.daw.mercadaw.exception.FicheroException;
import es.tiernoparla.daw.mercadaw.exception.LectorException;

/**
 * Clase abstracta que implementa la interfaz Lector.
 * 
 */
public abstract class LectorImp implements Lector {

    final String MSG_ERROR = "Fichero no válido";

    /**
     * Comprueba si un código es válido.
     * 
     * @param codigo Código a comprobar.
     * @throws Exception Si el código no es válido.
     */
    public void comprobar(String codigo) throws LectorException {
        if (codigo.equals(null) && codigo.equals("")) {
            throw new FicheroException(MSG_ERROR);
        }
    }
}
