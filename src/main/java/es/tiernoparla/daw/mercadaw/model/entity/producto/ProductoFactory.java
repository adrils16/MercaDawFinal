package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class ProductoFactory {
    
    public static Producto crear(CategoriaProducto tipo, String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion) {

        Producto p = null;

        switch (tipo) {
            
            case ALIMENTACION:
                p = new Alimentacion(nombre, marca, precio, caracteristica, descripcion);
                break;
        
            case DROGUERIA:
                p = new Drogueria(nombre, marca, precio, caracteristica, descripcion);
                break;

            case COSMETICA: 
                p = new Cosmetica(nombre, marca, precio, caracteristica, descripcion);
                break;

        }

        return p;
    }

}
