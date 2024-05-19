package es.tiernoparla.daw.mercadaw.utils.writer.interfaces;

import java.io.IOException;

/**
 * TODO Documentar interface y método
 */
public interface Exportable {
    public byte[] crearFichero(Documento doc) throws IOException;
}
