package es.tiernoparla.daw.mercadaw.model;

import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

/**
 * Interfaz que define el comportamiento de las clases que gestinan la información de la empresa.
 */
public interface MercaDaw {
    
    /**
     * Añade un objeto a la lista correspondiente a su tipo.
     * @param gestionable Un objeto de tipo Gestionable.
     * @return 1 si se ha añadido o 0 si no.
     */
    public int darAlta(Gestionable gestionable);
    /**
     * Añade un conjunto de objetos a la lista correspondiente a su tipo.
     * Permite listas que combinen objetos de tipo Empleado y Producto.
     * @param gestionables Una lista de tipo Gestionable.
     * @return Número de objetos añadidos o 0 si no se ha añadido ninguno.
     */
    public int darAlta(List<Gestionable> gestionables);
    

    /**
     * Visualiza la información de un objeto de tipo Imprimible.
     * @param imprimible Cualquier objeto que implemente la interfaz imprimible.
     * @return Un String con la información del objeto.
     */
    public String visualizar(Imprimible imprimible);
    /**
     * Visualiza la información de varios objetos de tipo Imprimible.
     * @param imprimibles Una lista de objetos que implementen la interfaz imprimible.
     * @return Un String con la información de todos los objetos de la lista.
     */
    public String visualizar(List<Imprimible> imprimibles);

    /**
     * Llama al método visulizarPrecioTotal() de la clase Producto.
     * @param producto Producto del que se obtiene el precio total.
     * @return Devuelve un String con la información del precio total.
     */
    public String obtenerPrecioVenta(Producto producto);
    /**
     * Llama al método imprimirEtiqueta() de la clase Producto.
     * @param producto Producto del que se obtiene la etiqueta.
     * @return Devuelve un String con la información de la etiqueta.
     */
    public String imprimirEtiqueta(Producto producto);

    /**
     * Crea una nómina llamando a la interfaz RecursosHumanos.
     * @param empleado Empleado del que se obtiene su nómina.
     * @return Devuelve un String con la nómina.
     */
    public String calcularNominas(Empleado empleado);

}
