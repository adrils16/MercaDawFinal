package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.TipoIVA;

/**
 * Clase que representa el estado de un objeto de tipo Alimentación.
 */
public class Alimentacion extends Producto {

    public final static TipoIVA IVA = TipoIVA.SUPERREDUCIDO;
    
    public Alimentacion(String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion, String categoria) {

        super(nombre, marca, precio, caracteristica, descripcion, categoria);
        this.valorIVA = IVA.getValor();
          
    }
    
}
