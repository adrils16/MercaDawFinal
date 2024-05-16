package es.tiernoparla.daw.mercadaw.model.entity.empleado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class SedeTest {
    
    Sede s = new Sede();
    Producto p1 = ProductoFactory.crear(CategoriaProducto.COSMETICA, "Perfume", "JPG", 50, new Caracteristica(1, 1, 1, 1), "Perfume de alta gama");
    Producto p2 = ProductoFactory.crear(CategoriaProducto.ALIMENTACION, "Tomate", "MercaDAW", 10, new Caracteristica(1, 1, 1, 1), "Tomate buenisimo");
    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Adrian", "Lopez", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.REPONEDOR, "Rodrigo", "Santamaria", 2);

    @Test
    public void addTest() {
        assertEquals(1, s.darAlta(p1));
    }

    @Test
    public void addListaTest() {
        List<Gestionable> gs = new ArrayList<>();
        gs.add(p2);
        gs.add(e1);
        gs.add(e2);
        
        assertEquals(3, s.darAlta(gs));
    }

    @Test
    public void visualizarProducto() {
        System.out.println(s.visualizar(p1));
    }

    @Test
    public void obtenerPrecioVenta() {
        System.out.println(s.obtenerPrecioVenta(p1));
    }
}
