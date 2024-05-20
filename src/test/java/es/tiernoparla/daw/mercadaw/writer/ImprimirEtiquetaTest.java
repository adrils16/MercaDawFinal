package es.tiernoparla.daw.mercadaw.writer;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.controller.MercadawController;
import es.tiernoparla.daw.mercadaw.utils.writer.PDFUtil;

public class ImprimirEtiquetaTest {
    @Test
    void imprimirEtiquetaTest() throws Exception{
        MercadawController mc = new MercadawController();
        mc.imprimirEtiqueta(2);
        PDFUtil.exportarEtiquetaPDF();
    }
}
