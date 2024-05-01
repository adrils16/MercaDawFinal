package es.tiernoparla.daw.mercadaw.model;

import java.util.ArrayList;
import java.util.List;

import es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.Empleado;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class Sede implements MercaDaw {

    public final static int NUM_EMPLEADOS = 432;

    private List<Producto> productos = new ArrayList<>();
    private Empleado[] empleados = new Empleado[NUM_EMPLEADOS];


    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    @Override
    public int darAlta(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darAlta'");
    }

    @Override
    public int darAlta(Empleado empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'darAlta'");
    }

    @Override
    public void visualizar(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarProductos'");
    }

    @Override
    public void visualizar(Empleado[] empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualizarEmpleados'");
    }

    @Override
    public String obtenerPrecioVenta(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPrecioVenta'");
    }

    @Override
    public String imprimirEtiqueta(Producto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirEtiqueta'");
    }

    @Override
    public double calcularNominas(Empleado[] empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularNominas'");
    }
    
}
