package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public interface MercaDawDAO {
    /**
     * Crea la tabla producto en la base de datos
     * @throws SQLException
     */
    public void crearTablaProductos() throws SQLException;
    public void crearTablaEmpleados() throws SQLException;
    public void crearTablaCompras() throws SQLException;

    public int insertar(Producto producto)throws SQLException;
    public int insertar(List<Producto> productos)throws SQLException;
    public int insertar(Empleado empleado)throws SQLException;
    public int insertar(Empleado[] empleados)throws SQLException;

    public int actualizar(Producto producto) throws SQLException;
    public int actualizar(Empleado empleado) throws SQLException;

    public int borrar(Producto producto) throws SQLException;
    public int borrar(Empleado empleado) throws SQLException;
}
