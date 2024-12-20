package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.TipoIVA;

/**
 * Esta clase representa el estado de los objetos de tipo Drogueria.
 */
public class Drogueria extends Producto{

    public final static TipoIVA IVA = TipoIVA.REDUCIDO;
    
    public Drogueria(String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion, String categoria) {

        super(nombre, marca, precio, caracteristica, descripcion, categoria);
        this.valorIVA = IVA.getValor();
        
    }
    
}
