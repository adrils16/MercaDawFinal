package es.tiernoparla.daw.mercadaw.utils.writer;

import es.tiernoparla.daw.mercadaw.utils.writer.enums.TipoDocumento;

public class ExportFactory {
    
    public static Exportable obtenerExport(TipoDocumento tipo){

        if (tipo == TipoDocumento.DOCX) {
            return new WordUtil();
        } else if (tipo == TipoDocumento.PDF) {
            return new PDFUtil();
        } else if (tipo == TipoDocumento.EXCEL) {
            return new ExcelUtil();
        } else {
            return new EscritorMock();
        }
    }
}
