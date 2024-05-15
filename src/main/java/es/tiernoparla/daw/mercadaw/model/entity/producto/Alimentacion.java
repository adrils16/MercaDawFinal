package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;
import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.TipoIVA;

public class Alimentacion extends Producto {

    public final static CategoriaProducto CATEGORIA = CategoriaProducto.ALIMENTACION;
    public final static TipoIVA IVA = TipoIVA.SUPERREDUCIDO;
    
    public Alimentacion(String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion) {
        super(nombre, marca, precio, caracteristica, descripcion);
        this.valorIVA = IVA.getValor();   
    }
    
}
