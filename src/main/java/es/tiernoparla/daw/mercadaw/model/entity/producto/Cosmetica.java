package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.enums.CategoriaProducto;
import es.tiernoparla.daw.mercadaw.model.enums.TipoIVA;

public class Cosmetica extends Producto{

    public final static CategoriaProducto CATEGORIA = CategoriaProducto.COSMETICA;
    public final static TipoIVA IVA = TipoIVA.GENERAL;

    public Cosmetica(String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion) {
        super(nombre, marca, precio, caracteristica, descripcion);
        //TODO Auto-generated constructor stub
    }

}
