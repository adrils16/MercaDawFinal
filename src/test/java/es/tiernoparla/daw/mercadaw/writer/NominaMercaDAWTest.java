package es.tiernoparla.daw.mercadaw.writer;


import org.junit.jupiter.api.Test;


import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.utils.writer.Nomina;
import es.tiernoparla.daw.mercadaw.utils.writer.NominaMercaDAW;

public class NominaMercaDAWTest {
    
    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.CAJERO, "Luis", "Enrique", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Carlo", "Ancelotti", 2);
    Nomina n = new NominaMercaDAW(0, 0, 0, 0, 0, 0, 0);
    
    @Test
    void calcularNominaTest(){
        
        System.err.println(n.calcularNomina(e1));
        n.calcularNomina(e2);
    }

}
