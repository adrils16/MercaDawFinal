package es.tiernoparla.daw.mercadaw.writer;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.controller.MercadawController;

public class ImprimirEtiquetaTest {
    @Test
    void imprimirEtiquetaTest() throws Exception{
        MercadawController mc = new MercadawController();
        mc.imprimirEtiqueta(2);
    }
}
