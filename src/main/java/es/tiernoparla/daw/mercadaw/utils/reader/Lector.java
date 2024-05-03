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
    public List<Producto> leerProducto(String cadena) throws LectorException;
    public List<Empleado> leerEmpleado(String cadena) throws LectorException; 
}