package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class MercaDawMockDAOImp extends MercaDawDAOImp{

    public MercaDawMockDAOImp() {
        super();
    }

    @Override
    public int insertar(Producto producto) throws SQLException {
        return 0;
    }

    @Override
    public int insertarProductos(List<Producto> productos) throws SQLException {
        return 0;
    }

    @Override
    public int insertar(Empleado empleado) throws SQLException {
        return 0;
    }

    @Override
    public int insertarEmpleados(List<Empleado> empleados) throws SQLException {
        return 0;
    }
    
}
