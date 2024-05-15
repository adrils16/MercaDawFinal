package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.enums.CategoriaProducto;

public class ProductoFactory {
    
    public static Producto crear(CategoriaProducto tipo, String nombre, String marca, double precio, double altura, double anchura, double peso, int numElementos, String descripcion) {

        Producto p = null;

        switch (tipo) {
            
            case ALIMENTACION:
                p = new Alimentacion();
                break;
        
            case DROGUERIA:
                p = new Drogueria();
                break;

            case COSMETICA: 
                p = new Cosmetica();
                break;

        }

        return p;
    }

}
