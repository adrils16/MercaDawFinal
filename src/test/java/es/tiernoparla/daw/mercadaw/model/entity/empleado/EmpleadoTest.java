package es.tiernoparla.daw.mercadaw.model.entity.empleado;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;

public class EmpleadoTest {
    
    Empleado e = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Adrian", "Lopez", 1);

    @Test
    public void imprimirEmpleado() {
        System.out.println(e.imprimir());
    }
}
