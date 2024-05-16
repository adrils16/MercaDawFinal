package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class MercaDawMockDAOImp extends MercaDawDAOImp{

    @Override
    public int actualizar(Producto producto) throws SQLException {
        return 0;
    }

    @Override
    public int actualizar(Empleado empleado) throws SQLException {
        return 0;
    }

    @Override
    public int borrar(Producto producto) throws SQLException {
        return 0;
    }

    @Override
    public int borrar(Empleado empleado) throws SQLException {
        return 0;
    }

    @Override
    public void crearTablaCompras() throws SQLException {
        
    }

    @Override
    public void crearTablaEmpleados() throws SQLException {
    
    }

    @Override
    public void crearTablaProductos() throws SQLException {
        
    }

    @Override
    public int insertar(Producto producto) throws SQLException {
        return 0;
    }

    @Override
    public int insertar(List<Producto> productos) throws SQLException {
        return 0;
    }

    @Override
    public int insertar(Empleado empleado) throws SQLException {
        return 0;
    }

    @Override
    public int insertar(Empleado[] empleados) throws SQLException {
        return 0;
    }
    
}
