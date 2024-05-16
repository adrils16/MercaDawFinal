package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class MercaDawMariaDBDAOImpTest {

    //MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);

    // Empleados
    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.CAJERO, "Luis", "Enrique", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Carlo", "Ancelotti", 2);
    
    // Productos
    Caracteristica c1 = new Caracteristica(0.2, 0.2, 0.4, 6);
    Producto p1 = ProductoFactory.crear(CategoriaProducto.ALIMENTACION, "Leche", "Hacendado", 2.45, c1, "Leche entera de la marca Hacendado");
    
    Caracteristica c2 = new Caracteristica(0.2, 0.2, 0.4, 4);
    Producto p2 = ProductoFactory.crear(CategoriaProducto.DROGUERIA, "Lejia", "KH7", 1.25, c2, "Lejia de la marca KH7");
    
    @Test
    public void crearTablaEmpleadoTest() throws SQLException{
        //dao.crearTablaEmpleados();
    }
    
    @Test
    public void crearTablaProductoTest() throws SQLException{
        //dao.crearTablaProductos();
    }
    
    @Test
    public void insertarEmpleadoTest() throws SQLException{
        //dao.insertar(e1);
        //dao.insertar(e2);
    }

    @Test
    public void insertarProductosTest() throws SQLException{
        //dao.insertar(p1);
        //dao.insertar(p2);
    }
}
