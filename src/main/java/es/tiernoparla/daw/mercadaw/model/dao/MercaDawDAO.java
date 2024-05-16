package es.tiernoparla.daw.mercadaw.model.dao;

import java.sql.SQLException;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

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
     * Actualiza la tupla de un determinado producto en la BD
     * @param producto Producto a actualizar
     * @return 1 si se ha actualizado corectamente
     * @throws SQLException
     */
    public int actualizar(Producto producto) throws SQLException;
    /**
     * Actualiza la tupla de un determinado empleado en la BD
     * @param empleado Empleado a actualizar
     * @return 1 si se ha actualizado correctamente
     * @throws SQLException
     */
    public int actualizar(Empleado empleado) throws SQLException;

    /**
     * Borra un determinado producto de la BD
     * @param producto Producto a eliminar
     * @return 1 si se ha eliminado correctamente
     * @throws SQLException
     */
    public int borrar(Producto producto) throws SQLException;
    /**
     * Borra un determinado empleado de la BD
     * @param empleado Empleado a eliminar
     * @return 1 si se ha eliminado correctamente
     * @throws SQLException
     */
    public int borrar(Empleado empleado) throws SQLException;
}
