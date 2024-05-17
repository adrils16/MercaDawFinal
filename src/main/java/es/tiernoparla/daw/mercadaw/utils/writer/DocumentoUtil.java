package es.tiernoparla.daw.mercadaw.utils.writer;

import java.io.IOException;

import es.tiernoparla.daw.mercadaw.utils.writer.interfaces.Documento;
import es.tiernoparla.daw.mercadaw.utils.writer.interfaces.Exportable;

public abstract class DocumentoUtil implements Exportable{
    
    public byte[] crearFichero(Documento doc) throws IOException{
        
        return null;
    }
}
