package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.IOException;

public interface Exportable {
    public byte[] crearFichero(Documento doc) throws IOException;
}
