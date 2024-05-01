package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.enumeracion.CategoriaProducto;
import es.tiernoparla.daw.mercadaw.model.enumeracion.TipoIVA;

public class Drogueria extends Producto{

    public final static CategoriaProducto CATEGORIA = CategoriaProducto.DROGUERIA;
    public final static TipoIVA IVA = TipoIVA.REDUCIDO;

    public Drogueria(String nombre, String marca, double precio, double altura, double anchura, double peso,
            int numElementos, String descripcion) {
        super(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
        //TODO Auto-generated constructor stub
    }
    
    

}
