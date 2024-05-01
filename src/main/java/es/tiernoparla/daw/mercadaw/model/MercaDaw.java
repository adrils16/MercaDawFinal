package es.tiernoparla.daw.mercadaw.model;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public interface MercaDaw {
    
    public int darAlta(Producto producto);
    public int darAlta(Empleado empleado);

    public void visualizar(Producto producto);
    public void visualizar(Empleado[] empleados);

    public String obtenerPrecioVenta(Producto producto);
    public String imprimirEtiqueta(Producto producto);

    public double calcularNominas(Empleado[] empleados);

}
