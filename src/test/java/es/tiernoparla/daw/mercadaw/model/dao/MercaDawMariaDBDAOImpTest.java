package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.Sede;
import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.EmpleadoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums.CategoriaEmpleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.ProductoFactory;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class MercaDawMariaDBDAOImpTest {

    MercaDawDAO dao = MercaDawDAOFactory.crear(TipoDB.MARIADB);
    Sede mercadaw = new Sede();

    // Empleados
    Empleado e1 = EmpleadoFactory.crear(CategoriaEmpleado.CAJERO, "Luis", "Enrique", 1);
    Empleado e2 = EmpleadoFactory.crear(CategoriaEmpleado.ENCARGADO, "Carlo", "Ancelotti", 2);
    Empleado e3 = EmpleadoFactory.crear(CategoriaEmpleado.REPONEDOR, "Zinedine", "Zidane", 5);
    
    // Productos
    Caracteristica c1 = new Caracteristica(0.2, 0.2, 0.4, 6);
    Producto p1 = ProductoFactory.crear(CategoriaProducto.ALIMENTACION, "Leche", "Hacendado", 2.45, c1, "Leche entera de la marca Hacendado");
    
    Caracteristica c2 = new Caracteristica(0.2, 0.2, 0.4, 4);
    Producto p2 = ProductoFactory.crear(CategoriaProducto.DROGUERIA, "Lejia", "KH7", 1.25, c2, "Lejia de la marca KH7");

    Caracteristica c3 = new Caracteristica(0.2, 0.2, 0.4, 4);
    Producto p3 = ProductoFactory.crear(CategoriaProducto.COSMETICA, "Base", "Deliplus", 1.25, c3, "Base de la marca Deliplus");

    Caracteristica c4 = new Caracteristica(0.2, 0.2, 0.4, 1);
    Producto p4 = ProductoFactory.crear(CategoriaProducto.COSMETICA, "Mascara", "Deliplus", 1.25, c4, "Mascara de la marca Deliplus");

    Caracteristica c5 = new Caracteristica(0.2, 0.2, 0.4, 1);
    Producto p5 = ProductoFactory.crear(CategoriaProducto.COSMETICA, "Sombra", "Deliplus", 1.25, c5, "Sombra de la marca Deliplus");

    Producto p6 = ProductoFactory.crear(CategoriaProducto.ALIMENTACION, "Cereales de Lecha", "Hacendado", 1.75, new Caracteristica(0.5, 0.2, 0.9, 1), "Cereales de trigo con leche de la marca Hacendado");

    @Test
    public void insertarEmpleadoTest() throws SQLException{
        dao.insertar(e1);
        dao.insertar(e2);
        dao.insertar(e3);
    }

    @Test
    public void insertarListaEmpleadosTest() throws SQLException{
        mercadaw.darAlta(e1);
        mercadaw.darAlta(e2);
        mercadaw.darAlta(e3);

        dao.insertarEmpleados(mercadaw.getEmpleados());
    }

    @Test
    public void insertarProductosTest() throws SQLException{
        dao.insertar(p1);
        dao.insertar(p2);
        dao.insertar(p3);
        dao.insertar(p4);
        dao.insertar(p5);
    }

    @Test
    public void insertarListaProductosTest() throws SQLException{
        mercadaw.darAlta(p3);
        mercadaw.darAlta(p4);
        mercadaw.darAlta(p5);

        dao.insertarProductos(mercadaw.getProductos());
    }
}
