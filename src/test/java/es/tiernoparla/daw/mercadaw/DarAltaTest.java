package es.tiernoparla.daw.mercadaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class DarAltaTest {

    Sede mercadaw = new Sede();
    
    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.CAJERO, "Luis", "Enrique", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Carlo", "Ancelotti", 2);

    Caracteristica c1 = new Caracteristica(0.2, 0.2, 0.4, 6);
    Producto p1 = ProductoFactory.crear(CategoriaProducto.ALIMENTACION, "Leche", "Hacendado", 2.45, c1, "Leche entera de la marca Hacendado");

    Caracteristica c2 = new Caracteristica(0.2, 0.2, 0.4, 4);
    Producto p2 = ProductoFactory.crear(CategoriaProducto.DROGUERIA, "Lejia", "KH7", 1.25, c2, "Lejia de la marca KH7");
    
    @Test
    public void darAltaEmpleadoTest() {
        mercadaw.darAlta(e1);
        mercadaw.darAlta(e2);
        mercadaw.darAlta(p1);
        assertEquals(3, mercadaw.getEmpleados().size());
    }

    @Test
    public void darAltaProductoTest() {
        mercadaw.darAlta(p1);
        mercadaw.darAlta(p2);
        assertEquals(2, mercadaw.getProductos().size());
    }
}
