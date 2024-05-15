package es.tiernoparla.daw.mercadaw.utils.reader;

import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

import es.tiernoparla.daw.mercadaw.exception.LectorException;

/**
 * Interfaz que define los métodos que deben implementar las clases que lean
 * productos y empleados de un fichero.
 * 
 * @version 1.0
 */
public interface Lector {

    /**
     * Lee un fichero CSV y devuelve una lista de productos.
     * 
     * @param cadena Contenido del fichero CSV.
     * @return Lista de productos.
     * @throws LectorException Si hay un error al leer el fichero.
     */
    public List<Producto> leerProducto(String cadena) throws LectorException;

    /**
     * Lee un fichero CSV y devuelve una lista de empleados.
     * 
     * @param cadena Contenido del fichero CSV.
     * @return Lista de empleados.
     * @throws LectorException Si hay un error al leer el fichero.
     */
    public List<Empleado> leerEmpleado(String cadena) throws LectorException;
}