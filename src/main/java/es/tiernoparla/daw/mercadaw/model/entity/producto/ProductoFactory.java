package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class ProductoFactory {
    
    public static Producto crear(CategoriaProducto tipo, String nombre, String marca, double precio, Caracteristica caracteristica, String descripcion) {

        final String C_ALIMENTACION = "Alimentación";
        final String C_DROGUERIA = "Droguería";
        final String C_COSMETICA = "Cosmética";

        Producto p = null;
        String categoria;

        switch (tipo) {
            
            case ALIMENTACION:
                categoria = C_ALIMENTACION;
                p = new Alimentacion(nombre, marca, precio, caracteristica, descripcion, categoria);
                break;
        
            case DROGUERIA:
                categoria = C_DROGUERIA;
                p = new Drogueria(nombre, marca, precio, caracteristica, descripcion, categoria);
                break;

            case COSMETICA: 
                categoria = C_COSMETICA;
                p = new Cosmetica(nombre, marca, precio, caracteristica, descripcion, categoria);
                break;

        }

        return p;
    }

}
