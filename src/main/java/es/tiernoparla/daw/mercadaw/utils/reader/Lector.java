package es.tiernoparla.daw.mercadaw.utils.reader;

import java.io.File;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.exception.FicheroException;
import es.tiernoparla.daw.mercadaw.exception.LectorException;

/**
 * Interfaz que define los métodos que deben implementar las clases que lean
 * productos y empleados de un fichero.
 */
public interface Lector {

    /**
     * Lee un fichero CSV y devuelve una lista de productos.
     * 
     * @param cadena Contenido del fichero CSV.
     * @return Lista de productos.
     * @throws LectorException Si hay un error al leer el fichero.
     */
    public List<Gestionable> leerProducto(String cadena) throws LectorException;

    /**
     * Lee un fichero CSV y devuelve una lista de empleados.
     * 
     * @param cadena Contenido del fichero CSV.
     * @return Lista de empleados.
     * @throws LectorException Si hay un error al leer el fichero.
     */
    public List<Gestionable> leerEmpleado(String cadena) throws LectorException;

    /**
     * Carga el contenido de un fichero.
     * 
     * @param file Fichero a cargar.
     * @return Contenido del fichero.
     * @throws FicheroException Si hay un error al cargar el fichero.
     */
    public String cargar(File fichero) throws Exception;
}