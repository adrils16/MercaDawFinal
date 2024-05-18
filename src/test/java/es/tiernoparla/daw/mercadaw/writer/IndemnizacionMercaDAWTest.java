package es.tiernoparla.daw.mercadaw.writer;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.utils.writer.FiniquitoMercaDAW;
import es.tiernoparla.daw.mercadaw.utils.writer.MarkdownUtil;
import es.tiernoparla.daw.mercadaw.utils.writer.PDFUtil;

public class IndemnizacionMercaDAWTest {

    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.CAJERO, "Luis", "Enrique", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Carlo", "Ancelotti", 2);
    FiniquitoMercaDAW f = new FiniquitoMercaDAW();
    PDFUtil pdf = new PDFUtil();
    
    @Test
    void calcularIndemnizacionTest(){
        
        System.err.println(f.calcularIndemnizacion(e1));
        f.calcularIndemnizacion(e2);
    }

    @Test
    void exportarMdText() throws IOException{

        MarkdownUtil.crearFiniquitoMd(f.calcularIndemnizacion(e1));
    }

    @Test
    void exportarPDFText() throws IOException{
        PDFUtil.exportarFiniquitoPDF();
    }
}
