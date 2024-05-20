package es.tiernoparla.daw.mercadaw.model.entity.producto;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

/**
 * Clase Factory de la clase Producto, que crea objetos de tipo Alimentacion, Drogueria y Cosmetica.
 */
public class ProductoFactory {
    
    /**
     * Crea un objeto de tipo Producto.
     * @param tipo Categoria del Producto, ya sea Alimentacion, Drogueria o Cosmetica.
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param precio Precio del producto.
     * @param caracteristica Objeto de tipo Caracteristica, que define la altura, la anchura, el peso y el número de elementos del Producto.
     * @param descripcion Descripción del producto.
     * @return Un objeto de tipo Producto.
     */
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
