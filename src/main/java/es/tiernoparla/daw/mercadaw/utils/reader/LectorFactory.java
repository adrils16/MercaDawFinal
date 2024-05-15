package es.tiernoparla.daw.mercadaw.utils.reader;

import es.tiernoparla.daw.mercadaw.utils.reader.enumeracion.TipoLector;

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
