package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.enumeracion.CategoriaProducto;

public class ProductoFactory {
    
    public static Producto crear(CategoriaProducto tipo, String nombre, String marca, double precio, double altura, double anchura, double peso, int numElementos, String descripcion) {

        Producto p = null;

        switch (tipo) {
            
            case ALIMENTACION:
                p = new Alimentacion(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
                break;
        
            case DROGUERIA:
                p = new Drogueria(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
                break;

            case COSMETICA: 
                p = new Cosmetica(nombre, marca, precio, altura, anchura, peso, numElementos, descripcion);
                break;

        }

        return p;
    }

}
