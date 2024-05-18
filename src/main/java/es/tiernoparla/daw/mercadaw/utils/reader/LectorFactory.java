package es.tiernoparla.daw.mercadaw.utils.reader;

import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;

/**
 * Clase que se encarga de devolver un lector en función del tipo de lector que se le pase
 */
public class LectorFactory {
    public static Lector obtenerLector(TipoLector lector) {
        
        if (lector == TipoLector.CSV) {
            return new LectorCSV();
        } else if (lector == TipoLector.JSON) {
            return new LectorJSON();
        } else {
            return new LectorMock();
        }
    }
}
