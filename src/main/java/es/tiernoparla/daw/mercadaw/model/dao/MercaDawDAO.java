package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public interface MercaDawDAO {
    
    public void crearTablaProductos() throws SQLException;
    public void crearTablaEmpleados() throws SQLException;
    public void crearTablaCompras() throws SQLException;

    public int insertar(Producto producto);
    public int insertar(List<Producto> productos);
    public int insertar(Empleado empleado);
    public int insertar(Empleado[] empleados);

    public int actualizar(Producto producto);
    public int actualizar(Empleado empleado);

    public int borrar(Producto producto);
    public int borrar(Empleado empleado);
}
