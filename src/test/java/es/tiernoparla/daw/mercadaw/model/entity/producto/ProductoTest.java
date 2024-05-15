package es.tiernoparla.daw.mercadaw.model.entity.producto;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.entity.producto.enums.CategoriaProducto;

public class ProductoTest {

    final Caracteristica c = new Caracteristica(0.2, 0.2, 0.4, 1);
    final Producto p = ProductoFactory.crear(CategoriaProducto.ALIMENTACION, "Lata de tomate", "Tiernoplus", 1, c, "Es una lata de tomate de primera calidad de nuestra marca TiernoPlus");
    
    @Test
    public void mostrarRecargos() {
        
        System.out.println(c.visualizarRecargos(1.25));

    }

    @Test
    public void mostrarPrecioTotal() {

        System.out.println(p.visualizarPrecioTotal());
        
    }
}
