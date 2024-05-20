package es.tiernoparla.daw.mercadaw.writer;


import java.io.IOException;

import org.junit.jupiter.api.Test;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.utils.writer.MarkdownUtil;
import es.tiernoparla.daw.mercadaw.utils.writer.NominaMercaDAW;
import es.tiernoparla.daw.mercadaw.utils.writer.PDFUtil;
import es.tiernoparla.daw.mercadaw.utils.writer.interfaces.RecursosHumanos;

public class NominaMercaDAWTest {
    
    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.CAJERO, "Luis", "Enrique", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Carlo", "Ancelotti", 2);
    RecursosHumanos n = new NominaMercaDAW();
    PDFUtil pdf = new PDFUtil();
    
    @Test
    void calcularNominaTest(){
        
        System.err.println(n.calcularImportes(e1));
        n.calcularImportes(e2);
    }

    @Test
    void exportarMdText() throws IOException{

        MarkdownUtil.crearNominaMd(n.calcularImportes(e1));
    }

    @Test
    void exportarPDFText() throws IOException, InterruptedException{
        PDFUtil.exportarNominaPDF();
    }

}
