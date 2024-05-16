package es.tiernoparla.daw.mercadaw.model;

import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Gestionable;
import es.tiernoparla.daw.mercadaw.model.entity.interfaces.Imprimible;
import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public interface MercaDaw {
    
    public int darAlta(Gestionable gestionable);
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

    public double calcularNominas(List<Empleado> empleados);

}
