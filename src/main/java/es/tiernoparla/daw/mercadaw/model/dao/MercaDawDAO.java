package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

/**
 * Interfaz que define todos los métodos de uso de la base de datos.
 */
public interface MercaDawDAO {

    /**
     * Inserta un único producto en la tabla Productos
     * @param producto Producto que se va a insertar
     * @return 1 si se ha insertado correctamente
     * @throws SQLException
     */
    public int insertar(Producto producto)throws SQLException;

    /**
     * Inserta varios productos en la tabla Productos
     * @param productos Lista de productos a insertar
     * @return número de productos insertados
     * @throws SQLException
     */
    public int insertarProductos(List<Producto> productos)throws SQLException;

    /**
     * Inserta un único empleado en la tabla Empleados
     * @param empleado Empleado que se va a insertar
     * @return 1 si he insertado correctamente
     * @throws SQLException
     */
    public int insertar(Empleado empleado)throws SQLException;

    /**
     * Inserta varios empleados en la tabla Empleados
     * @param empleados Lista de empleados a insertar
     * @return número de empleados insertados
     * @throws SQLException
     */
    public int insertarEmpleados(List<Empleado> empleados)throws SQLException;

    /**
     * Devuelve una lista de empleados
     * @return Lista de Empleados
     * @throws SQLException
     */
    public List<Empleado> visualizarListaEmpleados() throws SQLException;

    /**
     * Devuelve una lista de productos obtenida de la vista VISTA_PRODUCTOS en la BD.
     * @return Una lista de productos.
     * @throws SQLException
     */
    public List<Producto> visualizarListaProductos() throws SQLException;
}
